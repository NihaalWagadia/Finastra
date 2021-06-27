package com.example.finastra.apicall;

import com.example.finastra.model.NasaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NasaApiCall {

    @Headers("Content-Type: application/json")
    @GET("latest_photos?api_key=U68MmEqPVMxFLx915ugGSMSYBLQT6Dpc27ap446C")
    Call<NasaResponse> getScheduleJson(@Query("page") int pageIndex, @Query("count") int count);
}