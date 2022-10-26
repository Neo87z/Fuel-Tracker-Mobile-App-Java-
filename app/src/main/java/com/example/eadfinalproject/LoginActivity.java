/*
 * //**
 *  Created By Dulanji Vithnage (IT19142142), Imalshi Dias (IT19183978), Pawani Weerasinghe (IT19133546).
 * Copyright(c) 2022 . All Rights reserved.
 *  This project was done for the EAD Assignment  1
 * /
 */

package com.example.eadfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {


    EditText username, password,fname,lname;
    Button Register;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText) findViewById(R.id.EmailLastNameInputEditText);
        password=(EditText) findViewById(R.id.PasswwordLastNameInputEditText);
        fname=(EditText) findViewById(R.id.NameInputEditText);
        lname=(EditText) findViewById(R.id.LastNameInputEditText);
        Register=(Button) findViewById(R.id.button);
        DB= new DBhelper(this);


        //Onclick toRegister USer. Initial Stage
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String passwords=password.getText().toString();
                String Firstname=fname.getText().toString();
                String LastName=lname.getText().toString();

                if(user.equals("") || passwords.equals("") || Firstname.equals("") || LastName.equals("")){
                    Toast.makeText(LoginActivity.this,"Please Enter All The Fields",Toast.LENGTH_LONG).show();
                }else{
                    Boolean CheckUser=DB.checkUserName(user);
                    if(CheckUser == false){
                        Boolean insert= DB.insertData(user,passwords,Firstname,LastName);
                        if(insert == true){

                            Toast.makeText(LoginActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(getApplicationContext(),ActivityVehcicleInfo.class);
                            intent.putExtra("EXTRA_SESSION_USER", user);
                            intent.putExtra("EXTRA_SESSION_FNAME", Firstname);
                            intent.putExtra("EXTRA_SESSION_LNAME", LastName);
                            startActivity(intent);

                        }else{
                            Toast.makeText(LoginActivity.this,"Error Occured Try Again",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this,"Email Address Already Exists",Toast.LENGTH_LONG).show();
                    }
                }



            }
        });
    }
}