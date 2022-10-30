/*
 * //**
 *  Created By Dulanji Vithnage (IT19142142), Imalshi Dias (IT19183978), Pawani Weerasinghe (IT19133546).
 * Copyright(c) 2022 . All Rights reserved.
 *  This project was done for the EAD Assignment  1
 * /
 */

package com.example.eadfinalproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


//Interface for Connecting to The Backend
public interface OurRetrofit {
    @POST("/api/Students")
    Call<OurDataSet> PostData(@Body OurDataSet ourDataSet);


    @POST("/api/PetrolShed")
    Call<OurDataSet> PostShedData(@Body Station ourDataSet);

    @POST("/api/PetrolShed/UpdateShedData/635dd00aef4ac6ca020b1585")
    Call<OurDataSet> UpdateShedData(@Body Station ourDataSet);

    @POST("/api/PetrolShed/updateStationFuel/635dd00aef4ac6ca020b1585")
    Call<OurDataSet> updateStationFuel(@Body Station ourDataSet);

    @POST("/api/PetrolShed/UpdateVehciles/635dd00aef4ac6ca020b1585")
    Call<OurDataSet> UpdateVehciles(@Body Station ourDataSet);

    @POST("/api/PetrolShed/ExitQueue/635dd00aef4ac6ca020b1585")
    Call<OurDataSet> ExitQueueData(@Body Station ourDataSet);

    @POST("/api/PetrolShed/UpdateFuel/635dd00aef4ac6ca020b1585")
    Call<OurDataSet> UpdateFuel(@Body Station ourDataSet);

    @POST("/api/PetrolShed/635dd00aef4ac6ca020b1585")
    Call<Station> GetFuelStationDataByID(@Body Station ourDataSet);

    @POST("/api/GetAll")
    Call<Station> GetAll(@Body Station ourDataSet);








}
