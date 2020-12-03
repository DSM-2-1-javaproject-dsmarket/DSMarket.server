package com.dsmarket.server.services.aws;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface S3Service {
    public String upload(MultipartFile multipartFile, String dirName);

}
