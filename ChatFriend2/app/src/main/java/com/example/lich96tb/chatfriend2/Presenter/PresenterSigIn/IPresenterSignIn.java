package com.example.lich96tb.chatfriend2.Presenter.PresenterSigIn;

import com.google.firebase.auth.FirebaseUser;

public interface IPresenterSignIn {
    void SuccessSignInPresenter(FirebaseUser user);
    void FailedSignInPresenter(String error);
}
