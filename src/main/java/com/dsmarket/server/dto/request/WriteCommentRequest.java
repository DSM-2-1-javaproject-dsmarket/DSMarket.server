package com.dsmarket.server.dto.request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class WriteCommentRequest {

    @NotNull
    private Integer postId;

    private Integer motherCommentId;

    @NotNull
    private Boolean isSecret;

    @NotEmpty
    @NotNull
    private String content;

}
