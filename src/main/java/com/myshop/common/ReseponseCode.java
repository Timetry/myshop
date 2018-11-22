package com.myshop.common;

public enum ReseponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN");

    private final int code;
    private final String desc;

    ReseponseCode(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
