package com.example.mybatis.infra.outbound.db.mybatis.mapper;

import com.example.mybatis.infra.outbound.db.mybatis.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AccountMapper {

    int insert(AccountEntity account);

    int countByUsername(String username);

    Optional<AccountEntity> selectById(Long id);

    Optional<AccountEntity> selectByUsername(String username);

    int update(AccountEntity account);

    int deleteById(Long id);

    //ResultMap - NestedSelect vs NestedResult

    Optional<AccountEntity> selectByUsernameNestedSelect(String username);
    List<AccountEntity> selectAllNestedSelect();

    Optional<AccountEntity> selectByUsernameNestedResult(String username);
    List<AccountEntity> selectAllNestedResult();

}




