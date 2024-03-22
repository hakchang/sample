package com.example.media.image;

public class UploadImageResult {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "UploadImageResult{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
