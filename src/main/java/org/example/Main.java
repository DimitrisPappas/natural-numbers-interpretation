package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("App initialization");
        InputService inputService = new InputService();
        System.out.println(inputService.getNumbersSequence());
    }
}