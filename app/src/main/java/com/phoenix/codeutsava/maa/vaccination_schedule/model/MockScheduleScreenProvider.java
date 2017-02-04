package com.phoenix.codeutsava.maa.vaccination_schedule.model;

import android.os.Handler;

import com.phoenix.codeutsava.maa.vaccination_schedule.ScheduleScreenCallBack;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.AfterBirthListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.BeforeBirthListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public class MockScheduleScreenProvider implements ScheduleScreenProvider {


    @Override
    public void requestScheduleData(final ScheduleScreenCallBack scheduleScreenCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                scheduleScreenCallBack.onSuccess(getMockAfterBirthListDetails());


            }
        },500);

    }

    private ScheduleScreenData getMockAfterBirthListDetails(){
        List<AfterBirthListDetails> afterBirthListDetailsList = new ArrayList<>();
        List<BeforeBirthListDetails> beforeBirthListDetailsList = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            AfterBirthListDetails afterBirthListDetails = new AfterBirthListDetails
                    ("RotaVirusVaccines","Can be Dangerous","15/01/2017");
            afterBirthListDetailsList.add(afterBirthListDetails);

            BeforeBirthListDetails beforeBirthListDetails=new BeforeBirthListDetails
                    ("Flu","September onwards","07/09/2017");
            beforeBirthListDetailsList.add(beforeBirthListDetails);

        }

        ScheduleScreenData scheduleScreenData = new ScheduleScreenData(true,"Success",
                afterBirthListDetailsList,beforeBirthListDetailsList);


        return scheduleScreenData;
    }
}
