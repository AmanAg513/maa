package com.phoenix.codeutsava.maa.further_reading.view;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public interface FurtherReadingView {


    void showLoading(boolean show);

    void showMessage(String message);

    void onVerified(List<FurtherReadingDataDetails> furtherReadingDataDetailsList);

}
