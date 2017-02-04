package com.phoenix.codeutsava.maa.home_page_vaccines_1;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;

/**
 * Created by aman on 4/2/17.
 */

public interface HomeCallBack {

    void onSuccess(HomeData homeData);
    void onFailure();
}
