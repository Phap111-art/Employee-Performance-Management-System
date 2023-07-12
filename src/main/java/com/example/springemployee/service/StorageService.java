package com.example.springemployee.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();

    String uploadFileToCloudinary(MultipartFile file) throws IOException;


    String storeAdd(MultipartFile file);

    MultipartFile convertStringToFile(String nameFile);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    void deleteAllWithoutExtension();

    boolean isImageOrPdfFile(MultipartFile file);
}
