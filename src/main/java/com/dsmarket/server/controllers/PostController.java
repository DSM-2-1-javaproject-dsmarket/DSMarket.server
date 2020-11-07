package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.request.WritePostRequest;
import com.dsmarket.server.dto.response.WritePostResponse;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.security.account_detail.RequestAuthentication;
import com.dsmarket.server.services.account.AccountService;
import com.dsmarket.server.services.auth.AuthService;
import com.dsmarket.server.services.post.CreatePostForm;
import com.dsmarket.server.services.post.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final AccountService accountService;

    private final RequestAuthentication requestAuthentication;

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
}

