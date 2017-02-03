package com.phoenix.codeutsava.maa.vaccination_schedule.model.data;

/**
 * Created by aman on 3/2/17.
 */

public class AfterBirthListDetails {

    private String vaccination_name;
    private String vaccination_time;

    public AfterBirthListDetails(String vaccination_name, String vaccination_time) {
        this.vaccination_name = vaccination_name;
        this.vaccination_time = vaccination_time;
    }

    public String getVaccination_name() {
        return vaccination_name;
    }

    public String getVaccination_time() {
        return vaccination_time;
    }
}
