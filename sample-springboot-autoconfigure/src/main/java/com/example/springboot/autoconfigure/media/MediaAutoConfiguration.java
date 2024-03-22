package com.example.springboot.autoconfigure.media;

import com.example.media.image.ImageService;
import com.example.media.image.local.LocalImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AutoConfiguration
@EnableConfigurationProperties(MediaProperties.class)
public class MediaAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(MediaAutoConfiguration.class);

    @Configuration(proxyBeanMethods = false)
    static class Image {

        @Bean
        public ImageService imageUploader(MediaProperties properties) {
            log.info("init imageService... properties={}", properties);
            return new LocalImageService(properties.getBasePath());
        }
    }

}
