package ru.peso4ek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(80.0, 60.0);

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите расстояние в метрах");

        NavigationAgent navAgent = new NavigationAgent(scan.nextInt(), car);
        navAgent.run();
    }
}
