package com.example.media.image;

import java.io.InputStream;

public class UploadImageForm {

    private String fileName;
    private InputStream inputStream;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static UploadImageFormBuilder builder() {
        return UploadImageFormBuilder.anUploadImageForm();
    }

    public static final class UploadImageFormBuilder {
        private String fileName;
        private InputStream inputStream;

        private UploadImageFormBuilder() {
        }

        public static UploadImageFormBuilder anUploadImageForm() {
            return new UploadImageFormBuilder();
        }

        public UploadImageFormBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public UploadImageFormBuilder inputStream(InputStream inputStream) {
            this.inputStream = inputStream;
            return this;
        }

        public UploadImageForm build() {
            UploadImageForm uploadImageForm = new UploadImageForm();
            uploadImageForm.setFileName(fileName);
            uploadImageForm.setInputStream(inputStream);
            return uploadImageForm;
        }
    }
}
