package org.dspappas;

public class SingleNumberSequenceService {

    private final InputService inputService;
    private final GreekNumberValidation greekNumberValidation;

    public SingleNumberSequenceService() {
        this.inputService = new InputService();
        this.greekNumberValidation = new GreekNumberValidation();
    }

    public void getSingleNumberSequenceService() {
        System.out.println("Get a single sequence of numbers");
        String number = inputService.getNumbersSequence();
        System.out.println("number: " + number);
        if (greekNumberValidation.isValid(number)) {
            System.out.println("phone number: VALID");
        } else {
            System.out.println("phone number: INVALID");
        }
    }
}
