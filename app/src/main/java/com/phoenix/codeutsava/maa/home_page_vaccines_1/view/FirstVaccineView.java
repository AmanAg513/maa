package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineDetails;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public interface FirstVaccineView {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void setData(List<FirstVaccineDetails> firstVaccineDetails);
}
