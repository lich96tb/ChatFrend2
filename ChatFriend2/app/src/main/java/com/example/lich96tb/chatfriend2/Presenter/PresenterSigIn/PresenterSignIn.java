package com.example.lich96tb.chatfriend2.Presenter.PresenterSigIn;

import com.example.lich96tb.chatfriend2.Model.ModelSignIn.ModelSignIn;

public class PresenterSignIn {
    public void ReceivedHanlerPresenterSignIn(String email,String pass){
        ModelSignIn modelSignIn=new ModelSignIn();
        modelSignIn.ReceivedHandlerModelSignIn(email,pass);

    }
}
