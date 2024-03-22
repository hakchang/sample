package com.example.mybatis.infra.outbound.db.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.mybatis.domain.account.model.Term;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName term
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TermEntity implements Serializable {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDatetime;
    private LocalDateTime lastModifiedDatetime;

    public static TermEntity from(Term domain) {
        if (domain == null) {
            return null;
        }
        return TermEntity.builder()
                .id(domain.id())
                .title(domain.title())
                .description(domain.description())
                .createdDatetime(domain.createdDatetime())
                .lastModifiedDatetime(domain.lastModifiedDatetime())
                .build();
    }

    public Term toDomain() {
        return Term.builder()
                .id(id)
                .title(title)
                .description(description)
                .createdDatetime(createdDatetime)
                .lastModifiedDatetime(lastModifiedDatetime)
                .build();
    }
}