package com.phoenix.codeutsava.maa.home_page_vaccines_1.presenter;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.FirstVaccineCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.HomeCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.FirstVaccineProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.HomeRequestProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.view.FirstVaccineView;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.view.HomeView;

/**
 * Created by aman on 4/2/17.
 */

public class FirstVaccinePresenterImpl implements  FirstVaccinePresenter {


    private FirstVaccineView firstVaccineView;
    private FirstVaccineProvider firstVaccineProvider;

    private HomeView homeView;
    private HomeRequestProvider homeRequestProvider;

    public FirstVaccinePresenterImpl(HomeView homeView, HomeRequestProvider homeRequestProvider) {
        this.homeView = homeView;
        this.homeRequestProvider = homeRequestProvider;
    }

    public FirstVaccinePresenterImpl(FirstVaccineView firstVaccineView, FirstVaccineProvider firstVaccineProvider) {
        this.firstVaccineView = firstVaccineView;
        this.firstVaccineProvider = firstVaccineProvider;
    }

    @Override
    public void requestFirstVaccineData() {

        firstVaccineProvider.requestFirstVaccineData(new FirstVaccineCallBack() {
            @Override
            public void onSuccess(FirstVaccineData firstVaccineData) {
                if(firstVaccineData.isSuccess())
                {
                    firstVaccineView.setData(firstVaccineData.getFirstVaccineDetails());
                    firstVaccineView.showMessage("Success");
                    firstVaccineView.showProgressBar(false);
                }
                else
                {
                    firstVaccineView.showMessage("Try Again Sometime Later");
                    firstVaccineView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure() {
                    firstVaccineView.showMessage("Failed");
            }
        });

    }

    @Override
    public void requestHomeData(String fcm) {
        homeRequestProvider.requestHomeData(fcm, new HomeCallBack() {
            @Override
            public void onSuccess(HomeData homeData)
            {
                //yet to be made
            }

            @Override
            public void onFailure() {
                //yet to be made
            }
        });
    }
}
