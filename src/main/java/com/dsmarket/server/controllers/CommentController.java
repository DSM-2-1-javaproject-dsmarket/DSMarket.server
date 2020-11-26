package com.dsmarket.server.controllers;

import com.dsmarket.server.dto.CreateCommentDto;

import com.dsmarket.server.dto.UpdateCommentDto;
import com.dsmarket.server.dto.request.UpdateCommentRequest;
import com.dsmarket.server.dto.request.WriteCommentRequest;

import com.dsmarket.server.dto.response.WriteCommentResponse;

import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.comment.Comment;

import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.security.account_detail.RequestAuthentication;
import com.dsmarket.server.services.account.AccountService;
import com.dsmarket.server.services.comment.CommentService;
import com.dsmarket.server.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/comments")
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final ModelMapper modelMapper;
    private final CommentService commentService;
    private final RequestAuthentication requestAuthentication;
    private final PostService postService;
    private final AccountService accountService;

    @PostMapping
    public void writeComment(@Valid @RequestBody WriteCommentRequest writeCommentRequest) {
        Account writeAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Post wrotePost = postService.getPost(writeCommentRequest.getPostId());
        Comment motherComment = null;

        if(writeCommentRequest.getMotherCommentId() != null){
            motherComment= commentService.getComment(writeCommentRequest.getMotherCommentId());
        }

        Comment newComment = commentService.createComment(
                CreateCommentDto
                        .builder()
                        .content(writeCommentRequest.getContent())
                        .isSecret(writeCommentRequest.getIsSecret())
                        .motherComment(motherComment)
                        .wrotePost(wrotePost)
                        .wroteAccount(writeAccount)
                        .build()
        );

//        return new WriteCommentResponse();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        Account requestAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Comment comment2delete = commentService.getComment(id);

        commentService.checkCommentEditAuthorization(requestAccount, comment2delete);
        commentService.deleteComment(comment2delete);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Integer id, @Valid @RequestBody UpdateCommentRequest updateCommentRequest){
        Account writeAccount = accountService.getAccountById(requestAuthentication.getAccountId());
        Comment comment2update = commentService.getComment(id);

        commentService.updateComment(
                comment2update,
                UpdateCommentDto
                        .builder()
                        .content(updateCommentRequest.getContent())
                        .isSecret(updateCommentRequest.getIsSecret())
                        .build()
        );
    }

}