package com.example.mybatis.infra.outbound.db.mybatis.mapper;

import com.example.mybatis.infra.outbound.db.mybatis.entity.AccountTermEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountTermMapper {

    int insert(AccountTermEntity accountTerm);

    List<AccountTermEntity> selectAllByAccountId(Long accountId);

    int update(AccountTermEntity accountTerm);

}




