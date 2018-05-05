package com.example.lich96tb.chatfriend2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lich96tb.chatfriend2.Presenter.PresenterSigIn.PresenterSignIn;
import com.example.lich96tb.chatfriend2.Presenter.PresenterSignUp.IPrisenterSigUpResult;
import com.example.lich96tb.chatfriend2.Presenter.PresenterSignUp.PrisenterSignUp;
import com.example.lich96tb.chatfriend2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IPrisenterSigUpResult {
    private EditText edtMail, edtPass, edtEnterThePass;
    private CheckBox checkBox;
    private TextView txtSigup, txtResetpPass, txtSigIn;
    private Button btnSigUp, btnSigIn;
    private String email, pass, enterThePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

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
                PresenterSignIn presenterSignIn=new PresenterSignIn();
                presenterSignIn.ReceivedHanlerPresenterSignIn(email,pass);
                break;
            case R.id.btnSigup:
                PrisenterSignUp prisenterSignUp = new PrisenterSignUp(this);
                prisenterSignUp.PrisenterSignUp(email, pass, enterThePass);

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
        Toast.makeText(this, "loi "+error, Toast.LENGTH_SHORT).show();
    }
}
