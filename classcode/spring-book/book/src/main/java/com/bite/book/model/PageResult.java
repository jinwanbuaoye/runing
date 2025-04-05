package com.bite.book.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private  PageRequest pageRequest;

    private List<T> records; // 当前⻚记录

    private Integer total; // 总记录数

    private Integer code;//业务状态码---- 200：成功，records为空   -1：后端出错，records为空    -2：未登录

    private String errorMessage;

    public PageResult(List<T> records, Integer total,PageRequest pageRequest) {
        this.records = records;
        this.total = total;
        this.pageRequest = pageRequest;
    }
}
