package org.example;

import org.jetbrains.annotations.NotNull;

public class GreekNumberValidation {

    public Boolean isValid(@NotNull String number) {
        int length = number.length();
        System.out.println("length: " + length);
        Boolean result = false;

        if (length == 10) {
            result = isValidWithLength10(number);
        } else if (length == 14) {
            result = isValidWithLength14(number);
        }
        return result;
    }

    private Boolean isValidWithLength10(@NotNull String number) {
        return number.startsWith("2") || number.startsWith("69");
    }

    private Boolean isValidWithLength14(@NotNull String number) {
        return number.startsWith("00302") || number.startsWith("003069");
    }
}
