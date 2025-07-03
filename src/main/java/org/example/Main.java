package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("App initialization");
        InputService inputService = new InputService();
        GreekNumberValidation greekNumberValidation = new GreekNumberValidation();

        String number = inputService.getNumbersSequence();
        System.out.println("Phone Number: " + number);

        if (greekNumberValidation.isValid(number)) {
            System.out.println("phone number: VALID");
        } else {
            System.out.println("phone number: INVALID");
        }
    }
}