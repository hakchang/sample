package com.example.media.image.local;

import com.example.media.image.*;
import org.springframework.util.StreamUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalImageService implements ImageService {

    private final String basePath;

    public LocalImageService(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public UploadImageResult upload(UploadImageForm form) {
        try {

            Path basePath = Paths.get(this.basePath);
            if (!basePath.toFile().exists()) {
                Files.createDirectory(basePath);
            }

            Path filePath = basePath.resolve(form.getFileName());
            StreamUtils.copy(form.getInputStream(), new FileOutputStream(filePath.toFile()));
            UploadImageResult result = new UploadImageResult();
            result.setFileName(filePath.toFile().getAbsolutePath());
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DownloadImageResult download(DownloadImageForm form) {
        try {

            Path source = Path.of(this.basePath).resolve(form.getFileName());
            StreamUtils.copy(new FileInputStream(source.toFile()), form.getOutputStream());
            return new DownloadImageResult();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
