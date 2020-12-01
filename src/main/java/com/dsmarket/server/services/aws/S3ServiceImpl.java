package com.dsmarket.server.services.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.dsmarket.server.entities.image.Image;
import com.dsmarket.server.entities.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl {

    private final AmazonS3Client amazonS3Client;

    final ImageRepository imageRepository;
//
//    public String uploadFile(MultipartFile file){
//
//
//    }
//
//    private File convertMultipartFile2File(MultipartFile multipartFile){
//        File file = new File();
//
//
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.write(file.getBytes());d
//        fos.close();
//        return convFile;
//
//    }


}
