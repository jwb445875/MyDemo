package com.iwen.common;

public class AppException extends RuntimeException{
    /**
     * 错误码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public AppException(Integer code){
        this.code = code;
    }

}
