package com.iwen.common;


public enum ErrorCode {
    SYSTRM_ERROR(1,"系统异常"),
    NO_TOKEN(2,"token不存在"),
    SIGN_ERROR(4,"签名错误"),
    OFF_LINE(3,"用户已离线")
    ;

    private ErrorCode(int code,String message) {
        this.code = code;
        this.message = message;
    }
    public static String getErrorMessage(Integer index) {
        if(index==null){
            return null;
        }
        for (ErrorCode c : ErrorCode.values()) {
            if (c.getCode() == index) {
                return c.getMessage();
            }
        }
        return null;
    }

    private Integer code;
    private String message;
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}

