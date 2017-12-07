package com.patrick.labquiz_dec124itb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView tv_Username;
    Button btn_Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_Username = findViewById(R.id.tvUser);
        btn_Logout = findViewById(R.id.btnLogout);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tv_Username.setText(user);

    }

    public void calllogout (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
