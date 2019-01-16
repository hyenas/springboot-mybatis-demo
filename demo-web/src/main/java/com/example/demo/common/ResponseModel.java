package com.example.demo.common;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhangyang on 17/11/3.
 *
 * @author zhangyang
 * @date 2017/11/03
 */
public class ResponseModel<T> {

    private boolean success=true;

    private String errorMsg;

    /**
     * 对应前端规范中的错误定义src/errors/[lang].js
     */
    private int errorCode;

    private T content;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(ErrorCodeEnum errorCode) {
        this.success = false;
        this.setErrorCode(errorCode.getCode());
        this.setErrorMsg(errorCode.getMessage());
    }

    public void setError(int errorCode, String errorMsg) {
        this.success = false;
        this.setErrorCode(errorCode);
        this.setErrorMsg(errorMsg);
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
