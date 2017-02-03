package com.phoenix.codeutsava.maa.home_page_vaccines_1.presenter;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.FirstVaccineCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.FirstVaccineProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.view.FirstVaccineView;

/**
 * Created by aman on 4/2/17.
 */

public class FirstVaccinePresenterImpl implements  FirstVaccinePresenter {


    private FirstVaccineView firstVaccineView;
    private FirstVaccineProvider firstVaccineProvider;

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

                }
                else
                {

                }
            }

            @Override
            public void onFailure() {

            }
        });

    }
}
