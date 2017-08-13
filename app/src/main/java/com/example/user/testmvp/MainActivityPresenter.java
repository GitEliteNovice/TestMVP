package com.example.user.testmvp;

import com.example.user.testmvp.model.Fixtures;

import java.util.List;

/**
 * Created by user on 10/7/17.
 */

public class MainActivityPresenter implements MainActivityMvpPresenter,MainActivityMvpModel.FixtureDataListener {
    MainActivityMvpView mainActivityMvpView;
    MainActivityMvpModel mainActivityMvpModel;

    public MainActivityPresenter(MainActivityMvpView mainActivityMvpView){
    this.mainActivityMvpView=mainActivityMvpView;
        mainActivityMvpModel=new MainActivityModel();
    }

    @Override
    public void getData() {
        if (mainActivityMvpView!=null){
            mainActivityMvpView.showLoding();
        }
        mainActivityMvpModel.fetchData(this);
    }

    @Override
    public void onDestroy() {
mainActivityMvpView=null;
    }

    @Override
    public void fetchedData(List<Fixtures> dataList) {
        if (mainActivityMvpView!=null){
            mainActivityMvpModel.OnDestroy();
            mainActivityMvpView.showdata(dataList);
    mainActivityMvpView.hideLoding();
        }
    }

    @Override
    public void handleError(Exception error) {
        if (mainActivityMvpView!=null){
            mainActivityMvpView.Error(error);
                    mainActivityMvpView.hideLoding();
        }
    }
}
