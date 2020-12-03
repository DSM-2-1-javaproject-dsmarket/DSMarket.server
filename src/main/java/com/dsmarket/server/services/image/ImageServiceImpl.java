package com.dsmarket.server.services.image;

import com.dsmarket.server.entities.image.Image;
import com.dsmarket.server.entities.image.repository.ImageRepository;
import com.dsmarket.server.services.aws.S3ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;

    private final S3ServiceImpl s3Service;


    @Override
    public Integer saveImage(MultipartFile image) {
        return null;
    }

    public Image createImage(String url){
        Image newImage = Image
                .builder()
                .Url(url)
                .build();

        return imageRepository.save(newImage);
    }


}
