package com.phoenix.codeutsava.maa.vaccination_schedule.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.BeforeBirthListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 3/2/17.
 */

public class BeforeBirthListAdapter extends RecyclerView.Adapter<BeforeBirthListAdapter.MyViewHolder> {

    private List<BeforeBirthListDetails> beforeBirthListDetailsList=new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ScheduleScreenFragment scheduleScreenFragment;

    public BeforeBirthListAdapter(Context context, ScheduleScreenFragment scheduleScreenFragment) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.scheduleScreenFragment = scheduleScreenFragment;
    }

    public void setData(List<BeforeBirthListDetails> beforeBirthListDetails){
        beforeBirthListDetailsList =  beforeBirthListDetails;

    }

    @Override
    public BeforeBirthListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.schedule_item_before, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final BeforeBirthListDetails beforeBirthListDetails= beforeBirthListDetailsList.get(position);
        holder.textView_name.setText(beforeBirthListDetails.getName());
        holder.textView_date.setText(beforeBirthListDetails.getData());

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
        return beforeBirthListDetailsList.size();
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
