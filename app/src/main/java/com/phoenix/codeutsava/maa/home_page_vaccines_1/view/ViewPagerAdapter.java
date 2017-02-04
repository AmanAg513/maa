package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
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

    public void setData(List<FirstVaccineDetails> firstVaccineDetailsList){
        this.firstVaccineDetailsList=firstVaccineDetailsList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.first_viewpager_item, container, false);
        container.addView(view);
        FirstVaccineDetails firstVaccineDetails= firstVaccineDetailsList.get(position);
        TextView question=(TextView)view.findViewById(R.id.first_question);
        TextView status=(TextView)view.findViewById(R.id.first_status);
        question.setText(firstVaccineDetails.getQuestion_data());
        if(firstVaccineDetails.getQuestion_status().equals("1"))
        {
            status.setText("Completed");
        }
        else{
            status.setText("Not Completed");

        }



        return view;
    }

    @Override
    public int getCount() {
        return firstVaccineDetailsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
