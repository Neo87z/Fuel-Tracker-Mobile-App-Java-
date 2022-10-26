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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfrimPump extends AppCompatActivity {

    Button ConfirmPump;

    EditText PumpValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrim_pump);
        ConfirmPump=findViewById(R.id.button);

        PumpValue=findViewById(R.id.NameInputEditText);

        //On click Listener to Confirm the Fuel Pump
        ConfirmPump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting User Inputs
                String FuelCount=PumpValue.getText().toString();
                //API Connection With Retrofit
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);
                //Setting Data to Send to Backend
                Station ourDataSet= new Station("RegNumberTest","ImageURLText","StationNAme","AddressText","Active",FuelCount,"0","0","0","0","0","0","0",false,false,false,false,true,false,false);
                Call<OurDataSet> call= ourRetrofit.UpdateFuel(ourDataSet);


                //Calling the API and Handling the Request
                call.enqueue(new Callback<OurDataSet>() {
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                        Toast.makeText(getApplicationContext(), "Station Fuel Updated", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(getApplicationContext(),ListAllPetrolSheds.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<OurDataSet> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}