package com.phoenix.codeutsava.maa.further_reading.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class FurtherReadingAdapter extends RecyclerView.Adapter <FurtherReadingAdapter.MyViewHolder>{

    private List<FurtherReadingDataDetails> DataList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private FurtherReadingFragment furtherReadingFragment;
    private FurtherReadingView furtherReadingView;

    public FurtherReadingAdapter(Context context, FurtherReadingFragment furtherReadingFragment) {
        this.context = context;
        this.furtherReadingFragment = furtherReadingFragment;
        layoutInflater=LayoutInflater.from(context);
        furtherReadingView=new FurtherReadingFragment();
    }

    public void setData(List<FurtherReadingDataDetails> furtherReadingDataDetailsList) {
        DataList= furtherReadingDataDetailsList;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final FurtherReadingDataDetails furtherReadingDataDetails=DataList.get(position);
        holder.pdf.setText(furtherReadingDataDetails.getPdf_name());


       // holder.view.setOnClickListener();
       // holder.download.setOnClickListener();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = layoutInflater.inflate(R.layout.further_reading_item, parent, false);
        return new MyViewHolder(itemView);

    }


    @Override
    public int getItemCount() {
        return DataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView pdf;
        private Button view;
        private Button download;

        private MyViewHolder(View itemView) {
            super(itemView);

            view = (Button) itemView.findViewById(R.id.button1);
            pdf = (TextView) itemView.findViewById(R.id.text1);
            download = (Button) itemView.findViewById(R.id.button2);

        }

    }








}
