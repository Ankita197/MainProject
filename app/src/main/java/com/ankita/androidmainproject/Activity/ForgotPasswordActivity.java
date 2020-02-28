package com.ankita.androidmainproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.ankita.androidmainproject.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{
private Button btncancle,btnSend;
private EditText edtpassword;
private TextInputLayout tilpassword;
private void init(){
    tilpassword=findViewById(R.id.evforgotpassword);
    edtpassword=findViewById(R.id.edtPassword);
    btncancle=findViewById(R.id.btncancle);
    btnSend=findViewById(R.id.btnsend);
}
private void getTransperentStatusbar(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        tilpassword=findViewById(R.id.evforgotpassword);
        edtpassword=findViewById(R.id.edtPassword);
        getTransperentStatusbar();
        init();
        btncancle.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*!=]).*$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
            switch (id){
                case R.id.btncancle:
                    onBackPressed();
                    break;
                case R.id.btnsend:
                    String password=edtpassword.getText().toString();
                        if(!isValidPassword(password)||password.isEmpty()||password.length()!=8)
                        {
                            tilpassword.setError("enter a valid password");
                        }
                        else {
                            tilpassword.setError(null);
                            onBackPressed();
                        }
                        break;
            }
    }
}
