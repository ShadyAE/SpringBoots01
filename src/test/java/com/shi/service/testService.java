package com.shi.service;

import com.shi.Starter;
import com.shi.po.UserQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
public class testService {

        private Logger log = LoggerFactory.getLogger(testService.class);
        @Resource
        private UserService userService;
        @Before
        public void before(){
            log.info("单元测试开始...");
        }
        @Test
        public void test01(){
            log.info(userService.queryuserByuserId(1).toString());
        }
        @Test
        public void test02(){
            log.info(userService.queryUserByParams(new UserQuery()).toString());
        }
        @After
        public void after(){
            log.info("单元测试结束...");
        }
}
