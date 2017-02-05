package com.phoenix.codeutsava.maa.gallery.view;

import android.content.Context;
import android.os.Bundle;
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
import com.phoenix.codeutsava.maa.helper.Keys;
import com.phoenix.codeutsava.maa.home.HomePage;

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
    private GalleryView galleryView;

    public GalleryAdapter(GalleryFragment galleryFragmentFragment, Context context) {
        this.galleryFragmentFragment = galleryFragmentFragment;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
        galleryView=new GalleryFragment();
    }

    public void setData(List<GalleryDataDetails> galleryDataDetailsList) {
        DataList= galleryDataDetailsList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final GalleryDataDetails galleryDetails=DataList.get(position);
        holder.pdf.setText(galleryDetails.getVideo_name());
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof HomePage) {

//                    ((HomePage) context).playVideo(galleryDetails.getVideo_url());
                    VidPlayer vidPlayer = new VidPlayer();
                    Bundle args = new Bundle();
                    args.putString(Keys.KEY_VIDEO_URL,DataList.get(position).getVideo_url());
                    vidPlayer.setArguments(args);
                    ((HomePage) context).addFragment(vidPlayer,"Player");
                }
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.gallery_item, parent, false);
        return new MyViewHolder(itemView);

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
            play = (ImageView)itemView.findViewById(R.id.button1);
            pdf = (TextView) itemView.findViewById(R.id.text1);

        }

    }
















}
