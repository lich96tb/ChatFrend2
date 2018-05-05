package com.example.lich96tb.chatfriend2.Model.ModelSignUp;


import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ModelSigUp {
    ModelResult modelResult;
    private FirebaseAuth mAuth;

    public ModelSigUp(ModelResult modelResult) {
        this.modelResult = modelResult;
    }

    public void handleLogin(String mail, String pass, String enterThePass) {
        if (pass.equals(enterThePass)==false){
            modelResult.Failed("mat khau khong khop");
        }else {
            HandlerSigUp(mail,pass);
        }
    }

    private void HandlerSigUp(final String mail, String pass) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            modelResult.Succsess();
                        } else {
                            modelResult.Failed(task.getException()+"");
                        }

                        // ...
                    }
                });

    }
}
