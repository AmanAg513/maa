package com.phoenix.codeutsava.maa.gallery.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;
import com.phoenix.codeutsava.maa.further_reading.view.FurtherReadingFragment;
import com.phoenix.codeutsava.maa.gallery.model.data.GalleryDataDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class GalleryAdapter extends RecyclerView.Adapter <GalleryAdapter.MyViewHolder>{

    private List<GalleryDataDetails> DataList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private GalleryFragment galleryFragmentFragment;

    public GalleryAdapter(GalleryFragment galleryFragmentFragment, Context context) {
        this.galleryFragmentFragment = galleryFragmentFragment;
        this.context = context;
    }

    public void setData(List<GalleryDataDetails> galleryDataDetailsList) {
        DataList= galleryDataDetailsList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final GalleryDataDetails galleryDetails=DataList.get(position);
        holder.pdf.setText(galleryDetails.getVideo_name());


         //holder.play.setOnClickListener();


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView pdf;
        private ImageView play;

        private MyViewHolder(View itemView) {
            super(itemView);

            play = (ImageView) itemView.findViewById(R.id.button1);
            pdf = (TextView) itemView.findViewById(R.id.text1);


        }

    }
















}
