package com.bite.book.enums;

public enum BookStatuEnum {
    DELETED(0,"删除"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅");

    public static BookStatuEnum getNameByCode(int code){
        switch (code){
            case 0:return BookStatuEnum.DELETED;
            case 1:return BookStatuEnum.NORMAL;
            default:
                return BookStatuEnum.FORBIDDEN;
        }
    }

    private int code;
    private  String name;

    BookStatuEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
