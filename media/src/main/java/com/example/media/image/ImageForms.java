package com.example.media.image;

public class ImageForms {

    private ImageForms() {
        throw new UnsupportedOperationException();
    }

    public static UploadImageForm.UploadImageFormBuilder uploadForm() {
        return UploadImageForm.builder();
    }

    public static DownloadImageForm.DownloadImageFormBuilder downloadForm() {
        return DownloadImageForm.builder();
    }

}
