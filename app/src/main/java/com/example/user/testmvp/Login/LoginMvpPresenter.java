package com.example.user.testmvp.Login;

/**
 * Created by user on 10/7/17.
 */

public interface LoginMvpPresenter {

    void validateLoginCredentias(String username,String password);

    void OnDestroy();
}
