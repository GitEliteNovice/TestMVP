package com.example.user.testmvp.Login;

/**
 * Created by user on 10/7/17.
 */

public interface LoginMvpView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void invalidCredentials();
}
