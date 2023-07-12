package com.example.springemployee.api;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.mapping.Map;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        String photo = "avatar-employee/img2_ogieih";
        String filename = photo.substring(photo.lastIndexOf('/') );
        String publicId = "avatar-employee/" + filename;
        System.out.println(publicId);
    }
}
