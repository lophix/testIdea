package com.flag.xu.web.mapper;

import com.flag.xu.web.pojo.MybatisTest;

import java.util.List;

public interface MybatisTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MybatisTest record);

    int insertSelective(MybatisTest record);

    MybatisTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MybatisTest record);

    int updateByPrimaryKey(MybatisTest record);

    int batchInsert(List<MybatisTest> record);
}