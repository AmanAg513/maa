package com.phoenix.codeutsava.maa.maps.view;

import com.phoenix.codeutsava.maa.maps.model.data.DoctorData;
import com.phoenix.codeutsava.maa.maps.model.data.GeotagData;

import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public interface GeotagView {

    void showProgressBar(boolean show);
    void showMessage(String message);
    void onDataRecieved(List<DoctorData> doctorDatas);

}
