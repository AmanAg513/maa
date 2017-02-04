package com.phoenix.codeutsava.maa.further_reading.model.data;

/**
 * Created by aman on 4/2/17.
 */
public class FurtherReadingDataDetails {
    private String pdf_name;
    private String pdf_url;


    public String getPdf_name() {
        return pdf_name;
    }

    public void setPdf_name(String pdf_name) {
        this.pdf_name = pdf_name;
    }

    public String getPdf_url() {
        return pdf_url;
    }

    public void setPdf_url(String pdf_url) {
        this.pdf_url = pdf_url;
    }

    public FurtherReadingDataDetails(String pdf_name, String pdf_url) {

        this.pdf_name = pdf_name;
        this.pdf_url = pdf_url;
    }
}
