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

        //Onclick to Add Fuel Station Screen
        AddStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),AddFuelStation.class);
                startActivity(i1);

            }
        });

        //Onclick to Manage Fuel Station Screen
        ManageStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),ManageFuelStation.class);
                startActivity(i1);

            }
        });
        //Onclick to Add Fuel  Screen
        AddFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),ManageFuel.class);
                startActivity(i1);

            }
        });
        //Onclick to Edit Fuel  Screen
        EditFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),CheckOwnerStats.class);
                startActivity(i1);

            }
        });




    }
}