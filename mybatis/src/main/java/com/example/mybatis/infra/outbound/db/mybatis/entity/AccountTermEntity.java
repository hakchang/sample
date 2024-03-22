package com.example.mybatis.infra.outbound.db.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.mybatis.domain.account.model.AccountTerm;
import lombok.*;

/**
 * @TableName account_term
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class AccountTermEntity implements Serializable {

    private Long accountId;
    private Long termId;
    private Boolean agree;
    private LocalDateTime createdDatetime;
    private LocalDateTime lastModifiedDatetime;

    private TermEntity term;

    public static AccountTermEntity from(AccountTerm domain) {
        if (domain == null) {
            return null;
        }
        return AccountTermEntity.builder()
                .accountId(domain.accountId())
                .termId(domain.termId())
                .agree(domain.agree())
                .createdDatetime(domain.createdDatetime())
                .lastModifiedDatetime(domain.lastModifiedDatetime())
                .term(TermEntity.from(domain.term()))
                .build();
    }

    public AccountTerm toDomain() {
        return AccountTerm.builder()
                .accountId(accountId)
                .termId(termId)
                .agree(agree)
                .createdDatetime(createdDatetime)
                .lastModifiedDatetime(lastModifiedDatetime)
                .term(term == null ? null : term.toDomain())
                .build();
    }
}