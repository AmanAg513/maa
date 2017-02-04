package com.phoenix.codeutsava.maa.further_reading.model.data;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class FurtherReadingData {
  private String message;
    private Boolean Success;
  private List<FurtherReadingDataDetails> furtherReadingDataDetailsList;


    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getMessage() {

        return message;
    }

    public List<FurtherReadingDataDetails> getFurtherReadingDataDetailsList() {
        return furtherReadingDataDetailsList;
    }

    public void setFurtherReadingDataDetailsList(List<FurtherReadingDataDetails> furtherReadingDataDetailsList) {
        this.furtherReadingDataDetailsList = furtherReadingDataDetailsList;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    public FurtherReadingData(String message, Boolean success, List<FurtherReadingDataDetails> furtherReadingDataDetailsList) {

        this.message = message;
        Success = success;
        this.furtherReadingDataDetailsList = furtherReadingDataDetailsList;
    }
}