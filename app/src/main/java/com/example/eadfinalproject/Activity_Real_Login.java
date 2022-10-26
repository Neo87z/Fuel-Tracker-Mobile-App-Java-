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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class Activity_Real_Login extends AppCompatActivity {

    EditText USerName, Password;
    Button Login;
    DBhelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_login);

        USerName=(EditText) findViewById(R.id.NameInputEditText);
        Password=(EditText) findViewById(R.id.LastNameInputEditText);
        Login=(Button) findViewById(R.id.button);
        DB= new DBhelper(this);


        //Onlick Listener to Validate The User Login Details
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gtetting Username and Password and settinmg to a String
                String UsernameDatra= USerName.getText().toString();
                String PasswordData= Password.getText().toString();

                //Logic to Check if the Provided details are valid
                if (UsernameDatra.equals("") || PasswordData.equals("")){
                    Toast.makeText(Activity_Real_Login.this, "Please Enter All The Fiels", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean CHeckUserPass= DB.CheckUSernamePassword(UsernameDatra,PasswordData);
                    if(CHeckUserPass == true){
                        Boolean CheckType= DB.CheckType(UsernameDatra);
                        if(CheckType == true){
                            Toast.makeText(Activity_Real_Login.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),ListAllPetrolSheds.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Activity_Real_Login.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),OwnerDashBoard.class);
                            startActivity(intent);

                        }


                    }else{
                        Toast.makeText(Activity_Real_Login.this, "Check Login Details", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }
}