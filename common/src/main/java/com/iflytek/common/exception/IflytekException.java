package com.iflytek.common.exception;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description: 自定义业务异常
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
public class IflytekException extends IllegalArgumentException {

    private String code;

    private String msg;

    private String errorMsg;

    public IflytekException(ExceptionEnum exceptionEnum) {
        if(exceptionEnum != null){
            this.code = exceptionEnum.getCode();
            this.msg = exceptionEnum.getMsg();
            this.errorMsg = exceptionEnum.getErrorMsg();
        }
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
}
