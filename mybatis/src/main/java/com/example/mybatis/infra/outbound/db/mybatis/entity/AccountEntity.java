package com.example.mybatis.infra.outbound.db.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.example.mybatis.domain.account.model.Account;
import lombok.*;

/**
 * @TableName account
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter @ToString(exclude = {"user", "terms"})
public class AccountEntity implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String thumbnail;
    private LocalDateTime createdDatetime;
    private LocalDateTime lastModifiedDatetime;

    private UserEntity user;
    private List<AccountTermEntity> terms;

    public static AccountEntity from(Account account) {
        return AccountEntity.builder()
                .id(account.id())
                .username(account.username())
                .password(account.password())
                .nickname(account.nickname())
                .user(UserEntity.from(account.user()))
                .terms(account.terms().stream().map(AccountTermEntity::from).toList())
                .build();
    }

    public Account toDomain() {
        return Account.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .createdDatetime(createdDatetime)
                .lastModifiedDatetime(lastModifiedDatetime)
                .user(user == null ? null : user.toDomain())
                .terms(terms == null ? null : terms.stream().map(AccountTermEntity::toDomain).toList())
                .build();
    }
}