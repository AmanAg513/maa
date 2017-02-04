package com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public class HomeData {
    private boolean success;
    private String message;
    private List<HomeListDetails> homeListDetails;

    public HomeData(boolean success, String message, List<HomeListDetails> homeListDetails) {
        this.success = success;
        this.message = message;
        this.homeListDetails = homeListDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<HomeListDetails> getHomeListDetails() {
        return homeListDetails;
    }
}
