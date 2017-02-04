package com.phoenix.codeutsava.maa.maps.model;

import com.phoenix.codeutsava.maa.maps.GeotagCallBack;

/**
 * Created by aman on 3/2/17.
 */

public interface GeotagProvider {

    void requestWelcomeData(GeotagCallBack geotagCallBack);
}
