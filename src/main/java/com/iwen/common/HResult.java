package com.iwen.common;


public class HResult {
    private boolean result;
    private String message;
    private Object data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    private HResult(boolean result,String message,Object data){
        this.result=result;
        this.message=message;
        this.data=data;
    }
    public static HResult success(){
        return new HResult(true,null,null);
    }
    public static HResult success(Object obe){
        return new HResult(true,null,obe);
    }
    public static HResult fail(String message){
        return new HResult(false,message,null);
    }
}
