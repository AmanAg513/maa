package com.phoenix.codeutsava.maa.discuss.model;

import com.phoenix.codeutsava.maa.discuss.DiscussQuestionCallBack;

/**
 * Created by aman on 5/2/17.
 */

public interface DiscussQuestionProvider {

    void requestDiscussQuestion(DiscussQuestionCallBack discussQuestionCallBack);
}
