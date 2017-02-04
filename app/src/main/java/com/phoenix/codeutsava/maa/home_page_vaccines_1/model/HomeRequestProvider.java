package com.phoenix.codeutsava.maa.home_page_vaccines_1.model;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.FirstVaccineCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.HomeCallBack;

/**
 * Created by aman on 4/2/17.
 */

public interface HomeRequestProvider {

    void requestHomeData(String fcm,HomeCallBack homeCallBack);
}
