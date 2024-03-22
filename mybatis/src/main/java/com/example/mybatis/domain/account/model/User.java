package com.example.mybatis.domain.account.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record User(
        Long id,
        Long accountId,
        String name,
        String phone,
        String email,
        LocalDateTime createdDatetime,
        LocalDateTime lastModifiedDatetime
) {
}
