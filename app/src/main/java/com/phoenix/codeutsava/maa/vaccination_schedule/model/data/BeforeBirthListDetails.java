package com.phoenix.codeutsava.maa.vaccination_schedule.model.data;

/**
 * Created by aman on 3/2/17.
 */

public class BeforeBirthListDetails {

    private String name;
    private String data;
    private String date;

    public BeforeBirthListDetails(String name, String data, String date) {
        this.name = name;
        this.data = data;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getDate() {
        return date;
    }
}
