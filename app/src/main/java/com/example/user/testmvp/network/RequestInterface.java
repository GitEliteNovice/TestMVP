package com.example.user.testmvp.network;


import com.example.user.testmvp.model.Fixtures;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("v1/fixtures")
    Observable<List<Fixtures>> fixtures();
}
