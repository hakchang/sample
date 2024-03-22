package com.example.media.image;

public interface ImageService {

    UploadImageResult upload(UploadImageForm form);

    DownloadImageResult download(DownloadImageForm form);

}
