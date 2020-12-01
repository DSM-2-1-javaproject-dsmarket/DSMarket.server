package com.dsmarket.server.entities.image.repository;

import com.dsmarket.server.entities.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
