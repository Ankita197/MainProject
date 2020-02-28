package com.ankita.androidmainproject.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ankita.androidmainproject.R;
import com.google.android.material.textfield.TextInputLayout;

public class PasswordGenrationActivity extends AppCompatActivity {
    private Button btnBack, btnDone;
    private String txtRepet = "Repeat";
    private TextView tvrecivesms;
    private EditText edtPassword;
    private TextInputLayout tilPassword;

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
    private void doTextSpannable(String myString, int start, int end, TextView tv) {

        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(myString, TextView.BufferType.SPANNABLE);
        Spannable mySpannable = (Spannable) tv.getText();
        ClickableSpan myClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        };
        mySpannable.setSpan(myClickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }
    private void spanText() {
        SpannableStringBuilder ssb = new SpannableStringBuilder("Don't recive sms ");
        doTextSpannable(txtRepet, 0, txtRepet.length(), tvrecivesms);
        ssb.append(tvrecivesms.getText());
        tvrecivesms.setText(ssb);
    }
    private void init() {
        btnBack = findViewById(R.id.btnback);
        btnDone = findViewById(R.id.btndone);
        edtPassword = findViewById(R.id.edtPassword);
        tilPassword = findViewById(R.id.evPassword);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_genration);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        init();
        tvrecivesms = findViewById(R.id.tvrecivesms);
        spanText();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtPassword.getText().toString().equals("1234")) {
                    tilPassword.setError(null);
                    startActivity(new Intent(PasswordGenrationActivity.this, WelcomeActivity.class));
                    finish();
                } else {
                    tilPassword.setError("please Repeat again this is not valid password");
                }

            }
        });
    }
}
