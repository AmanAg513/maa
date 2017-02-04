package com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data;

/**
 * Created by aman on 4/2/17.
 */

public class HomeListDetails {

    private String id;
    private String title;
    private String data;
    private int  no_read;

    public HomeListDetails(String id, String title, String data, int no_read) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.no_read = no_read;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public int getNo_read() {
        return no_read;
    }
}
