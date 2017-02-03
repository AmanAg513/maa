package com.phoenix.codeutsava.maa.vaccination_schedule.model;

import com.phoenix.codeutsava.maa.vaccination_schedule.ScheduleScreenCallBack;

/**
 * Created by aman on 3/2/17.
 */

public interface ScheduleScreenProvider {
    void requestScheduleData(ScheduleScreenCallBack scheduleScreenCallBack);
}
