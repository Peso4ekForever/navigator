package ru.peso4ek;

import java.util.Random;

public class Car {
    private final double SPEED_MAX;
    private final double SPEED_MIN;

    private Random rnd = new Random();

    public Car(double speedMax, double speedMin) {
        this.SPEED_MAX = speedMax;
        this.SPEED_MIN = speedMin;
    }

    public double getCarSpeed(){
        return rnd.nextDouble(SPEED_MAX - SPEED_MIN) + SPEED_MIN;
    }
}
