package com.example.dbinteractionpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class   MainActivity extends AppCompatActivity {


    public int num = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
    }


    // Allows passage of one page to another
    public <T extends AppCompatActivity> void openPage(Class<T> page)
    {
        Intent intent = new Intent(this, page);
        intent.putExtra("number", num);
        startActivity(intent);
    }


    public void addNewUser(View view)
    {
        myDBConnector dbHandler = new myDBConnector(this, null, null, 1);

        EditText name = (EditText) findViewById(R.id.editTextUName);
        EditText userName = (EditText) findViewById(R.id.editTextPass);
        EditText password = (EditText) findViewById(R.id.editTextPassword);

        dbHandler.addNewUser(name.getText().toString(),
                                userName.getText().toString(),
                                password.getText().toString());

        Toast.makeText(getApplicationContext(),
                        "Successfully registered with the following details\n" +
                        dbHandler.findUser(userName.getText().toString()),
                        Toast.LENGTH_LONG).show();

    }

    //Skip the reg page
    public void goToLoginPage(View v)
    {
        openPage(loginPage.class);
    }

}