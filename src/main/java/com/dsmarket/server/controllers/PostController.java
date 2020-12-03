package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.UpdatePostDto;
import com.dsmarket.server.dto.request.GetPageRequest;
import com.dsmarket.server.dto.request.WritePostRequest;
import com.dsmarket.server.dto.response.GetCommentResponse;
import com.dsmarket.server.dto.response.GetPostResponse;
import com.dsmarket.server.dto.response.GetPostsResponse;
import com.dsmarket.server.dto.response.WritePostResponse;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.comment.Comment;
import com.dsmarket.server.entities.image.Image;
import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.security.account_detail.RequestAuthentication;
import com.dsmarket.server.services.account.AccountService;
import com.dsmarket.server.dto.CreatePostForm;
import com.dsmarket.server.services.aws.S3Service;
import com.dsmarket.server.services.aws.S3ServiceImpl;
import com.dsmarket.server.services.image.ImageService;
import com.dsmarket.server.services.post.PostService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final AccountService accountService;

    private final ImageService imageService;

    private final RequestAuthentication requestAuthentication;

    private final ModelMapper modelMapper;

    private final S3Service s3Service;

    @PostMapping
    public WritePostResponse writePost(@ModelAttribute(value = "json") @Valid WritePostRequest writePostRequest,
                                       @RequestParam(value = "image") MultipartFile image){
        Account writeAccount = accountService.getAccountById(requestAuthentication.getAccountId());

        Image itemImage = null;
        if(image != null){
            String imageUrl = s3Service.upload(image, "image");
            itemImage = imageService.createImage(imageUrl);
        }

        Post wrotePost = postService.createPost(
                CreatePostForm
                        .builder()
                        .item(writePostRequest.getItem())
                        .postType(writePostRequest.getPostType())
                        .tag(writePostRequest.getTag())
                        .price(writePostRequest.getPrice())
                        .postAccount(writeAccount)
                        .content(writePostRequest.getContent())
                        .itemImage(itemImage)
                        .build()
        );

        return WritePostResponse
                .builder()
                .postId(wrotePost.getId())
                .build();
    }

    @GetMapping
    public List<GetPostsResponse> getPosts(@RequestBody @Valid GetPageRequest pageRequest) {
        List<Post> posts = postService.getPosts(PageRequest.of(
                pageRequest.getPage()
                , pageRequest.getSize()
                , pageRequest.getDirection()
                , "id"
        ));
        List<GetPostsResponse> responses = new ArrayList<GetPostsResponse>();

        for(int i = 0; i < posts.size(); i++){
            Post post = posts.get(i);

            GetPostsResponse response = GetPostsResponse
                    .builder()
                    .finished(post.getFinished())
                    .item(post.getItem())
                    .id(post.getId())
                    .itemImageUrl(post.getItemImage().getUrl())
                    .postDate(post.getPostDate())
                    .postType(post.getPostType())
                    .postUser(post.getWroteAccount().getId())
                    .price(post.getPrice())
                    .tag(post.getTag())
                    .view(post.getView())
                    .build();

            responses.add(response);
        }
        return responses;

//        return posts.stream()
//                .map((e)-> modelMapper.map(e, GetPostsResponse.class))
//                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    GetPostResponse getPost(@PathVariable Integer id){
        Post post = postService.getPost(id);
        return GetPostResponse.builder()
                .content(post.getContent())
                .finished(post.getFinished())
                .item(post.getItem())
                .id(post.getId())
                .itemImageUrl(post.getItemImage().getUrl())
                .postDate(post.getPostDate())
                .postType(post.getPostType())
                .postUser(post.getWroteAccount().getId())
                .price(post.getPrice())
                .tag(post.getTag())
                .view(post.getView())
                .build();

//        return modelMapper.map(postService.getPost(id), GetPostResponse.class);
    }


    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        Account requestAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Post post2delete = postService.getPost(id);

        postService.checkPostEditAuthorization(requestAccount, post2delete);
        postService.deletePost(post2delete);
    }

    @PutMapping("/{id}")
    public void updatePost(@RequestBody WritePostRequest writePostRequest, @PathVariable Integer id) {
        Account requestAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Post post2update = postService.getPost(id);

        postService.checkPostEditAuthorization(requestAccount, post2update);
        postService.updatePost(
                post2update,
                UpdatePostDto
                        .builder()
                        .item(writePostRequest.getItem())
                        .postAccount(requestAccount)
                        .postType(writePostRequest.getPostType())
                        .price(writePostRequest.getPrice())
                        .tag(writePostRequest.getTag())
                        .content(writePostRequest.getContent())
                        .build()
        );
    }

    @GetMapping("/{id}/comments")
    public List<GetCommentResponse> getCommentsOfPost(@PathVariable Integer id) {
        Post post = postService.getPost(id);
        List<Comment> commentsOfPost = post.getComments();
        List<GetCommentResponse> responses = new ArrayList<GetCommentResponse>();

        for(int i = 0; i < commentsOfPost.size(); i++){
            Comment comment = commentsOfPost.get(i);
            Comment motherComment = comment.getMotherComment();


            responses.add(
                    GetCommentResponse
                            .builder()
                            .content(comment.getContent())
                            .motherCommentId((motherComment != null) ? motherComment.getId() : null)
                            .postAccountId(comment.getWroteAccount().getId())
                            .build()
            );
        }

        return responses;
    }
}