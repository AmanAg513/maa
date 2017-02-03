package com.phoenix.codeutsava.maa.vaccination_schedule.model.data;

import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public class ScheduleScreenData {

    private boolean success;
    private String message;
    private List<AfterBirthListDetails> afterBirthListDetails;
    private List<BeforeBirthListDetails> beforeBirthListDetails;

    public ScheduleScreenData(boolean success, String message,
                              List<AfterBirthListDetails> afterBirthListDetails,
                              List<BeforeBirthListDetails> beforeBirthListDetails)
    {
        this.success = success;
        this.message = message;
        this.afterBirthListDetails = afterBirthListDetails;
        this.beforeBirthListDetails = beforeBirthListDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<AfterBirthListDetails> getAfterBirthListDetails() {
        return afterBirthListDetails;
    }

    public List<BeforeBirthListDetails> getBeforeBirthListDetails() {
        return beforeBirthListDetails;
    }
}
