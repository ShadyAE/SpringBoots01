package com.shi.controllers;


import com.shi.Starter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
@AutoConfigureMockMvc
public class controller {
    private Logger log = LoggerFactory.getLogger(controller.class);
    @Autowired
    private MockMvc mockMvc;
    //用户列表查询
    @Test
    public void apiTest01()throws Exception{
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/user/list")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        log.info("响应状态:{}",mvcResult.getResponse().getStatus());
        log.info("响应内容:{}",mvcResult.getResponse().getContentAsString());;
    }
    // 用户名记录查询
    @Test
    public void apiTest02()throws Exception{
        MvcResult
                mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/user/uname/qwe")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        log.info("响应状态:{}",mvcResult.getResponse().getStatus());
        log.info("响应内容:{}",mvcResult.getResponse().getContentAsString());;
    }
}


