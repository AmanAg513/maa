package com.phoenix.codeutsava.maa.maps;

import com.phoenix.codeutsava.maa.maps.model.data.GeotagData;

/**
 * Created by aman on 3/2/17.
 */

public interface GeotagCallBack {

    void onSuccess(GeotagData geotagData);
    void onFailure();
}
