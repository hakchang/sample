package com.example.mybatis.infra.inbound.web.request;

import com.example.mybatis.domain.account.model.Account;
import com.example.mybatis.domain.account.model.AccountTerm;
import com.example.mybatis.domain.account.model.User;

import java.util.List;

public record AccountAddRequest(
        String username,
        String password,
        String nickname,
        String name,
        String phone,
        String email,
        String thumbnail,
        List<TermAgreeRequest> terms
) {

    public Account toDomain() {
        return Account.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .user(User.builder()
                        .name(name)
                        .phone(phone)
                        .email(email)
                        .build())
                .terms(terms.stream().map(term -> AccountTerm.builder()
                        .termId(term.termId())
                        .agree(term.agree())
                        .build()).toList())
                .build();
    }
}
