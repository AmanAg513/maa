package com.phoenix.codeutsava.maa.discuss.model.data;

import java.util.List;

/**
 * Created by aman on 5/2/17.
 */

public class DiscussQuestionData {
    private boolean success;
    private String message;
    private List<DiscussQuestionDetails> questionDetails;

    public DiscussQuestionData(boolean success, String message, List<DiscussQuestionDetails> questionDetails) {
        this.success = success;
        this.message = message;
        this.questionDetails = questionDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<DiscussQuestionDetails> getQuestionDetails() {
        return questionDetails;
    }
}
