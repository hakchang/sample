package com.example.mybatis.infra.outbound.db.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.mybatis.domain.account.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {

    private Long id;
    private Long accountId;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime createdDatetime;
    private LocalDateTime lastModifiedDatetime;

    public static UserEntity from(User domain) {

        if (domain == null) {
            return null;
        }

        return UserEntity.builder()
                .id(domain.id())
                .accountId(domain.accountId())
                .name(domain.name())
                .phone(domain.phone())
                .email(domain.email())
                .createdDatetime(domain.createdDatetime())
                .lastModifiedDatetime(domain.lastModifiedDatetime())
                .build();
    }

    public User toDomain() {
        return User.builder()
                .id(id)
                .accountId(accountId)
                .name(name)
                .phone(phone)
                .email(email)
                .createdDatetime(createdDatetime)
                .lastModifiedDatetime(lastModifiedDatetime)
                .build();
    }
}