package com.thenewboston.sharedbear65;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thenewboston.sharedbear65.R;


public class MainActivity extends ActionBarActivity {
    EditText usernameInput;
    EditText passwordInput;
    TextView buckysText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        buckysText = (TextView) findViewById(R.id.buckysText);
    }

    // Save the user's login Info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    // Print out the saved data
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");
        buckysText.setText(name + ' ' + pw);
    }
}
