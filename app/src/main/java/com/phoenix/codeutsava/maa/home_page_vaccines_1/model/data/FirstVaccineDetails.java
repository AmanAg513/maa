package com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data;

/**
 * Created by aman on 4/2/17.
 */

public class FirstVaccineDetails {

    private String question_id;
    private String question_data;

    public FirstVaccineDetails(String question_id, String question_data) {
        this.question_id = question_id;
        this.question_data = question_data;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public String getQuestion_data() {
        return question_data;
    }
}
