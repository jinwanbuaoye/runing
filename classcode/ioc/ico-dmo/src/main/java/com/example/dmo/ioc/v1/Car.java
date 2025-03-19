package com.example.dmo.ioc.v1;

public class Car {
    private Framework framework;//车身

    public Car(int size){
        framework = new Framework(size);
        System.out.println("car init...");
    }

    public void run(){
        System.out.println("car run...");
    }
}
