package com.example.mybatis.domain.account;

import com.example.media.image.ImageForms;
import com.example.media.image.ImageService;
import com.example.media.image.UploadImageResult;
import com.example.mybatis.domain.account.model.Account;
import com.example.mybatis.domain.account.model.AccountTerm;
import com.example.mybatis.domain.account.model.Accounts;

import java.io.InputStream;
import java.util.Optional;

public class DefaultAccountService implements AccountService {

    private final Accounts accounts;
    private final ImageService imageService;

    public DefaultAccountService(Accounts accounts, ImageService imageService) {
        this.accounts = accounts;
        this.imageService = imageService;
    }

    @Override
    public Account addAccount(Account form) {

        if (accounts.isExist(form.username())) {
            throw new IllegalArgumentException("이미 존재하는 계정입니다. username=%s"
                    .formatted(form.username()));
        }

        return accounts.save(form);
    }

    @Override
    public Optional<Account> getAccount(Long id) {
        Optional<Account> found = accounts.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void updateTermAgree(AccountTerm accountTerm) {

    }

    @Override
    public String updateThumbnail(Long id, InputStream inputStream) {

        final String fileName = id + ".png";
        UploadImageResult uploaded = imageService.upload(ImageForms.uploadForm()
                .fileName(fileName)
                .inputStream(inputStream)
                .build());
        accounts.updateThumbnail(id, fileName);

        return uploaded.getFileName();
    }

    @Override
    public void deleteAccount(Long accountId) {

    }
}
