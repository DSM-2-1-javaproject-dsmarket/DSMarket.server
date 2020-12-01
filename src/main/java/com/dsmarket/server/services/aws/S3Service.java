package com.dsmarket.server.services.aws;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

    public Integer uploadFile(MultipartFile file);

}
