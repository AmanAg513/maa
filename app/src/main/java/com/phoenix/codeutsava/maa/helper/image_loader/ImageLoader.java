package com.phoenix.codeutsava.maa.helper.image_loader;

import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by aman on 3/2/17.
 */

public interface ImageLoader {

    void loadImage(String url, ImageView imageView, ProgressBar progressBar);

}

