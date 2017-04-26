package com.tiger;

import com.tiger.config.BaseConfig;
import com.tiger.service.impl.AtomTransactionServiceImpl;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {BaseConfig.class})
public class BaseTestCase extends AbstractTestNGSpringContextTests {

    private static Logger logger = LoggerFactory.getLogger(BaseTestCase.class);

    @Autowired
    AtomTransactionServiceImpl atomTransactionService;

    @BeforeMethod
    @Override
    protected void springTestContextBeforeTestMethod(Method testMethod) throws Exception {
        logger.warn("springTestContextBeforeTestMethod");
    }

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void test(){
        try {
            atomTransactionService.insertTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}