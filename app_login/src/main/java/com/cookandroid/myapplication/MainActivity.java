package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_Email, TextInputEditText_Password;                           //변수 선언(자료형-변수 순서임), 자료형은 import 해야함
    AppCompatButton btn_login_normal, btn_login_facebook, btn_login_Kakao;                           //변수 선언{자료형-변수 순서임), 자료형은 import 해야함
    String email_ok = "123@gmail.com";
    String password_ok = "1234";
    String input_email = "";
    String input_password ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_Email = findViewById(R.id.TextInputEditText_Email);                        //xml과 java의 각 기능 매칭
        TextInputEditText_Password = findViewById(R.id.TextInputEditText_Password);
        btn_login_normal = findViewById(R.id.btn_login_normal);
        btn_login_facebook = findViewById(R.id.btn_login_facebook);
        btn_login_Kakao = findViewById(R.id.btn_login_Kakao);

        //1. 값을 가져온다. ~검사 (123@gmail.com / 1234)
        //2. 클릭을 감지한다.
        //3. 1번의 값을 다음 액티비티로 넘긴다.

        btn_login_normal.setClickable(false);

        TextInputEditText_Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null){
                    input_email = s.toString();
                    if(input_email.equals(email_ok) && input_password.equals(password_ok)){
                        btn_login_normal.setClickable(true);
                    }
                    else{
                        btn_login_normal.setClickable(false);
                    }
                }
                if(s == null){
                    btn_login_normal.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        TextInputEditText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null){
                    input_password = s.toString();
                    if(input_email.equals(email_ok) && input_password.equals(password_ok)){
                        btn_login_normal.setClickable(true);
                    }
                    else {
                        btn_login_normal.setClickable(false);
                    }
                }
                if(s == null){
                    btn_login_normal.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_login_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = TextInputEditText_Email.getText().toString();                         //login 버튼의 click을 감지해서 email과 password의 값을 가져와서(String으로) 각각 새로운 변수에 할당
                String password = TextInputEditText_Password.getText().toString();

                Intent intent = new Intent(MainActivity.this, after_Login.class);                                                        //값을 받아서 다른 액티비티로 넘길 때 사용
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}