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
import java.util.Currency;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAllPetrolSheds extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, email, age;

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

                name.add("Malabe Petrol Station");
                email.add("24l");
                age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");
        name.add("Malabe Petrol Station");
        email.add("24l");
        age.add("2022/01/22");


    }
}