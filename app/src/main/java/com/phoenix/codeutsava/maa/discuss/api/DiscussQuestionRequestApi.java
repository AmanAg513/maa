package com.phoenix.codeutsava.maa.discuss.api;

import com.phoenix.codeutsava.maa.discuss.model.data.DiscussQuestionData;
import com.phoenix.codeutsava.maa.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 5/2/17.
 */

public interface DiscussQuestionRequestApi {

    @GET(Urls.REQUEST_DISCUSS_QUESTION)
    Call<DiscussQuestionData> requestDiscussQuestion();

}
