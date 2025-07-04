package org.dspappas;

public class AmbiguitiesService {

    private final GreekNumberValidation greekNumberValidation;

    public AmbiguitiesService() {
        this.greekNumberValidation = new GreekNumberValidation();
    }

    public void getAmbiguities() {
        System.out.println("Identify natural number ambiguities");
    }
}
