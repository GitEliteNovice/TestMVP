package com.example.user.testmvp.Login;

/**
 * Created by user on 10/7/17.
 */

public interface LoginMvpModel {


    interface OnLoginFinishedListener{
        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void invalidCredential();
    }

    void login(String username, String password,OnLoginFinishedListener listener);
}
