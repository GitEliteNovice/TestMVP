package com.example.user.testmvp.Login;

/**
 * Created by user on 10/7/17.
 */

public class LoginPresenter implements LoginMvpPresenter,LoginMvpModel.OnLoginFinishedListener {
   LoginMvpView loginMvpView;
    LoginMvpModel loginMvpModel;

    public LoginPresenter(LoginMvpView loginMvpView){
        this.loginMvpView=loginMvpView;
        loginMvpModel=new LoginModel();
    }

    @Override
    public void validateLoginCredentias(String username, String password) {
if (loginMvpView!=null){
    loginMvpView.showProgress();
}
loginMvpModel.login(username,password,this);
    }

    @Override
    public void OnDestroy() {
        loginMvpView=null;
    }

    @Override
    public void onUsernameError() {
        if (loginMvpView != null) {
        loginMvpView.setUsernameError();
            loginMvpView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if (loginMvpView != null) {
loginMvpView.setPasswordError();
            loginMvpView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (loginMvpView != null) {
loginMvpView.navigateToHome();
            loginMvpView.hideProgress();
        }

    }

    @Override
    public void invalidCredential() {
        if (loginMvpView != null) {
loginMvpView.invalidCredentials();
            loginMvpView.hideProgress();
        }

    }

}
