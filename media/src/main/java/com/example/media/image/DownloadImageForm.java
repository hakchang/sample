package com.example.media.image;

import java.io.OutputStream;

public class DownloadImageForm {

    private String fileName;
    private OutputStream outputStream;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static DownloadImageFormBuilder builder() {
        return DownloadImageFormBuilder.aDownloadImageForm();
    }

    public static final class DownloadImageFormBuilder {
        private String fileName;
        private OutputStream outputStream;

        private DownloadImageFormBuilder() {
        }

        public static DownloadImageFormBuilder aDownloadImageForm() {
            return new DownloadImageFormBuilder();
        }

        public DownloadImageFormBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public DownloadImageFormBuilder outputStream(OutputStream outputStream) {
            this.outputStream = outputStream;
            return this;
        }

        public DownloadImageForm build() {
            DownloadImageForm downloadImageForm = new DownloadImageForm();
            downloadImageForm.setFileName(fileName);
            downloadImageForm.setOutputStream(outputStream);
            return downloadImageForm;
        }
    }
}
