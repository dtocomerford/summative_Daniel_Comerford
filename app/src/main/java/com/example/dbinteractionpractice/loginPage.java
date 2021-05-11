package com.example.dbinteractionpractice;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.channels.InterruptedByTimeoutException;

public class loginPage extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        Intent intent = getIntent();
        int num = intent.getIntExtra("number", 0);
    }


    public void goToWelcomePage(View v)
    {
        EditText userName = (EditText) findViewById(R.id.editTextUName);
        EditText password = (EditText) findViewById(R.id.editTextPass);

        myDBConnector objDBConnector = new myDBConnector(this, null, null, 1);

        if(objDBConnector.checkLogin(userName.getText().toString(), password.getText().toString() ) )
        {
            goToWelcomePage();
        }else
        {
            Toast.makeText(getApplicationContext(), "Unsuccessful login", Toast.LENGTH_LONG).show();
        }


    }

    public <T extends AppCompatActivity> void openPage(Class<T> page)
    {
        Intent intent = new Intent(this, page);
        startActivity(intent);
    }

    public void goToRegisterPage(View v)
    {
        openPage(MainActivity.class);
    }

    public void goToWelcomePage()
    {
        openPage(welcomePage.class);
    }

}
