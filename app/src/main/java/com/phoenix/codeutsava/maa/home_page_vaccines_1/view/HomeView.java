package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

/**
 * Created by aman on 4/2/17.
 */

public interface HomeView {
    void showLoading(boolean show);
    void showError(String error);
    void onDataReceived(HomeData homeData);
}
