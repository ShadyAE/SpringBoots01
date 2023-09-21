package com.shi;


import com.shi.exception.ParmsException;
import com.shi.po.ResultInfo;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo handleException() {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(500);
        resultInfo.setMsg("访问异常，请重试");
        return resultInfo;
    }

    /*处理特定的异常*/
    @ExceptionHandler(value = ParmsException.class)
    @ResponseBody
    public ResultInfo ParmhandleException(ParmsException e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(e.getCode());
        resultInfo.setMsg(e.getMsg());
        return resultInfo;
    }

//    数据校验异常
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultInfo BindExceptionHandler(BindException e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(500);
        resultInfo.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());
        return resultInfo;
    }
}
