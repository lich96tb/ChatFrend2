package com.example.lich96tb.chatfriend2.View;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lich96tb.chatfriend2.Presenter.PresenterSigIn.IPresenterSignIn;
import com.example.lich96tb.chatfriend2.Presenter.PresenterSigIn.PresenterSignIn;
import com.example.lich96tb.chatfriend2.Presenter.PresenterSignUp.IPrisenterSigUpResult;
import com.example.lich96tb.chatfriend2.Presenter.PresenterSignUp.PrisenterSignUp;
import com.example.lich96tb.chatfriend2.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IPrisenterSigUpResult,IPresenterSignIn,GoogleApiClient.OnConnectionFailedListener {
    private EditText edtMail, edtPass, edtEnterThePass;
    private CheckBox checkBox;
    private TextView txtSigup, txtResetpPass, txtSigIn;
    private Button btnSigUp, btnSigIn;
    private String email, pass, enterThePass;
    private SignInButton signInButtonGoogle;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        GoogleCheck();

    }

    private void GoogleCheck() {
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,  this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();

    }

    private void init() {
        edtMail = findViewById(R.id.edtMail);
        edtPass = findViewById(R.id.edtPass);
        edtEnterThePass = findViewById(R.id.edtEnterThePass);
        checkBox = findViewById(R.id.checkbox);
        txtSigup = findViewById(R.id.txt_sigup);
        txtResetpPass = findViewById(R.id.txt_reset_pass);
        txtSigIn = findViewById(R.id.txt_sing_in);
        btnSigUp = findViewById(R.id.btnSigup);
        btnSigIn = findViewById(R.id.btnSigin);
        signInButtonGoogle=findViewById(R.id.btn_sign_in_gooole);
        signInButtonGoogle.setOnClickListener(this);

        btnSigIn.setOnClickListener(this);
        btnSigUp.setOnClickListener(this);
        txtSigup.setOnClickListener(this);
        txtResetpPass.setOnClickListener(this);
        txtSigIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        email = edtMail.getText().toString();
        pass = edtPass.getText().toString();
        enterThePass = edtEnterThePass.getText().toString();
        switch (v.getId()) {
            case R.id.btnSigin:
                PresenterSignIn presenterSignIn=new PresenterSignIn(this);
                presenterSignIn.ReceivedHanlerPresenterSignIn(email,pass);
                break;
            case R.id.btnSigup:
                PrisenterSignUp prisenterSignUp = new PrisenterSignUp(this);
                prisenterSignUp.PrisenterSignUp(email, pass, enterThePass);
                break;
            case R.id.btn_sign_in_gooole:
                SignInGoogle();
                break;
            case R.id.txt_reset_pass:

                break;
            case R.id.txt_sigup:
                btnSigUp.setVisibility(View.VISIBLE);
                btnSigIn.setVisibility(View.GONE);
                edtEnterThePass.setVisibility(View.VISIBLE);
                txtResetpPass.setVisibility(View.GONE);
                txtSigup.setVisibility(View.GONE);
                checkBox.setVisibility(View.GONE);
                txtSigIn.setVisibility(View.VISIBLE);
                break;
            case R.id.txt_sing_in:
                btnSigUp.setVisibility(View.GONE);
                btnSigIn.setVisibility(View.VISIBLE);
                edtEnterThePass.setVisibility(View.GONE);
                txtResetpPass.setVisibility(View.VISIBLE);
                txtSigup.setVisibility(View.VISIBLE);
                checkBox.setVisibility(View.VISIBLE);
                txtSigIn.setVisibility(View.GONE);
                break;
        }
    }



    @Override
    public void loginSuccsess() {
        Toast.makeText(this, "thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Failed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SuccessSignInPresenter(FirebaseUser user) {
        Intent intent=new Intent(this,MainChatFrend.class);
        startActivity(intent);
        Toast.makeText(this, "đang nhap thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FailedSignInPresenter(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
    private void SignInGoogle() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                String name = account.getDisplayName();
                Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
