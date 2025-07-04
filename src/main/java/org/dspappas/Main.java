package org.dspappas;

public class Main {
    public static void main(String[] args) {

        System.out.println("App initialization");
        SingleNumberSequenceService singleNumberSequenceService = new SingleNumberSequenceService();
        AmbiguitiesService ambiguitiesService = new AmbiguitiesService();

        // Get a single sequence of numbers
//        singleNumberSequenceService.getSingleNumberSequence();

        // Identify natural number ambiguities
        ambiguitiesService.getAmbiguities();
    }
}