package com.example.mybatis.infra.outbound.db.mybatis.mapper;

import com.example.mybatis.infra.outbound.db.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    int insert(UserEntity user);

    Optional<UserEntity> selectById(Long id);

    Optional<UserEntity> selectByAccountId(Long accountId);

    int update(UserEntity user);

    int deleteById(Long id);

}




