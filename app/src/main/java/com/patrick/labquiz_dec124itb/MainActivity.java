package com.patrick.labquiz_dec124itb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_Username;
    EditText et_Password;
    Button btn_Remember;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_Username = findViewById(R.id.etUser);
        et_Password = findViewById(R.id.etPass);
        btn_Remember = findViewById(R.id.btnRem);
        btn_Login = findViewById(R.id.btnLogin);

        et_Username.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String user = preferences.getString("username", "");
                String pass = preferences.getString("password", "");

                String sUsername = et_Username.getText().toString();

                if (!user.isEmpty()) {
                    if (sUsername.equals(user)) {
                        et_Password.setText(pass);
                    } else if (!(sUsername.equals(user))) {
                        et_Password.setText("");
                    }
                }

                return false;
            }
        });

        et_Password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String user = preferences.getString("username", "");
                    String pass = preferences.getString("password", "");

                    String sUsername = et_Username.getText().toString();

                    if (!user.isEmpty()) {
                        if (sUsername.equals(user)) {
                            et_Password.setText(pass);
                        } else if (!(sUsername.equals(user))) {
                            et_Password.setText("");
                        }
                    }

                }
            }
        });
    }

    public void rememberMe(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_Username.getText().toString());
        editor.putString("password", et_Password.getText().toString());
        editor.commit();
        Toast.makeText(this, "User Credentials has been saved!", Toast.LENGTH_SHORT).show();

    }

    public void calllogin(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}