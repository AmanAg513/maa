package com.phoenix.codeutsava.maa.vaccination_schedule.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.AfterBirthListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public class AfterBirthListAdapter extends RecyclerView.Adapter<AfterBirthListAdapter.MyViewHolder>
{

    private List<AfterBirthListDetails> afterBirthListDetailsList=new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ScheduleScreenFragment scheduleScreenFragment;

    public AfterBirthListAdapter(Context context, LayoutInflater layoutInflater, ScheduleScreenFragment scheduleScreenFragment) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.scheduleScreenFragment = scheduleScreenFragment;
    }

    public void setData(List<AfterBirthListDetails> afterBirthListDetails){
        afterBirthListDetailsList =  afterBirthListDetails;

    }

    @Override
    public AfterBirthListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AfterBirthListAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
