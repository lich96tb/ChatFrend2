package com.example.lich96tb.chatfriend2.Model.ModelSignIn;

import com.google.firebase.auth.FirebaseUser;

public interface IModelSignIn {
    void SuccessSignIn(FirebaseUser user);
    void FailedSignIn(String error);
}
