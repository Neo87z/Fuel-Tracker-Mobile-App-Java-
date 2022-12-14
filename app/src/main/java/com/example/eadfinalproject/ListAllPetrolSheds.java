/*
 * //**
 *  Created By Dulanji Vithnage (IT19142142), Imalshi Dias (IT19183978), Pawani Weerasinghe (IT19133546).
 * Copyright(c) 2022 . All Rights reserved.
 *  This project was done for the EAD Assignment  1
 * /
 */

package com.example.eadfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAllPetrolSheds extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, email, age;

    String Name,FuelDat,Date;
    ImageView ImageVutton;

    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_petrol_sheds);

        name = new ArrayList<>();
        email = new ArrayList<>();
        age = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, name, email, age);
        recyclerView.setAdapter(adapter);
        ImageVutton=findViewById(R.id.imageView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

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
                Name=(response.body().location);
                FuelDat=(response.body().fuel);
                Date=(response.body().nextRefill);
                displaydata();


            }

            @Override
            public void onFailure(Call<Station> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

            }
        });


        ImageVutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                Station ourDataSet= new Station("RegNumberTest","ImageURLText","StationNAme","AddressText","Active","0","0","0","0","1","0","0","0",false,true,false,false,false,false,false);
                Call<OurDataSet> call= ourRetrofit.UpdateVehciles(ourDataSet);



                call.enqueue(new Callback<OurDataSet>() {
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                        //Toast.makeText(getApplicationContext(), "Station Data  Updated", Toast.LENGTH_SHORT).show();



                    }

                    @Override
                    public void onFailure(Call<OurDataSet> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

                    }
                });


                Intent intent= new Intent(getApplicationContext(),InsideShed.class);
                startActivity(intent);
            }
        });
    }

    private void displaydata()
    {


        name.add("Colombo Fuel Station");
        email.add("240l");
        age.add("2022/01/22");
        name.add("Kadawatha Fuel Station");
        email.add("2400l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("5400l");
        age.add("2022/01/22");
        name.add("Mahragma Petrol Station");
        email.add("900l");
        age.add("2022/01/22");

        name.add(Name);
        email.add(FuelDat);
        age.add(Date);


    }
}