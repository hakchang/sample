package com.example.mybatis.domain.account.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AccountTerm(
        Long accountId,
        Long termId,
        Boolean agree,
        LocalDateTime createdDatetime,
        LocalDateTime lastModifiedDatetime,
        Term term
) {
}
