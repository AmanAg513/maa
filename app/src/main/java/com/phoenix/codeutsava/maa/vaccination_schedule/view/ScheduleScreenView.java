package com.phoenix.codeutsava.maa.vaccination_schedule.view;

import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

/**
 * Created by aman on 3/2/17.
 */

public interface ScheduleScreenView {

    void showLoading(boolean show);
    void showError(String error);
    void onDataReceived(ScheduleScreenData scheduleScreenData);


}

