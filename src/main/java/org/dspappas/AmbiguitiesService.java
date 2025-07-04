package org.dspappas;

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

    }
}
