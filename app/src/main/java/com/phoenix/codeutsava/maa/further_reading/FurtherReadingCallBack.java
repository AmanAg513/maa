package com.phoenix.codeutsava.maa.further_reading;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;

/**
 * Created by aman on 4/2/17.
 */
public interface FurtherReadingCallBack {




    void onSuccess(FurtherReadingData furtherReadingData);

    void onFailure(String message);
}
