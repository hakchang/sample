package com.example.mybatis.domain.account.model;

import lombok.Builder;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Account(
        Long id,
        String username,
        String password,
        String nickname,
        String thumbnail,
        LocalDateTime createdDatetime,
        LocalDateTime lastModifiedDatetime,
        User user,
        List<AccountTerm> terms
) {
}
