package com.phoenix.codeutsava.maa.discuss.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.discuss.model.data.DiscussQuestionDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 5/2/17.
 */

public class DiscussQuestionsAdapter extends RecyclerView.Adapter<DiscussQuestionsAdapter.MyViewHolder> {

    private List<DiscussQuestionDetails> discussQuestionDetailsList=new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private Questions questionsFragment;

    public DiscussQuestionsAdapter(Context context, Questions questionsFragment) {
        this.context = context;
        this.questionsFragment=questionsFragment;
        layoutInflater=LayoutInflater.from(context);
    }

    public void setData(List<DiscussQuestionDetails> discussQuestionDetails){
        discussQuestionDetailsList=discussQuestionDetails;

    }

    @Override
    public DiscussQuestionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.question_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DiscussQuestionsAdapter.MyViewHolder holder, int position) {

        final DiscussQuestionDetails discussQuestionDetails= discussQuestionDetailsList.get(position);
        holder.textView_name.setText(discussQuestionDetails.getName());
        holder.textView_question.setText(discussQuestionDetails.getQuestion());
        holder.textView_title.setText(discussQuestionDetails.getTitle());
        holder.textView_date.setText(discussQuestionDetails.getDate());
        holder.useful.setText("Useful"+discussQuestionDetails.getUseful());
        holder.replies.setText("Replies"+discussQuestionDetails.getReplies());

    }

    @Override
    public int getItemCount() {
        return discussQuestionDetailsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView textView_name;
        private TextView textView_date;
        private TextView textView_title;
        private TextView textView_question;
        private Button useful;
        private Button replies;



        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.profile_image);
            textView_name=(TextView) itemView.findViewById(R.id.name);
            textView_date=(TextView) itemView.findViewById(R.id.date);
            textView_title=(TextView) itemView.findViewById(R.id.title);
            textView_question=(TextView) itemView.findViewById(R.id.question);
            useful=(Button) itemView.findViewById(R.id.useful);
            replies=(Button) itemView.findViewById(R.id.replies);


        }
    }
}
