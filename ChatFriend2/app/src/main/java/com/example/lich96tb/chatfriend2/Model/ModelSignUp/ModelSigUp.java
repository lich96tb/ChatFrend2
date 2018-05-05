package com.example.lich96tb.chatfriend2.Model.ModelSignUp;


public class ModelSigUp {
ModelResult modelResult;

    public ModelSigUp(ModelResult modelResult) {
        this.modelResult = modelResult;
    }

    public void handleLogin(String mail, String pass, String enterThePass) {
if (pass.equals(enterThePass)){
    modelResult.Succsess();
}else {
    modelResult.Failed("mat khau khong khop");
}
    }
}
