package com.flag.xu.web;

import com.flag.xu.web.mapper.MybatisTestMapper;
import com.flag.xu.web.pojo.MybatisTest;
import com.flag.xu.web.util.file.ContextConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Authuor xuj
 * @Create 2017-01-16-14:35
 * @Version
 */
public class MainApp {

    public static void main(String[] args) {
        MybatisTestMapper mybatisTestMapper = (MybatisTestMapper) ContextConfig.context.getBean("mybatisTestMapper");
        List<MybatisTest> mybatisTestList = new ArrayList<>();
        MybatisTest mybatisTest;
        for (int i = 1; i < 10; i++){
            mybatisTest = new MybatisTest();
            mybatisTest.setId(i);
            mybatisTest.setName("name : " + i*2);
            mybatisTest.setSex(i%2==1 ? "男" : "女");
            mybatisTestList.add(mybatisTest);
        }
        mybatisTestMapper.batchInsert(mybatisTestList);
    }
}
