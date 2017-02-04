package com.phoenix.codeutsava.maa.gallery.model.data;

/**
 * Created by aman on 4/2/17.
 */
public class GalleryDataDetails {
    private String video_name;
    private String video_url;

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public GalleryDataDetails(String video_name, String video_url) {

        this.video_name = video_name;
        this.video_url = video_url;
    }
}
