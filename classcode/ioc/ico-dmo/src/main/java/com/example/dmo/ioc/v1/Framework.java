package com.example.dmo.ioc.v1;

public class Framework {
    private Bottom bottom;//底盘

    public Framework(int size){
        bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
