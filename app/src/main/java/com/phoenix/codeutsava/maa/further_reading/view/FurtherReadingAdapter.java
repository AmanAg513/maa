package com.phoenix.codeutsava.maa.further_reading.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class FurtherReadingAdapter{

    private List<FurtherReadingDataDetails> DataList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private FurtherReadingFragment furtherReadingFragment;

    public FurtherReadingAdapter(Context context, FurtherReadingFragment furtherReadingFragment) {
        this.context = context;
        this.furtherReadingFragment = furtherReadingFragment;
    }

}
