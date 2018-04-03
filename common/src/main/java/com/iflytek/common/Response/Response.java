package com.iflytek.common.Response;

import com.iflytek.common.constants.ResponseConstant;

import java.io.Serializable;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
public class Response<T> implements Serializable {

    /**
     * RPC接口调用是否成功状态
     */
    private Boolean status = true;

    /**
     * RPC接口返回的状态码
     */
    private String code = ResponseConstant.SUCCESS.getCode();

    /**
     * RPC接口返回的数据对象
     */
    private T data;

    /**
     * RPC接口返回的接口调用信息
     */
    private String msg = ResponseConstant.SUCCESS.getMsg();

    /**
     * RPC接口返回的接口调用异常信息
     */
    private String errorMsg;

    public Response() {
    }

    public Response(String code, T data, String msg, String errorMsg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }

    public Response(Boolean status, String code, T data, String msg, String errorMsg) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
