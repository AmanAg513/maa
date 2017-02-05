package com.phoenix.codeutsava.maa.discuss;

import com.phoenix.codeutsava.maa.discuss.model.data.DiscussQuestionData;

/**
 * Created by aman on 5/2/17.
 */

public interface DiscussQuestionCallBack {

    void onSuccess(DiscussQuestionData discussQuestionData);
    void onFailure();
}
