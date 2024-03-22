package com.example.mybatis.infra.outbound.db.mybatis.adapter;

import com.example.mybatis.domain.account.model.Account;
import com.example.mybatis.domain.account.model.Accounts;
import com.example.mybatis.infra.outbound.db.mybatis.entity.AccountEntity;
import com.example.mybatis.infra.outbound.db.mybatis.entity.AccountTermEntity;
import com.example.mybatis.infra.outbound.db.mybatis.entity.UserEntity;
import com.example.mybatis.infra.outbound.db.mybatis.mapper.AccountMapper;
import com.example.mybatis.infra.outbound.db.mybatis.mapper.AccountTermMapper;
import com.example.mybatis.infra.outbound.db.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class MyBatisAccountsAdapter implements Accounts {

    private final AccountMapper accountMapper;
    private final UserMapper userMapper;
    private final AccountTermMapper accountTermMapper;

    public MyBatisAccountsAdapter(AccountMapper accountMapper, UserMapper userMapper, AccountTermMapper accountTermMapper) {
        this.accountMapper = accountMapper;
        this.userMapper = userMapper;
        this.accountTermMapper = accountTermMapper;
    }

    @Override
    public boolean isExist(String username) {
        return accountMapper.countByUsername(username) > 0;
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        Optional<AccountEntity> found = accountMapper.selectById(accountId);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        AccountEntity account = found.get();
//        account.getUser();
//        account.getTerms();
        return Optional.of(account.toDomain());
    }

    @Transactional
    @Override
    public Account save(Account form) {

        LocalDateTime now = LocalDateTime.now();
        AccountEntity account = AccountEntity.from(form);
        Optional<AccountEntity> found = accountMapper.selectByUsername(account.getUsername());

        //add account
        if (found.isEmpty()) {
            account.setCreatedDatetime(now);
            accountMapper.insert(account);
        } else {
            account.setLastModifiedDatetime(now);
            accountMapper.update(AccountEntity.from(form));
        }
        final Long accountId = account.getId();

        //add user
        UserEntity user = account.getUser();
        user.setAccountId(accountId);
        user.setCreatedDatetime(now);
        user.setLastModifiedDatetime(now);
        userMapper.insert(user);

        //add terms
        for (AccountTermEntity term : account.getTerms()) {
            term.setAccountId(accountId);
            term.setCreatedDatetime(now);
            term.setLastModifiedDatetime(now);
            accountTermMapper.insert(term);
        }

        return account.toDomain();
    }

    @Override
    public void updateThumbnail(Long id, String filePath) {
        Optional<AccountEntity> found = accountMapper.selectById(id);
        if (found.isPresent()) {
            AccountEntity account = found.get();
            account.setThumbnail(filePath);
            account.setLastModifiedDatetime(LocalDateTime.now());
            accountMapper.update(account);
        }
    }
}
