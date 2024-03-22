package com.example.media.image.local;

import com.example.media.image.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class LocalImageServiceTest {

    @Test
    void upload() throws FileNotFoundException {

        //given
        FileInputStream inputStream = new FileInputStream("/Users/hakchangs/Desktop/test.png");
        LocalImageService service = new LocalImageService(".local");

        //when
        UploadImageResult uploaded = service.upload(ImageForms.uploadForm()
                .fileName("image.png")
                .inputStream(inputStream)
                .build());

        //then
        System.out.println(uploaded);

    }

    @Test
    void download() throws FileNotFoundException {

        //given
        LocalImageService service = new LocalImageService(".local");
        FileOutputStream outputStream = new FileOutputStream(".local/test.png");

        //when
        DownloadImageResult downloaded = service.download(ImageForms.downloadForm()
                .fileName("image.png")
                .outputStream(outputStream)
                .build());

        //then
        System.out.println(downloaded);

    }
}