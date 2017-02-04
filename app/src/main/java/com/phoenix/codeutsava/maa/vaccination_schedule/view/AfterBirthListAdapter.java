package com.phoenix.codeutsava.maa.vaccination_schedule.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.AfterBirthListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

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

    public AfterBirthListAdapter(Context context, ScheduleScreenFragment scheduleScreenFragment) {
        this.context = context;
        this.scheduleScreenFragment = scheduleScreenFragment;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<AfterBirthListDetails> afterBirthListDetails){
        afterBirthListDetailsList =  afterBirthListDetails;

    }

    @Override
    public AfterBirthListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.schedule_item_after, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final AfterBirthListDetails afterBirthListDetails= afterBirthListDetailsList.get(position);
        holder.textView_name.setText(afterBirthListDetails.getVaccination_name());
        holder.textView_date.setText(afterBirthListDetails.getVaccination_time());


        //Map To Be Opened
        holder.button_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Map Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return afterBirthListDetailsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_name;
        private TextView textView_date;
        private Button button_map;

        private MyViewHolder(View itemView) {
            super(itemView);
            textView_date=(TextView)itemView.findViewById(R.id.textView_date);
            textView_name=(TextView)itemView.findViewById(R.id.textView_name);
            button_map = (Button)itemView.findViewById(R.id.button_map);
        }
    }
}
