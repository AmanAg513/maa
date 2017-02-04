package com.phoenix.codeutsava.maa.maps.model.data;

/**
 * Created by iket on 4/2/17.
 */

public class DoctorData {
    private double latitude;
    private double longitude;
    private String name,mobile;

    public DoctorData(double latitude, double longitude, String name, String mobile) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.mobile = mobile;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }
}
