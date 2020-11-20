package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.request.GetPageRequest;
import com.dsmarket.server.dto.request.WritePostRequest;
import com.dsmarket.server.dto.response.GetPostResponse;
import com.dsmarket.server.dto.response.GetPostsResponse;
import com.dsmarket.server.dto.response.WritePostResponse;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.security.account_detail.RequestAuthentication;
import com.dsmarket.server.services.account.AccountService;
import com.dsmarket.server.services.post.CreatePostForm;
import com.dsmarket.server.services.post.PostService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final AccountService accountService;

    private final RequestAuthentication requestAuthentication;

    private final ModelMapper modelMapper;

    @PostMapping
    public WritePostResponse writePost(@RequestBody @Valid WritePostRequest writePostRequest){

        Account writeAccount = accountService.getAccountById(requestAuthentication.getAccountId());

        Post wrotePost = postService.createPost(
                CreatePostForm
                        .builder()
                        .item(writePostRequest.getItem())
                        .postType(writePostRequest.getPostType())
                        .tag(writePostRequest.getTag())
                        .price(writePostRequest.getPrice())
                        .postAccountId(writeAccount.getId())
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

        return posts.stream()
                .map((e)-> modelMapper.map(e, GetPostsResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    GetPostResponse getPost(@PathVariable Integer id){
        return modelMapper.map(postService.getPost(id), GetPostResponse.class);
    }


    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        Account requestAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Post post2delete = postService.getPost(id);

        postService.checkPostEditAuthorization(requestAccount, post2delete);
        postService.deletePost(post2delete);
    }

    @PutMapping("/{id}")
    public void updatePost(@RequestBody WritePostRequest writePostRequest, @PathVariable Integer id){
        Account requestAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Post post2update = postService.getPost(id);

        postService.checkPostEditAuthorization(requestAccount, post2update);
        postService.updatePost(
                post2update,
                CreatePostForm
                        .builder()
                        .item(writePostRequest.getItem())
                        .postAccountId(requestAccount.getId())
                        .postType(writePostRequest.getPostType())
                        .price(writePostRequest.getPrice())
                        .tag(writePostRequest.getTag())
                        .build()
        );
    }
}

