package com.bite.book.model;

import com.bite.book.enums.ResultCode;
import lombok.Data;

@Data
public class Result {
    private ResultCode code;//业务状态码---- 200：成功，records为空   -1：后端出错，records为空    -2：未登录

    private String errorMessage;//错误信息

    private Object data;//数据

    /**
     * 业务执⾏成功时返回的⽅法
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setErrorMessage("");
        result.setData(data);
        return result;
    }
    /**
     * 业务执⾏失败时返回的⽅法
     *
     * @param
     * @return
     */
    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrorMessage(msg);
        result.setData("");
        return result;
    }

    public static Result fail(String msg,Object data) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrorMessage(msg);
        result.setData(data);
        return result;
    }

    /**
     * 业务执⾏失败时返回的⽅法
     *
     * @param
     * @return
     */
    public static Result unlogin() {
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN);
        result.setErrorMessage("⽤⼾未登录");
        result.setData(null);
        return result;
    }
}
