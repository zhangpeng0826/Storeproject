package com.example.storeproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etNameLogin;
    private EditText etPwdLogin;
    private Button btnLogin;
    private TextView tvRegisterNameLogin;
    private TextView tvForgetPwdLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        etNameLogin = findViewById(R.id.et_name_login);
        etPwdLogin = findViewById(R.id.et_pwd_login);
        btnLogin = findViewById(R.id.btn_login);
        tvRegisterNameLogin = findViewById(R.id.tv_register_name_login);
        tvForgetPwdLogin = findViewById(R.id.tv_forget_pwd_login);
    }
}