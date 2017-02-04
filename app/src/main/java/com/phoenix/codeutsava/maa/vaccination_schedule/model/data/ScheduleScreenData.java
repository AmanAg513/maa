package com.phoenix.codeutsava.maa.vaccination_schedule.model.data;

import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public class ScheduleScreenData {

    private boolean success;
    private String message;
    private List<AfterBirthListDetails> after;
    private List<BeforeBirthListDetails> before;

    public ScheduleScreenData(boolean success, String message, List<AfterBirthListDetails> after, List<BeforeBirthListDetails> before) {
        this.success = success;
        this.message = message;
        this.after = after;
        this.before = before;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<AfterBirthListDetails> getAfter() {
        return after;
    }

    public List<BeforeBirthListDetails> getBefore() {
        return before;
    }
}
