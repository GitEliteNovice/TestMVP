package com.example.user.testmvp;

import com.example.user.testmvp.model.Fixtures;

import java.util.List;

/**
 * Created by user on 10/7/17.
 */

public interface MainActivityMvpModel {
    interface FixtureDataListener{
        void fetchedData(List<Fixtures> dataList);
    void handleError(Exception error);
    }
    void fetchData(FixtureDataListener dataListener);
void OnDestroy();
}
