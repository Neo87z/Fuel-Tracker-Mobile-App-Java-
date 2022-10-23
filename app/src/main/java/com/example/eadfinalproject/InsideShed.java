package com.example.eadfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InsideShed extends AppCompatActivity {
    Button ExitQue,ConfirmPump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_shed);
        ExitQue=findViewById(R.id.button6);
        ConfirmPump=findViewById(R.id.button5);
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