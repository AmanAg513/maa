package com.phoenix.codeutsava.maa.further_reading.presenter;

import android.util.Log;

import com.phoenix.codeutsava.maa.further_reading.FurtherReadingCallBack;
import com.phoenix.codeutsava.maa.further_reading.model.FurtherReadingProvider;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;
import com.phoenix.codeutsava.maa.further_reading.view.FurtherReadingView;

/**
 * Created by aman on 4/2/17.
 */
public class FurtherReadingPresenterImpl implements FurtherReadingPresenter {

    private FurtherReadingView furtherReadingView;
    private FurtherReadingProvider furtherReadingProvider;

    public FurtherReadingPresenterImpl(FurtherReadingView furtherReadingView, FurtherReadingProvider furtherReadingProvider) {
        this.furtherReadingView = furtherReadingView;
        this.furtherReadingProvider = furtherReadingProvider;
    }

    @Override
    public void requestFurtherReading() {

        furtherReadingProvider.requestFurtherReading( new FurtherReadingCallBack() {
            @Override
            public void onSuccess(FurtherReadingData furtherReadingData) {
                if (furtherReadingData.isSuccess()) {
                    furtherReadingView.showLoading(false);
                    furtherReadingView.onVerified(furtherReadingData.getFurtherReadingDataDetailsList());
                    Log.d("response","presenter ka  call back success");
                } else {
                    furtherReadingView.showLoading(false);
                    furtherReadingView.showMessage(furtherReadingData.getMessage());
                    Log.d("response","presenter ka  call back success ka failure");
                }
            }

            @Override
            public void onFailure(String message) {
                furtherReadingView.showLoading(false);
                furtherReadingView.showMessage("Please try again in some time");
                Log.d("response","presenter ka call back  failure");
            }
        });



    }
}
