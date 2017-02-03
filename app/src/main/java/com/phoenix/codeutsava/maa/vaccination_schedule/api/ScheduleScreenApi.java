package com.phoenix.codeutsava.maa.vaccination_schedule.api;

import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 3/2/17.
 */

public interface ScheduleScreenApi {

    @GET(Urls.REQUEST_SCHEDULE_SCREEN)
    Call<ScheduleScreenData> requestScheduleData();
}
