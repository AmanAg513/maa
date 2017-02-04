package com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public class FirstVaccineData {

    private boolean success;
    private String message;
    List<FirstVaccineDetails> firstVaccineDetails;

    public FirstVaccineData(boolean success, String message, List<FirstVaccineDetails> firstVaccineDetails) {
        this.success = success;
        this.message = message;
        this.firstVaccineDetails = firstVaccineDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<FirstVaccineDetails> getFirstVaccineDetails() {
        return firstVaccineDetails;
    }
}
