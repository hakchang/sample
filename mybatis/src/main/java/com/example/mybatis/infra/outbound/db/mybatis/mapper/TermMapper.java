package com.example.mybatis.infra.outbound.db.mybatis.mapper;

import com.example.mybatis.infra.outbound.db.mybatis.entity.TermEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TermMapper {

    int insert(TermEntity term);

    Optional<TermEntity> selectById(Long id);

    int update(TermEntity term);

    int deleteById(Long id);

    List<TermEntity> selectAll();

}




