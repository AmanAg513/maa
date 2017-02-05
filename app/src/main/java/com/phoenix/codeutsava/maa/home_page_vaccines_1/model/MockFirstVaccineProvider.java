package com.phoenix.codeutsava.maa.home_page_vaccines_1.model;

import android.os.Handler;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.FirstVaccineCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.ScheduleScreenCallBack;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.AfterBirthListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.BeforeBirthListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 5/2/17.
 */

public class MockFirstVaccineProvider implements FirstVaccineProvider {



    @Override
    public void requestFirstVaccineData(final FirstVaccineCallBack firstVaccineCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                firstVaccineCallBack.onSuccess(getMockFirstVaccineDetails());


            }
        },500);

    }

    private FirstVaccineData getMockFirstVaccineDetails(){
        List<FirstVaccineDetails> firstVaccineDetailsList = new ArrayList<>();

            FirstVaccineDetails firstVaccineDetails = new FirstVaccineDetails
                    ("1","Can be Dangerous","0");

            firstVaccineDetailsList.add(firstVaccineDetails);
            firstVaccineDetails = new FirstVaccineDetails
                ("2","What is Morphine ?","0");
            firstVaccineDetailsList.add(firstVaccineDetails);

        firstVaccineDetails = new FirstVaccineDetails
                ("2","What is Tetaenus ?","0");
        firstVaccineDetailsList.add(firstVaccineDetails);

        firstVaccineDetails = new FirstVaccineDetails
                ("2","What is Marijuana ?","0");
        firstVaccineDetailsList.add(firstVaccineDetails);




        FirstVaccineData firstVaccineData = new FirstVaccineData(true,"Success",firstVaccineDetailsList);

        return firstVaccineData;

    }
}
