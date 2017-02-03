package com.phoenix.codeutsava.maa.home_page_vaccines_1;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;

/**
 * Created by aman on 4/2/17.
 */

public interface FirstVaccineCallBack {

    void onSuccess(FirstVaccineData firstVaccineData);
    void onFailure();
}
