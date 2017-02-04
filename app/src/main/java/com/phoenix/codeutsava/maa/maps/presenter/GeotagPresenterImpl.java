package com.phoenix.codeutsava.maa.maps.presenter;

import android.util.Log;

import com.phoenix.codeutsava.maa.maps.GeotagCallBack;
import com.phoenix.codeutsava.maa.maps.model.GeotagProvider;
import com.phoenix.codeutsava.maa.maps.model.data.DoctorData;
import com.phoenix.codeutsava.maa.maps.model.data.GeotagData;
import com.phoenix.codeutsava.maa.maps.view.GeotagView;

/**
 * Created by aman on 3/2/17.
 */

public class GeotagPresenterImpl implements GeotagPresenter {

    private GeotagView geotagView;
    private GeotagProvider geotagProvider;

    public GeotagPresenterImpl(GeotagView geotagView, GeotagProvider geotagProvider) {
        this.geotagView = geotagView;
        this.geotagProvider = geotagProvider;
    }

    @Override
    public void requestWelcomeData() {
//        geotagView.showProgressBar(true);
        geotagProvider.requestWelcomeData(new GeotagCallBack() {
            @Override
            public void onSuccess(GeotagData geotagData) {
                if(geotagData.isSuccess())
                {
                    geotagView.showMessage(geotagData.getMessage());
                    geotagView.showProgressBar(false);
                    for(int i=0;i<geotagData.getMap_deatils().size();i++)
                    {
                        DoctorData data=geotagData.getMap_deatils().get(i);
                        Log.d("Response",""+data.getLatitude() +"   "+data.getName());
                    }
                    geotagView.onDataRecieved(geotagData.getMap_deatils());

                }

                else
                {
                    geotagView.showProgressBar(false);
                    geotagView.showMessage("Something went wrong");
                }

            }

            @Override
            public void onFailure() {
                geotagView.showMessage("Failed");
                geotagView.showProgressBar(false);
            }
        });
    }
}
