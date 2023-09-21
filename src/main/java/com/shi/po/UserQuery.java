package com.shi.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "用户模块条件查询类")
public class UserQuery implements Serializable {

    @ApiModelProperty(value = "分页页码",example = "1")

    private Integer pageNum=1;//当前页
    @ApiModelProperty(value = "每页大小",example = "10")
    private Integer pageSize=10;//每页显示的数量

    @ApiModelProperty(value = "查询条件：用户名")
    private String username;//查询条件：用户名

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
