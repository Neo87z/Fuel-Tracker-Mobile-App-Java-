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

public class AddFuelStation extends AppCompatActivity {

    EditText StationName, RegNumber, ImageURL,Address;

    Button AddFuelStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel_station);
        StationName=findViewById(R.id.NameInputEditText);
        RegNumber=findViewById(R.id.LastNameInputEditText);
        ImageURL=findViewById(R.id.EmailLastNameInputEditText);
        Address=findViewById(R.id.EmailLastNameInputEditText1);
        AddFuelStation=findViewById(R.id.button);
        AddFuelStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String StationNAme = StationName.getText().toString();
                String RegNumberTest = RegNumber.getText().toString();
                String ImageURLText = ImageURL.getText().toString();
                String AddressText = Address.getText().toString();
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                Station ourDataSet= new Station(RegNumberTest,ImageURLText,StationNAme,AddressText,"Active","0","0","0","0","0","0","0","0",false,false,false,false,false,false,false);
                Call<OurDataSet> call= ourRetrofit.PostShedData(ourDataSet);



                call.enqueue(new Callback<OurDataSet>() {
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                        Toast.makeText(AddFuelStation.this, "Station Sucuessfully Added", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(getApplicationContext(),OwnerDashBoard.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<OurDataSet> call, Throwable t) {
                        Toast.makeText(AddFuelStation.this, "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });


    }
}