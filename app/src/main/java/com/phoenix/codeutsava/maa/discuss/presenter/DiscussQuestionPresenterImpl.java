package com.phoenix.codeutsava.maa.discuss.presenter;

import com.phoenix.codeutsava.maa.discuss.DiscussQuestionCallBack;
import com.phoenix.codeutsava.maa.discuss.model.DiscussQuestionProvider;
import com.phoenix.codeutsava.maa.discuss.model.data.DiscussQuestionData;
import com.phoenix.codeutsava.maa.discuss.view.DiscussQuestionView;

/**
 * Created by aman on 5/2/17.
 */

public class DiscussQuestionPresenterImpl implements DiscussQuestionPresenter {

    private DiscussQuestionProvider discussQuestionProvider;
    private DiscussQuestionView discussQuestionView;

    public DiscussQuestionPresenterImpl(DiscussQuestionProvider discussQuestionProvider,
                                        DiscussQuestionView discussQuestionView) {
        this.discussQuestionProvider = discussQuestionProvider;
        this.discussQuestionView = discussQuestionView;
    }

    @Override
    public void requestDiscussQuestion() {
        discussQuestionView.showLoading(true);
        discussQuestionProvider.requestDiscussQuestion(new DiscussQuestionCallBack() {
            @Override
            public void onSuccess(DiscussQuestionData discussQuestionData) {
                if(discussQuestionData.isSuccess())
                {
                    discussQuestionView.onDataReceived(discussQuestionData);
                    discussQuestionView.showLoading(false);

                }
                else
                {
                    discussQuestionView.showLoading(false);
                    discussQuestionView.showError("Something went wrong");
                }
            }

            @Override
            public void onFailure() {
                discussQuestionView.showLoading(false);
                discussQuestionView.showError("Please try again in sometime.");


            }
        });

    }
}
