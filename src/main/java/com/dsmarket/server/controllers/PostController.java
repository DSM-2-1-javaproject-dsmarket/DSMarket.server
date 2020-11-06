package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.request.WritePostRequest;
import com.dsmarket.server.dto.response.WritePostResponse;
import com.dsmarket.server.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {

    private static PostService postService;

    @PostMapping
    public WritePostResponse writePost(@RequestBody WritePostRequest writePostRequest){
        Integer WrotePostId = postService.

        return WritePostResponse
                .builder()
                .build();
        return (WritePostResponse) null;
    }
}
