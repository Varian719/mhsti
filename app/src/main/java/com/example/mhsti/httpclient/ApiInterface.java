package com.example.mhsti.httpclient;

import com.example.mhsti.Model.Responsemhs;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiInterface {
    @GET("mhsti.json?auth=jrNUz8yqs3W3fOgx2BLaXlyF7Z2LTvdQPvAUaalr")
    Call<Responsemhs> getData();


}