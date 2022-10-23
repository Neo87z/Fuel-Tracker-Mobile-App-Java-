package com.example.eadfinalproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetrofit {
    @POST("/api/Students")
    Call<OurDataSet> PostData(@Body OurDataSet ourDataSet);


    @POST("/api/PetrolShed")
    Call<OurDataSet> PostShedData(@Body Station ourDataSet);

    @POST("/api/PetrolShed/UpdateShedData/6354749d491ba33ff756d719")
    Call<OurDataSet> UpdateShedData(@Body Station ourDataSet);

    @POST("/api/PetrolShed/updateStationFuel/6354749d491ba33ff756d719")
    Call<OurDataSet> updateStationFuel(@Body Station ourDataSet);

    @POST("/api/PetrolShed/UpdateVehciles/6354749d491ba33ff756d719")
    Call<OurDataSet> UpdateVehciles(@Body Station ourDataSet);

    @POST("/api/PetrolShed/ExitQueue/6354749d491ba33ff756d719")
    Call<OurDataSet> ExitQueueData(@Body Station ourDataSet);

    @POST("/api/PetrolShed/UpdateFuel/6354749d491ba33ff756d719")
    Call<OurDataSet> UpdateFuel(@Body Station ourDataSet);




}
