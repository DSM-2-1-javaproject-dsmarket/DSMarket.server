package com.dsmarket.server.config;

import com.dsmarket.server.dto.response.GetCommentResponse;
import com.dsmarket.server.entities.comment.Comment;
import org.modelmapper.PropertyMap;

public class CommentMap extends PropertyMap <Comment, GetCommentResponse>{

    @Override
    protected void configure() {
        map().setMotherCommentId(getMotherCommentIdIfExist());
        map().setPostAccountId(source.getWroteAccount().getId());
    }

    public Integer getMotherCommentIdIfExist() {
        Comment comment = source.getMotherComment();

        if(comment == null) return null;
        return comment.getId();
    }
}
