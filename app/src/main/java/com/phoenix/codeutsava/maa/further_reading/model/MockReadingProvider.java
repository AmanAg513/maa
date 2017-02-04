package com.phoenix.codeutsava.maa.further_reading.model;

import android.os.Handler;

import com.phoenix.codeutsava.maa.further_reading.FurtherReadingCallBack;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.AfterBirthListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.BeforeBirthListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 5/2/17.
 */

public class MockReadingProvider implements FurtherReadingProvider{



    @Override
    public void requestFurtherReading(final FurtherReadingCallBack furtherReadingCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                furtherReadingCallBack.onSuccess(getFurtherReadingListDetails());


            }
        },500);

    }

    private FurtherReadingData getFurtherReadingListDetails(){
        List<FurtherReadingDataDetails> furtherReadingDataDetailsList=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            FurtherReadingDataDetails furtherReadingDataDetails = new FurtherReadingDataDetails
                    ("pdf","https://drive.google.com/open?id=0BxXB_NzrYajbRERTVlpzRXFzX0U");
            furtherReadingDataDetailsList.add(furtherReadingDataDetails);
        }
        FurtherReadingData furtherReadingData= new FurtherReadingData("Success",true,furtherReadingDataDetailsList);


        return furtherReadingData;

    }
}
