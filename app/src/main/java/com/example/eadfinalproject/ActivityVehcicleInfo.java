package com.example.eadfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityVehcicleInfo extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    EditText VehPlate, VehModel, VehColor;

    Button CreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehcicle_info);

        Bundle extras = getIntent().getExtras();
        autoCompleteTextView=findViewById(R.id.VehcileOptionInput);
        String[]options={"Two Wheel","Three Wheel","Four Wheel","Other"};
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.vehcile_options,options);
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false);
        autoCompleteTextView.setAdapter(arrayAdapter);

        VehPlate=findViewById(R.id.NameInputEditText);
        VehModel=findViewById(R.id.LastNameInputEditText);
        VehColor=findViewById(R.id.EmailLastNameInputEditText);
        CreateAccount=findViewById(R.id.button);
        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fname=extras.getString("EXTRA_SESSION_USER");
                String sender=extras.getString("EXTRA_SESSION_FNAME");;
                String message=extras.getString("EXTRA_SESSION_LNAME");;
                String plateNumber=VehPlate.getText().toString();
                String modelNumber=VehModel.getText().toString();
                String color=VehColor.getText().toString();
                String type=autoCompleteTextView.getText().toString();

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.2.24:7150")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);
                OurDataSet ourDataSet= new OurDataSet(fname,sender,message,plateNumber,modelNumber,color,type);
                Call<OurDataSet> call= ourRetrofit.PostData(ourDataSet);
                call.enqueue(new Callback<OurDataSet>() {
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                        Toast.makeText(ActivityVehcicleInfo.this, "Account Sucessfully Created", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(getApplicationContext(),ListAllPetrolSheds.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<OurDataSet> call, Throwable t) {
                        Toast.makeText(ActivityVehcicleInfo.this, "Please Try Again In A Few Minutes", Toast.LENGTH_SHORT).show();

                    }
                });





            }
        });

    }


    void SendDataTOBackend(){


    }
}