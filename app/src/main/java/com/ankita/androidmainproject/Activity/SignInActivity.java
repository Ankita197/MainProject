package com.ankita.androidmainproject.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ankita.androidmainproject.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends BaseActivity {
    private TextView tvforgotpassword, tvsignup;
    private Button btnback,btnSignin;
    private EditText edtPhone,edtPassword;
    private TextInputLayout tilPhone,tilPassword;
    private Pattern patt1;

    private void init() {
        tvforgotpassword = findViewById(R.id.tvforgotpassword);
        tvsignup = findViewById(R.id.tvnew);
        btnback = findViewById(R.id.btnback);
        btnSignin=findViewById(R.id.btnsignin_insignin);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        tilPhone = findViewById(R.id.evphone);
        tilPassword = findViewById(R.id.evpassword);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
    private void getAnimation() {
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }
    private void doTextSpannable(String myString, int start, int end, TextView tv) {

        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(myString, TextView.BufferType.SPANNABLE);
        Spannable mySpannable = (Spannable) tv.getText();
        ClickableSpan myClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                getAnimation();
            }
        };
        mySpannable.setSpan(myClickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }
    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*!=]).*$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    private boolean isValidatePhonePassword() {
        String phone = edtPhone.getText().toString();
        String password = edtPassword.getText().toString();
        if (!phone.isEmpty() && !password.isEmpty()) {
            if (patt1.matcher(phone).matches() && isValidPassword(password)) {
                tilPhone.setError(null);
                tilPassword.setError(null);
                return true;
            } else {
                if (!patt1.matcher(phone).matches()) {
                    tilPhone.setError("please enter valid phone");
                } else {
                    tilPassword.setError("please enter valid password");
                }
                return false;
            }
        } else {
            if (phone.isEmpty()) {
                tilPhone.setError("this field is not empty");
            } else {
                tilPassword.setError("this field is not empty");
            }
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        patt1 = Pattern.compile("[1-9][0-9]{9}");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        init();
        doTextSpannable(tvsignup.getText().toString(), 9, 16, tvsignup);
        tvforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, ForgotPasswordActivity.class));
                getAnimation();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidatePhonePassword()){
                    storeValueInPreference();
                    startActivity(new Intent(SignInActivity.this,WelcomeActivity.class));
                    finish();
                }

            }
        });
    }
    private void storeValueInPreference() {
        if(!edtPhone.getText().toString().isEmpty()){
            sharedPreferenceStoreValue.storeValue(edtPhone.getText().toString());
        }
        else {
            sharedPreferenceStoreValue.storeValue("0000000000");
        }
    }

}
