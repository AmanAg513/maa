package com.phoenix.codeutsava.maa.maps.model.data;

import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public class GeotagData {

    private boolean success;
    private String message;
    private List<DoctorData> dataList;

    public GeotagData(boolean success, String message, List<DoctorData> dataList) {
        this.success = success;
        this.message = message;
        this.dataList = dataList;
    }

    public String getMessage() {
        return message;
    }

    public List<DoctorData> getDataList() {
        return dataList;
    }

    public boolean isSuccess() {
        return success;
    }
}
