package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public class ViewPagerAdapter extends PagerAdapter{
    private Context context;
    private List<FirstVaccineDetails> firstVaccineDetailsList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
