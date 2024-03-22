package com.example.mybatis.domain.account.model;

import java.util.Optional;

public interface Accounts {

    boolean isExist(String username);

    Optional<Account> findById(Long accountId);

    Account save(Account account);

    void updateThumbnail(Long id, String filePath);

}
