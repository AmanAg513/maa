package com.phoenix.codeutsava.maa.maps.model.data;

import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public class GeotagData {

    private boolean success;
    private String message;
    private List<DoctorData> map_deatils;


    public GeotagData(boolean success, String message, List<DoctorData> map_deatils) {
        this.success = success;
        this.message = message;
        this.map_deatils = map_deatils;
    }

    public String getMessage() {
        return message;
    }

    public List<DoctorData> getMap_deatils() {
        return map_deatils;
    }

    public boolean isSuccess() {
        return success;
    }
}
