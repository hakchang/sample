package com.example.mybatis.infra.inbound.web.request;

public record TermAgreeRequest(
        Long termId,
        Boolean agree
) {
}
