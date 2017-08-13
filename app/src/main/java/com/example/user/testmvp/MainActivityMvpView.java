package com.example.user.testmvp;

import com.example.user.testmvp.model.Fixtures;

import java.util.List;

/**
 * Created by user on 10/7/17.
 */

public interface MainActivityMvpView {
void showLoding();
    void hideLoding();
    void showdata(List<Fixtures> dataList);
    void Error(Exception e);
}
