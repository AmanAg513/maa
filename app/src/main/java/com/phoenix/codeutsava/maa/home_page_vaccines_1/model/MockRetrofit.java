package com.phoenix.codeutsava.maa.home_page_vaccines_1.model;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.HomeCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 4/2/17.
 */

public class MockRetrofit implements HomeRequestProvider {
    @Override
    public void requestHomeData(String fcm, HomeCallBack homeCallBack) {
        List<HomeListDetails>list=new ArrayList<>();
        HomeListDetails details=new HomeListDetails("1","hello",4,"hello");
        list.add(details);
        list.add(details);
        list.add(details);
        list.add(details);
        HomeData data=new HomeData(true,"Hello",list);
        homeCallBack.onSuccess(data);

    }
}
