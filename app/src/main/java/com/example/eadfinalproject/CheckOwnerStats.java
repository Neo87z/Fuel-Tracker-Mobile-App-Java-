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
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.time.LocalDateTime;
import java.util.Locale;
import java.time.format.DateTimeFormatter;


public class CheckOwnerStats extends AppCompatActivity {
    TextView TwoWheel,ThreeWheel,FourWheel,Other,Fuel,Location,LastRefill,NextRefill,TobePummoped,ArrivalTime,PumpedVeh;
    Button ExitQue,ConfirmPump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_owner_stats);

        TwoWheel=findViewById(R.id.textView37);
        ThreeWheel=findViewById(R.id.textView38);
        FourWheel=findViewById(R.id.textView39);
        Other=findViewById(R.id.textView40);
        Location=findViewById(R.id.textView22);
        Fuel=findViewById(R.id.textView23);
        LastRefill=findViewById(R.id.textView27);
        NextRefill=findViewById(R.id.textView28);
        TobePummoped=findViewById(R.id.textView32);
        ArrivalTime=findViewById(R.id.textView8);
        PumpedVeh=findViewById(R.id.textView30);




        //API Connection With Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

        Station ourDataSet= new Station("RegNumberTest","ImageURLText","StationNAme","AddressText","Active","0","0","0","0","1","0","0","0",false,true,false,false,false,false,false);
        Call<Station> call= ourRetrofit.GetFuelStationDataByID(ourDataSet);


        //API Calling and Handling the request
        call.enqueue(new Callback<Station>() {
            @Override
            public void onResponse(Call<Station> call, Response<Station> response) {
                TwoWheel.setText(response.body().twoWheel);
                ThreeWheel.setText(response.body().threeWheel);
                FourWheel.setText(response.body().fourWheel);
                Other.setText(response.body().other);
                Fuel.setText(response.body().fuel+" Litres Remaining");
                Location.setText(response.body().location);
                LastRefill.setText("Last Refill On :"+response.body().lastRefill);
                NextRefill.setText("Next Scheduled Refill On : "+response.body().nextRefill);
                Date DateCurrent= Calendar.getInstance().getTime();
                PumpedVeh.setText(response.body().waitTime+" Vehicles");

                ArrivalTime.setText("Owner");
                //int x=0;
                //x=Integer.parseInt(response.body().twoWheel)+Integer.parseInt(response.body().threeWheel)+Integer.parseInt(response.body().fourWheel)+Integer.parseInt(response.body().other);
                TobePummoped.setText(response.body().threeWheel+" Vehicles");

            }

            @Override
            public void onFailure(Call<Station> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

            }
        });

        //Onclick to Remove the Cards from the fuel Station


        //Confirm Pump Intent



    }
}