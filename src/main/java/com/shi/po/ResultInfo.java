package com.shi.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "响应结果-Model信息")
public class ResultInfo implements Serializable {
    @ApiModelProperty(value = "响应消息结果")
    private String msg="操作成功";
    @ApiModelProperty(value = "响应状态码",example = "200")
    private Integer code=1;
    @ApiModelProperty(value = "响应具体结果信息")
    private Object  data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
