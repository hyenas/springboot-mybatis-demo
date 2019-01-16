package com.example.demo.common;

/**
 * Created by zhangyang on 19/1/16.
 *
 * @author zhangyang
 * @date 2019/01/16
 */
public enum  ErrorCodeEnum {
    SUCCESS(0, "请求成功"),
    ILLEGAL_ARGUMENT(101, "参数非法"),
    SYSTEM_ERROR(999, "系统异常");

    private Integer errorCode;
    private String errorMsg;

    private ErrorCodeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ErrorCodeEnum setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public Integer getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.errorMsg;
    }

    public static final ErrorCodeEnum getByCode(Integer errorCode) {
        if(errorCode == null) {
            return null;
        } else {
            ErrorCodeEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                ErrorCodeEnum item = var1[var3];
                if(errorCode.equals(item.getCode())) {
                    return item;
                }
            }

            return null;
        }
    }
}
