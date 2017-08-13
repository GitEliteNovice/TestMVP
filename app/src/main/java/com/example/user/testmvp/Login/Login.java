package com.example.user.testmvp.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.testmvp.MainActivity;
import com.example.user.testmvp.R;

public class Login extends AppCompatActivity implements LoginMvpView,View.OnClickListener{
    EditText user;
    EditText pass;
    Button submit;
    ProgressBar progress;
LoginMvpPresenter loginMvpPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //edit text
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);

        //button
        submit=(Button)findViewById(R.id.submit);

        //progressbar
        progress=(ProgressBar)findViewById(R.id.progress);

        //onclicklisteners
        submit.setOnClickListener(this);

        loginMvpPresenter=new LoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        if (view==submit){
loginMvpPresenter.validateLoginCredentias(user.getText().toString(),pass.getText().toString());
        }
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        user.setError("Empty Field");
    }

    @Override
    public void setPasswordError() {
        pass.setError("Empty Field");
    }

    @Override
    public void navigateToHome() {
        Intent i=new Intent(Login.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    public void invalidCredentials() {
        Toast.makeText(getApplicationContext(),"invalid Credentials",Toast.LENGTH_LONG).show();
    }

}
