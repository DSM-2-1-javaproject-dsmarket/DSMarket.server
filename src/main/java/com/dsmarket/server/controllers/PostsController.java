package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.request.GetPageRequest;
import com.dsmarket.server.dto.request.WritePostRequest;
import com.dsmarket.server.dto.response.GetPostsResponse;
import com.dsmarket.server.dto.response.WritePostResponse;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.security.account_detail.RequestAuthentication;
import com.dsmarket.server.services.account.AccountService;
import com.dsmarket.server.services.post.CreatePostForm;
import com.dsmarket.server.services.post.PostsService;

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
public class PostsController {

    private final PostsService postsService;

    private final AccountService accountService;

    private final RequestAuthentication requestAuthentication;

    private final ModelMapper modelMapper;

    @PostMapping
    public WritePostResponse writePost(@RequestBody @Valid WritePostRequest writePostRequest){

        Account writeAccount = accountService.getAccountById(requestAuthentication.getAccountId());

        Post wrotePost = postsService.createPost(
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
    public List<GetPostsResponse> getPosts(@RequestBody GetPageRequest pageRequest) {
        List<Post> posts = postsService.getPosts(PageRequest.of(
                pageRequest.getPage()
                , pageRequest.getSize()
                , pageRequest.getDirection()
                , "id"
        ));

        return posts.stream()
                .map((e)-> modelMapper.map(e, GetPostsResponse.class))
                .collect(Collectors.toList());
    }
}

