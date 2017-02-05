package com.phoenix.codeutsava.maa.vaccination_schedule.presenter;

import com.phoenix.codeutsava.maa.vaccination_schedule.ScheduleScreenCallBack;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.ScheduleScreenProvider;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;
import com.phoenix.codeutsava.maa.vaccination_schedule.view.ScheduleScreenView;

/**
 * Created by aman on 3/2/17.
 */

public class ScheduleScreenPresenterImpl  implements  ScheduleScreenPresenter{
    private ScheduleScreenView scheduleScreenView;
    private ScheduleScreenProvider scheduleScreenProvider;

    public ScheduleScreenPresenterImpl(ScheduleScreenView scheduleScreenView, ScheduleScreenProvider scheduleScreenProvider) {
        this.scheduleScreenView = scheduleScreenView;
        this.scheduleScreenProvider = scheduleScreenProvider;
    }

    @Override
    public void requestScheduleData() {
        scheduleScreenView.showLoading(true);
        scheduleScreenProvider.requestScheduleData(new ScheduleScreenCallBack() {
            @Override
            public void onSuccess(ScheduleScreenData scheduleScreenData) {
                if(scheduleScreenData.isSuccess())
                {
                    scheduleScreenView.onDataReceived(scheduleScreenData);
                    scheduleScreenView.showLoading(false);
                }
                else
                {
                    scheduleScreenView.showLoading(false);
                    scheduleScreenView.showError("Something went wrong");
                }
            }

            @Override
            public void onFailure(String error) {
                scheduleScreenView.showLoading(false);
                scheduleScreenView.showError("Please try again in sometime.");

            }
        });
    }
}
