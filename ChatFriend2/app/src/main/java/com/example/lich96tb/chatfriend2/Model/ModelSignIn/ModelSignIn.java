package com.example.lich96tb.chatfriend2.Model.ModelSignIn;

import android.support.annotation.NonNull;

import com.example.lich96tb.chatfriend2.Model.ModelSignUp.ModelResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ModelSignIn {
    private FirebaseAuth mAuth;
    private IModelSignIn iModelSignIn;

    public ModelSignIn(IModelSignIn iModelSignIn) {
        this.iModelSignIn = iModelSignIn;
    }

    public ModelSignIn(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    public void ReceivedHandlerModelSignIn(String email, String pass) {
        HandlerModel(email, pass);
    }

    private void HandlerModel(String email, String pass) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();


                            iModelSignIn.SuccessSignIn(user);
                        } else {
                            iModelSignIn.FailedSignIn(task.getException() + "");

                        }

                        // ...
                    }
                });
    }
}
