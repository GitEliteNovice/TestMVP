package com.example.user.testmvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.example.user.testmvp.adapter.DataAdapter;
import com.example.user.testmvp.model.Fixtures;
import com.example.user.testmvp.network.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 10/7/17.
 */

public class MainActivityModel implements MainActivityMvpModel {
    String BASE_URL="http://api.football-data.org/";
    private CompositeDisposable mCompositeDisposable;
    FixtureDataListener dataListener;
    @Override
    public void fetchData(FixtureDataListener dataListener) {
this.dataListener=dataListener;
        mCompositeDisposable = new CompositeDisposable();
        loadJSON();

    }

    @Override
    public void OnDestroy() {
        mCompositeDisposable.clear();
    }

    private void loadJSON() {

        Gson gson = new GsonBuilder().registerTypeAdapter(List.class, new DataAdapter(AppController.getContext())).create();
        RequestInterface requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(RequestInterface.class);

        mCompositeDisposable.add(requestInterface.fixtures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(List<Fixtures> dataList) {

dataListener.fetchedData(dataList);
    }

    private void handleError(Throwable error) {
dataListener.handleError((Exception) error);

    }



}
