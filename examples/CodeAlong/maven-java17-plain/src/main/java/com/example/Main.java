package com.example;

public class Main {
    private static final int MAGIC_NUMBER = 42;

    public static void main(String[] args) {
        System.out.println("Hello");
        var main = new Main();
        System.out.printf("Magic number is %s.%n", main.magicNumber());
    }

    public int magicNumber() {
        return MAGIC_NUMBER;
    }
}
