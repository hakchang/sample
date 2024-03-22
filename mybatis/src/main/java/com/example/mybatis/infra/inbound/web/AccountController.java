package com.example.mybatis.infra.inbound.web;

import com.example.mybatis.domain.account.AccountService;
import com.example.mybatis.infra.inbound.web.request.AccountAddRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccount(@RequestBody AccountAddRequest request) {
        accountService.addAccount(request.toDomain());
    }

    @PostMapping("/{id}")
    public void modifyThumbnail(@PathVariable Long id, MultipartFile file) {
        try {
            String uploadPath = accountService.updateThumbnail(id, file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
