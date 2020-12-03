package com.dsmarket.server.services.image;

import com.dsmarket.server.entities.image.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public Integer saveImage(MultipartFile image);

    public Image createImage(String url);
}
