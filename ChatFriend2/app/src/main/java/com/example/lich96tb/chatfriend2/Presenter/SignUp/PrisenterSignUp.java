package com.example.lich96tb.chatfriend2.Presenter.SignUp;

import com.example.lich96tb.chatfriend2.Model.ModelSignUp.ModelResult;
import com.example.lich96tb.chatfriend2.Model.ModelSignUp.ModelSigUp;

public class PrisenterSignUp implements ModelResult {
    IPrisenterSigUpResult iPrisenterSigUpResult;

    public PrisenterSignUp(IPrisenterSigUpResult iPrisenterSigUpResult) {
        this.iPrisenterSigUpResult = iPrisenterSigUpResult;
    }

    public void PrisenterSignUp(String email, String pass, String enterThePass) {
        ModelSigUp modelSigUp = new ModelSigUp(this);
        modelSigUp.handleLogin(email, pass, enterThePass);
    }

    @Override
    public void Succsess() {
        iPrisenterSigUpResult.loginSuccsess();
    }

    @Override
    public void Failed(String error) {
        iPrisenterSigUpResult.Failed(error);
    }
}
