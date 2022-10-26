package com.example.eadfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InsideShed extends AppCompatActivity {
    TextView TwoWheel,ThreeWheel,FourWheel,Other,Fuel,Location,LastRefill,NextRefill;
    Button ExitQue,ConfirmPump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_shed);
        ExitQue=findViewById(R.id.button6);
        ConfirmPump=findViewById(R.id.button5);
        TwoWheel=findViewById(R.id.textView37);
        ThreeWheel=findViewById(R.id.textView38);
        FourWheel=findViewById(R.id.textView39);
        Other=findViewById(R.id.textView40);
        Location=findViewById(R.id.textView22);
        Fuel=findViewById(R.id.textView23);
        LastRefill=findViewById(R.id.textView27);
        NextRefill=findViewById(R.id.textView28);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

        Station ourDataSet= new Station("RegNumberTest","ImageURLText","StationNAme","AddressText","Active","0","0","0","0","1","0","0","0",false,true,false,false,false,false,false);
        Call<Station> call= ourRetrofit.GetFuelStationDataByID(ourDataSet);



        call.enqueue(new Callback<Station>() {
            @Override
            public void onResponse(Call<Station> call, Response<Station> response) {
                TwoWheel.setText(response.body().twoWheel);
                ThreeWheel.setText(response.body().threeWheel);
                FourWheel.setText(response.body().fourWheel);
                Other.setText(response.body().other);
                Fuel.setText(response.body().fuel);
                Location.setText(response.body().location);
                LastRefill.setText("Last Refill On :"+response.body().lastRefill);
                NextRefill.setText("Next Scheduled Refill On :"+response.body().nextRefill);
            }

            @Override
            public void onFailure(Call<Station> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

            }
        });


        ExitQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                Station ourDataSet= new Station("RegNumberTest","ImageURLText","StationNAme","AddressText","Active","0","0","0","0","1","0","0","0",false,true,false,false,false,false,false);
                Call<OurDataSet> call= ourRetrofit.ExitQueueData(ourDataSet);



                call.enqueue(new Callback<OurDataSet>() {
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                        //Toast.makeText(getApplicationContext(), "Station Data  Updated", Toast.LENGTH_SHORT).show();
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

        ConfirmPump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),ConfrimPump.class);
                startActivity(intent);

            }
        });

    }
}