package com.example.mybatis.infra.outbound.db.mybatis.mapper;

import com.example.mybatis.domain.account.AccountService;
import com.example.mybatis.domain.account.model.Account;
import com.example.mybatis.domain.account.model.AccountTerm;
import com.example.mybatis.domain.account.model.User;
import com.example.mybatis.infra.outbound.db.mybatis.entity.AccountEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper mapper;

    @Autowired
    private AccountService service;

    void sampling(String username) {
        service.addAccount(Account.builder()
                .username(username)
                .password("1234")
                .nickname("hak")
                .user(User.builder()
                        .email("h@gmail.com")
                        .phone("010")
                        .name("임학창")
                        .build())
                .terms(List.of(
                        AccountTerm.builder()
                                .termId(1L)
                                .agree(true)
                                .build(),
                        AccountTerm.builder()
                                .termId(2L)
                                .agree(true)
                                .build()
                ))
                .build());
    }

    @Test
    @Disabled
    void insertSamples() {

        for (int index = 0; index < 10; index++) {
            String username = "hak_%s".formatted(index);
            sampling(username);
        }

    }

    @Test
    void nestedSelect_detail() throws JsonProcessingException {

        Optional<AccountEntity> account = mapper.selectByUsernameNestedSelect("hakchangs");
        //lazy load -> 정보를 추가로 더 가져옴
        AccountEntity entity = account.get();
        entity.getUser();
        entity.getTerms();

        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(account.get().toDomain());
        System.out.println(json);

    }

    @Test
    void nestedResult_detail() throws JsonProcessingException {

        Optional<AccountEntity> account = mapper.selectByUsernameNestedResult("hakchangs");
        //lazy load -> Nested Result 에서는 로딩할 작업 없음
        AccountEntity entity = account.get();
        entity.getUser();
        entity.getTerms();

        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(account.get().toDomain());
        System.out.println(json);

    }

    @Test
    void nestedSelect_list() {

        List<Account> accounts = mapper.selectAllNestedSelect().stream()
                .map(entity -> {
                    //lazy load -> N+1 문제 발생!
                    entity.getUser();
                    entity.getTerms();
                    return entity.toDomain();
                }).toList();
        System.out.println(accounts);
    }

    @Test
    void nestedResult_list() {

        List<Account> accounts = mapper.selectAllNestedResult().stream()
                .map(entity -> {
                    //lazy load -> Nested Result 에서는 로딩할 작업 없음
                    entity.getUser();
                    entity.getTerms();
                    return entity.toDomain();
                }).toList();
        System.out.println(accounts);
    }
}