package org.dspappas;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class InputService {

    public List<String> getNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers sequence:");
        String input = scanner.nextLine();
        String trimmedInput = input.trim();
        List<String> numbers;
        numbers = List.of(trimmedInput.split("\\s+"));
        return numbers;
    }

    public String getNumbersSequence() {
        List<String> numbers = getNumbers();
        return joinNumbers(numbers);
    }

    private String joinNumbers(List<String> numbers) {
        String result = "";
        for (String n : numbers) {
            if (hasThreeDigitsOrLess(n)) {
                result = result + n;
            } else {
                result = "Invalid number " + n;
                break;
            }
        }
        return result;
    }

    private Boolean hasThreeDigitsOrLess(@NotNull String number) {
        return number.matches("\\d{1,3}");
    }
}