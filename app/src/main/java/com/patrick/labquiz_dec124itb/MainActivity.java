package com.patrick.labquiz_dec124itb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText et_user;
    EditText et_pass;
    Button btn_Rem;
    Button btn_Login;
    FileInputStream fis;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_user = findViewById(R.id.etUser);
        et_pass = findViewById(R.id.etPass);
        btn_Rem = findViewById(R.id.btnRem);
        btn_Login = findViewById(R.id.btnLogin);

        et_user.addTextChangedListener(mTextWatcher);
        et_pass.addTextChangedListener(mTextWatcher);


    }

    public void rememberMe (View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_user.getText().toString());
        editor.putString("password", et_pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Preferences Saved!", Toast.LENGTH_SHORT).show();

    }

    public void login (View view){

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String user = preferences.getString("username","");
            String pwd = preferences.getString("password","");
            if (user == et_user.getText().toString()){
                et_pass.setText(pwd);
            }
            else{

            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}
