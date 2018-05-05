package com.example.lich96tb.chatfriend2.Presenter.PresenterSigIn;

import com.example.lich96tb.chatfriend2.Model.ModelSignIn.IModelSignIn;
import com.example.lich96tb.chatfriend2.Model.ModelSignIn.ModelSignIn;
import com.google.firebase.auth.FirebaseUser;

public class PresenterSignIn implements IModelSignIn {
    IPresenterSignIn iPresenterSignIn;

    public PresenterSignIn(IPresenterSignIn iPresenterSignIn) {
        this.iPresenterSignIn = iPresenterSignIn;
    }

    public void ReceivedHanlerPresenterSignIn(String email, String pass) {
        ModelSignIn modelSignIn = new ModelSignIn(this);
        modelSignIn.ReceivedHandlerModelSignIn(email, pass);

    }


    @Override
    public void SuccessSignIn(FirebaseUser user) {
        iPresenterSignIn.SuccessSignInPresenter(user);
    }

    @Override
    public void FailedSignIn(String error) {
        iPresenterSignIn.FailedSignInPresenter(error);
    }
}
