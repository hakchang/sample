package com.example.mybatis.domain.account.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Term(
        Long id,
        String title,
        String description,
        LocalDateTime createdDatetime,
        LocalDateTime lastModifiedDatetime
) {
}
