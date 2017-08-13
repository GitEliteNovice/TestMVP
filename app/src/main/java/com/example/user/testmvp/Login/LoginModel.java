package com.example.user.testmvp.Login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by user on 10/7/17.
 */

public class LoginModel implements LoginMvpModel {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              if (TextUtils.isEmpty(username)){
                  listener.onUsernameError();
              }else if (TextUtils.isEmpty(password)){
                  listener.onPasswordError();
              }else if (username.equalsIgnoreCase(password)){
                  listener.onSuccess();
              }else {
                  listener.invalidCredential();
              }
            }
        },2000);
    }
}
