package com.phoenix.codeutsava.maa.further_reading.model.data;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class FurtherReadingData {
    private String message;
    private boolean success;
    private List<FurtherReadingDataDetails> FurtherReadingDataDetails;

    public FurtherReadingData(String message, Boolean success, List<FurtherReadingDataDetails> FurtherReadingDataDetails) {

        this.message = message;
        this.success = success;
        this.FurtherReadingDataDetails = FurtherReadingDataDetails;
    }



    public boolean isSuccess() {
        return success;
    }



    public String getMessage() {

        return message;
    }

    public List<FurtherReadingDataDetails> getFurtherReadingDataDetails() {
        return FurtherReadingDataDetails;
    }






}
