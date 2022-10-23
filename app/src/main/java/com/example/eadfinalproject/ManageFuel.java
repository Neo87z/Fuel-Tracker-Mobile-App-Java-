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

public class ManageFuel extends AppCompatActivity {

    EditText FuelAmout;
    Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_fuel);


        FuelAmout=findViewById(R.id.NameInputEditText);
        B1=findViewById(R.id.button);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FuelCount=FuelAmout.getText().toString();
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                Station ourDataSet= new Station("RegNumberTest","ImageURLText","StationNAme","AddressText","Active",FuelCount,"0","0","0","0","0","0","0",false,false,false,false,false,false,false);
                Call<OurDataSet> call= ourRetrofit.updateStationFuel(ourDataSet);



                call.enqueue(new Callback<OurDataSet>() {
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                        Toast.makeText(getApplicationContext(), "Station Fuel Updated", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(getApplicationContext(),OwnerDashBoard.class);
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