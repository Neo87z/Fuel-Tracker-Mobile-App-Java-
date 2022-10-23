package com.example.eadfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OwnerDashBoard extends AppCompatActivity {

    ImageView AddStation,ManageStation, AddFuel,EditFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dash_board);
        AddStation=findViewById(R.id.AddStation);
        ManageStation=findViewById(R.id.ManageStation);
        AddFuel=findViewById(R.id.AddFuel);
        EditFuel=findViewById(R.id.EditFuel);

        AddStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),AddFuelStation.class);
                startActivity(i1);

            }
        });
        ManageStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),ManageFuelStation.class);
                startActivity(i1);

            }
        });
        AddFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),ManageFuel.class);
                startActivity(i1);

            }
        });
        EditFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),CheckOwnerStats.class);
                startActivity(i1);

            }
        });




    }
}