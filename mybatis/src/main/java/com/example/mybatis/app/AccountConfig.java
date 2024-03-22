package com.example.mybatis.app;

import com.example.media.image.ImageService;
import com.example.mybatis.domain.account.AccountService;
import com.example.mybatis.domain.account.DefaultAccountService;
import com.example.mybatis.domain.account.model.Accounts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    public AccountService accountService(Accounts accounts, ImageService imageService) {
        return new DefaultAccountService(accounts, imageService);
    }

}
