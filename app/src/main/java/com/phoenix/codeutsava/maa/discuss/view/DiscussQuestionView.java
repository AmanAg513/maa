package com.phoenix.codeutsava.maa.discuss.view;

import com.phoenix.codeutsava.maa.discuss.model.data.DiscussQuestionData;

/**
 * Created by aman on 5/2/17.
 */

public interface DiscussQuestionView {

    void showLoading(boolean show);
    void showError(String error);
    void onDataReceived(DiscussQuestionData discussQuestionData);


}
