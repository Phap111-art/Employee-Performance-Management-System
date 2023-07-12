package com.example.springemployee.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

import com.example.springemployee.service.EmployeeService;
import com.example.springemployee.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import com.cloudinary.Cloudinary;

@Controller
@RequestMapping("/display/image/")
public class ImageUploadController {
    @Autowired
    private Cloudinary cloudinary;
    private final EmployeeService employeeService;
    private final StorageService storageService;
    public ImageUploadController(EmployeeService employeeService, StorageService storageService) {
        this.employeeService = employeeService;
        this.storageService = storageService;
    }

    @GetMapping("/storage/{photo}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        try {
            Path filename = storageService.load(photo);
            byte[] buffer = Files.readAllBytes(filename);
            ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
            return ResponseEntity.ok()
                    .contentLength(buffer.length)
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(byteArrayResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/cloudinary/{photo}")
    public ResponseEntity<ByteArrayResource> getImageCloudinary(@PathVariable("photo") String photo) throws IOException {
        String publicId = "avatar-employee/" + photo;
        String url = cloudinary.url().generate(publicId);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        ResponseEntity<byte[]> response = restTemplate.exchange(
                url, HttpMethod.GET, new HttpEntity<>(headers), byte[].class);

        ByteArrayResource byteArrayResource = new ByteArrayResource(response.getBody());
        return ResponseEntity.ok()
                .contentLength(byteArrayResource.contentLength())
                .contentType(MediaType.IMAGE_JPEG)
                .body(byteArrayResource);
    }
}
