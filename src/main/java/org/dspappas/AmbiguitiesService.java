package org.dspappas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmbiguitiesService {

    private final InputService inputService;
    private final GreekNumberValidation greekNumberValidation;

    public AmbiguitiesService() {
        this.inputService = new InputService();
        this.greekNumberValidation = new GreekNumberValidation();
    }

    public void getAmbiguities() {
        System.out.println("Identify natural number ambiguities");
        List<String> numbers = inputService.getNumbers();
        List<String> interpretations = generateInterpretations(numbers);
        for (int i=0; i < interpretations.size(); i++) {
            String interpretation = interpretations.get(i);
            String valid = greekNumberValidation.isValid(interpretation) ? "VALID" : "INVALID";
            String counter = String.valueOf(i+1);
            System.out.println("Interpretation " + counter + ": " + interpretation
                    + " [phone number: " + valid + "]");
        }
    }

    private List<String> generateInterpretations(List<String> numbers) {
        List<String> results = new ArrayList<>();
        recursiveVariations(numbers, results, 0, "");
        return results;
    }

    private void recursiveVariations(List<String> numbers, List<String> results, int index, String currentVariation) {
        if (index >= numbers.size()) {
            results.add(currentVariation);
            return;
        }

        String number = numbers.get(index);
        List<String> variations = getVariations(number, numbers, index);

        for (String variation : variations) {
            String nextVariation = currentVariation + variation;
            recursiveVariations(numbers, results, index+1, nextVariation);
        }
    }

    private List<String> getVariations(String originalNumber, List<String> numbers, int index) {
        List<String> variations = new ArrayList<>();
        variations.add(originalNumber);

        if (originalNumber.length() == 2) {
            variations.addAll(getTwoDigitVariations(originalNumber, numbers, index));
        } else if (originalNumber.length() == 3) {
            variations.addAll(getThreeDigitVariations(originalNumber, numbers, index));
        }
        return variations;
    }

    private List<String> getTwoDigitVariations(String originalNumber, List<String> numbers, int index) {
        List<String> twoDigitVariations = new ArrayList<>();
        if (!twoDigitsAreZeros(originalNumber)) {
            if (canDropZero(originalNumber, numbers, index)) {
                String dropZero = originalNumber.substring(0,1);
                twoDigitVariations.add(dropZero);
            }
            if (canInsertZero(originalNumber)) {
                String firstDigit = originalNumber.substring(0, 1);
                String secondDigit = originalNumber.substring(1, 2);
                String addZero = firstDigit + "0" + secondDigit;
                twoDigitVariations.add(addZero);
            }
        }
        return twoDigitVariations;
    }

    private Boolean twoDigitsAreZeros(String number) {
        return number.equals("00");
    }

    private Boolean canDropZero(String number, List<String> numbers, int index) {
        return endsWithZero(number) && ensureNextNumberHasOneDigit(numbers, index);
    }

    private Boolean canInsertZero(String number) {
        return !endsWithZero(number) && !startsWithZero(number);
    }

    private Boolean endsWithZero(String number) {
        return number.endsWith("0");
    }

    private Boolean startsWithZero(String number) {
        return number.startsWith("0");
    }

    private Boolean ensureNextNumberHasOneDigit(List<String> numbers, int index) {
        boolean result = false;
        if (hasNextNumber(numbers, index)) {
            result = numbers.get(index+1).length() == 1;
        }
        return result;
    }

    private Boolean hasNextNumber(List<String> numbers, int index) {
        return index + 1 < numbers.size();
    }



    private List<String> getThreeDigitVariations(String originalNumber, List<String> numbers, int index) {
        return Collections.emptyList();
    }
}
