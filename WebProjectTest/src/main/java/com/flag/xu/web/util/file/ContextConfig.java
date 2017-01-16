package com.flag.xu.web.util.file;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Authuor xuj
 * @Create 2017-01-16-14:55
 * @Version
 */
public class ContextConfig {
    public static final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
}
