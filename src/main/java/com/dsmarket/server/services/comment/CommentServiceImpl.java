package com.dsmarket.server.services.comment;


import com.dsmarket.server.dto.CreateCommentDto;
import com.dsmarket.server.dto.UpdateCommentDto;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.comment.Comment;
import com.dsmarket.server.entities.comment.repository.CommentRepository;
import com.dsmarket.server.exeptions.AccessDeniedException;
import com.dsmarket.server.exeptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    public Comment createComment(CreateCommentDto createCommentDto){
        Comment newComment = Comment
                .builder()
                .content(createCommentDto.getContent())
                .isSecret(createCommentDto.getIsSecret())
                .motherComment(createCommentDto.getMotherComment())
                .wrotePost(createCommentDto.getWrotePost())
                .wroteAccount(createCommentDto.getWroteAccount())
                .build();

        return commentRepository.save(newComment);
    }

    @Override
    public Comment getComment(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void updateComment(Comment comment2update, UpdateCommentDto updateCommentDto) {
        Comment updatedComment = Comment
                .builder()
                .id(comment2update.getId())
                .wrotePost(comment2update.getWrotePost())
                .motherComment(comment2update.getMotherComment())
                .wroteAccount(comment2update.getWroteAccount())
                .isSecret(updateCommentDto.getIsSecret())
                .content(updateCommentDto.getContent())
                .build();

        commentRepository.save(updatedComment);
    }

    public void checkCommentEditAuthorization(Account account, Comment comment){
        if(!account.equals(comment.getWroteAccount())){
            throw new AccessDeniedException();
        }
    }

    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }

}
