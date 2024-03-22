package com.example.mybatis.domain.account;

import com.example.mybatis.domain.account.model.Account;
import com.example.mybatis.domain.account.model.AccountTerm;

import java.io.InputStream;
import java.util.Optional;

public interface AccountService {

    Account addAccount(Account account);

    Optional<Account> getAccount(Long id);

    void updateAccount(Account account);

    void updateTermAgree(AccountTerm accountTerm);

    String updateThumbnail(Long id, InputStream inputStream);

    void deleteAccount(Long accountId);

}
