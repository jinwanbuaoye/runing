package com.example.dmo.ioc.v1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(17);
        car.run();

        Car car2 = new Car(21);
        car2.run();
    }
}
