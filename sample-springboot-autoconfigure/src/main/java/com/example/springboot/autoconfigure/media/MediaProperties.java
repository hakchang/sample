package com.example.springboot.autoconfigure.media;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sample.media")
public class MediaProperties {

    /**
     * 미디어 파일 기본저장 위치
     */
    private String basePath = ".local";

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public String toString() {
        return "MediaProperties{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
