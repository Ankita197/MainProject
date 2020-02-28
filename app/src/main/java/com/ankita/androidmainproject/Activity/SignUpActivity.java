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
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ankita.androidmainproject.DataBaseModel.AppDataBase;
import com.ankita.androidmainproject.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class SignUpActivity extends BaseActivity implements View.OnClickListener {
    private static int i=0;
    private Button btnsignup, btnback;
    private TextView tvhaveanaccount, tvagree;
    private EditText evname, evphone;
    private TextInputLayout tilname, tilphone;
    private String anaccount = "I have an account", iagree = "terms & condition";
    private Pattern patt, patt1;
    private AppDataBase dataBase;
    private void init() {
        btnsignup = findViewById(R.id.btnsignup);
        tvhaveanaccount = findViewById(R.id.tvhaveanaccount);
        tilname = findViewById(R.id.evname);
        tilphone = findViewById(R.id.evphone);
        evname = findViewById(R.id.edtname);
        evphone = findViewById(R.id.edtphone);
        btnback = findViewById(R.id.btnback);
        tvagree = findViewById(R.id.tvagree);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnsignup:
                if(isValidatePhonePassword()) {
                    storeValueInPreference();
                    startActivity(new Intent(SignUpActivity.this, PasswordGenrationActivity.class));
                    finish();
                }
                getAnimation();
                break;
            case R.id.btnback:
                onBackPressed();
                break;
        }
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
            public void onClick(View widget) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                getAnimation();
            }
        };
        mySpannable.setSpan(myClickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }

    private void spanText() {
        SpannableStringBuilder ssb = new SpannableStringBuilder("I agree with ");
        doTextSpannable(iagree, 0, iagree.length(), tvagree);
        ssb.append(tvagree.getText());
        tvagree.setText(ssb);
    }

    private boolean isValidatePhonePassword() {
        String phone = evphone.getText().toString();
        String name = evname.getText().toString();
        if (!phone.isEmpty() && !name.isEmpty()) {
            if (patt1.matcher(phone).matches() && patt.matcher(name).matches()) {
                tilname.setError(null);
                tilphone.setError(null);
                return true;
            } else {
                if (!patt1.matcher(phone).matches()) {
                    tilphone.setError("please enter valid phone");
                } else {
                    tilname.setError("please enter valid password");
                }
                return false;
            }
        } else {
            if (phone.isEmpty()) {
                tilphone.setError("this field is not empty");
            } else {
                tilname.setError("this field is not empty");
            }
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        patt = Pattern.compile("[A-Za-z][a-z]+");
        patt1 = Pattern.compile("[1-9][0-9]{9}");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        init();
        doTextSpannable(anaccount, 7, 17, tvhaveanaccount);
        spanText();
        btnsignup.setOnClickListener(this);
        tvhaveanaccount.setOnClickListener(this);
        btnback.setOnClickListener(this);
    }

    private void storeValueInPreference() {
        if(!evphone.getText().toString().isEmpty()){
            sharedPreferenceStoreValue.storeValue(evphone.getText().toString());
        }
        else {
            sharedPreferenceStoreValue.storeValue("0000000000");
        }
    }


}
