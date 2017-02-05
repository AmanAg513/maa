package com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data;

/**
 * Created by aman on 4/2/17.
 */

public class HomeListDetails {

    private String id;
    private String data;
    private int  no_read;
    private String title;

    public HomeListDetails(String id, String data, int no_read, String title) {
        this.id = id;
        this.data = data;
        this.no_read = no_read;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public int getNo_read() {
        return no_read;
    }
}
