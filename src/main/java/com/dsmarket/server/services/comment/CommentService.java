package com.dsmarket.server.services.comment;

import com.dsmarket.server.dto.CreateCommentDto;
import com.dsmarket.server.dto.UpdateCommentDto;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.comment.Comment;

public interface CommentService {

    public Comment createComment(CreateCommentDto createCommentDto);

    public Comment getComment(Integer commentId);

    public void updateComment(Comment comment2update, UpdateCommentDto updateCommentDto);

    public void checkCommentEditAuthorization(Account account, Comment comment);

    public void deleteComment(Comment comment);

}
