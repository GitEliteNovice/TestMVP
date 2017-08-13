package com.example.user.testmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.testmvp.adapter.MyReportAdapter;
import com.example.user.testmvp.model.Fixtures;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements MainActivityMvpView {
ProgressBar progress;
    MyReportAdapter reportAdapter;
    ListView listview;
    MainActivityMvpPresenter mainActivityMvpPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //progressbar
        progress=(ProgressBar)findViewById(R.id.progress);

        listview=(ListView)findViewById(R.id.listview);
        reportAdapter=new MyReportAdapter(MainActivity.this,R.layout.fixturelayout);
        listview.setAdapter(reportAdapter);

        mainActivityMvpPresenter=new MainActivityPresenter(this);
        mainActivityMvpPresenter.getData();

    }

    @Override
    public void showLoding() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoding() {
progress.setVisibility(View.GONE);
    }

    @Override
    public void showdata(List<Fixtures> dataList) {

        for (Fixtures data : dataList) {
            reportAdapter.add(data);
        }
    }

    @Override
    public void Error(Exception e) {
        Toast.makeText(this, "Error "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
