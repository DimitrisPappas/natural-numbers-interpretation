package org.example;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class InputService {

    public String getNumbersSequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers sequence");
        String input = scanner.nextLine();
        String trimmedInput = input.trim();
        String[] numbers = trimmedInput.split("\\s+");
        return joinNumbers(numbers);
    }

    private String joinNumbers(@NotNull String[] numbers) {
        String result = "";
        for (String n : numbers) {
            if (hasThreeDigitsOrLess(n)) {
                result = result + n;
            } else {
                System.out.println("Invalid number: " + n);
                result = "ERROR";
                break;
            }
        }
        return result;
    }

    private Boolean hasThreeDigitsOrLess(@NotNull String number) {
        return number.matches("\\d{1,3}");
    }
}
