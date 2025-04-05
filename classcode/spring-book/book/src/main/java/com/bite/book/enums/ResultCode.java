package com.bite.book.enums;

import com.bite.book.model.Result;

public enum ResultCode {
    SUCCESS(200),
    FAIL(-1),
    UNLOGIN(-2);
    //200：成功，records为空   -1：后端出错，records为空    -2：未登录
    ResultCode(int code){
        this.code=code;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
