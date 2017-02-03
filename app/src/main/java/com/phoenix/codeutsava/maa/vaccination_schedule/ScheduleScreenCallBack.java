package com.phoenix.codeutsava.maa.vaccination_schedule;

import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

/**
 * Created by aman on 3/2/17.
 */

public interface ScheduleScreenCallBack {

    void onSuccess(ScheduleScreenData scheduleScreenData);

    void onFailure(String error);
}
