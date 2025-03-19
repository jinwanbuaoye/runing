package com.example.dmo.ioc.v1;

public class Bottom {
    private Tire tire;//轮子

    public Bottom(int size){
        tire = new Tire(size);
        System.out.println("Tire init...");
    }
}
