package com.phoenix.codeutsava.maa.gallery.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.gallery.GalleryCallBack;
import com.phoenix.codeutsava.maa.gallery.api.GalleryApi;
import com.phoenix.codeutsava.maa.gallery.model.data.GalleryData;
import com.phoenix.codeutsava.maa.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 4/2/17.
 */
public class GalleryRetrofitProvider implements GalleryProvider {

    private GalleryApi galleryApi;
    private Retrofit retrofit;

    @Override
    public void requestGallery(String fcm, final GalleryCallBack galleryCallBack) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        galleryApi = retrofit.create(GalleryApi.class);

Call<GalleryData>galleryDataCall=galleryApi.getGAllery(fcm);
        galleryDataCall.enqueue(new Callback<GalleryData>() {
            @Override
            public void onResponse(Call<GalleryData> call, Response<GalleryData> response) {
                galleryCallBack.onSuccess(response.body())  ;
            }

            @Override
            public void onFailure(Call<GalleryData> call, Throwable t) {

                t.printStackTrace();
                galleryCallBack.OnFailure( "Unable TO Connect");

            }
        });


    }


}
