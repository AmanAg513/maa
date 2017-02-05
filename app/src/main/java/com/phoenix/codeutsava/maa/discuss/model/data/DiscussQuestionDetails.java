package com.phoenix.codeutsava.maa.discuss.model.data;

/**
 * Created by aman on 5/2/17.
 */

public class DiscussQuestionDetails {

    private int qid;
    private String name;
    private String question;
    private String title;
    private int useful;
    private int replies;
    private String date;

    public DiscussQuestionDetails(int qid,String name, String question, String title, int useful, int replies, String date) {
        this.qid = qid;
        this.name = name;
        this.question = question;
        this.title = title;
        this.useful = useful;
        this.replies = replies;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getQid() {
        return qid;
    }

    public String getQuestion() {
        return question;
    }

    public String getTitle() {
        return title;
    }

    public int getUseful() {
        return useful;
    }

    public int getReplies() {
        return replies;
    }

    public String getDate() {
        return date;
    }
}
