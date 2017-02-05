package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.gallery.view.VidPlayer;
import com.phoenix.codeutsava.maa.helper.Keys;
import com.phoenix.codeutsava.maa.home.HomePage;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.view.AfterBirthListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public class HomeDetailsListAdapter extends RecyclerView.Adapter<HomeDetailsListAdapter.MyViewHolder>{
    private List<HomeListDetails>homeDatas=new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private HomeFragment homeFragment;

    public HomeDetailsListAdapter(Context context, HomeFragment homeFragment) {
        this.context = context;
        this.homeFragment = homeFragment;
        layoutInflater = LayoutInflater.from(context);
    }

    void setData(List<HomeListDetails> data)
    {
        homeDatas=data;
    }


    @Override
    public HomeDetailsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.home_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeDetailsListAdapter.MyViewHolder holder, final int position) {
        HomeListDetails homeListDetails=homeDatas.get(position);
        if(position==homeDatas.size()-1)
            holder.line.setVisibility(View.GONE);

        holder.complete.setText(""+homeListDetails.getNo_read()+" out of 4 read");
        holder.text.setText(""+homeListDetails.getData());
        holder.title.setText(""+homeListDetails.getTitle());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstVaccineFragment firstVaccineFragment = new FirstVaccineFragment();
                Bundle args = new Bundle();
                args.putString(Keys.KEY_PagerId,homeDatas.get(position).getId());
                firstVaccineFragment.setArguments(args);
                ((HomePage) context).addFragment(firstVaccineFragment,"Pager");
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView line,complete,text,title;
        private Button button;

        public MyViewHolder(View itemView) {

            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            text=(TextView)itemView.findViewById(R.id.text);
            line=(TextView)itemView.findViewById(R.id.line);
            complete=(TextView)itemView.findViewById(R.id.complete);
            button=(Button)itemView.findViewById(R.id.read_button);

        }

    }
}
