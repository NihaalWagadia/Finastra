package com.example.finastra.model;

import com.example.finastra.model.latestphotos.LatestPhotos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/latest_photos?api_key=U68MmEqPVMxFLx915ugGSMSYBLQT6Dpc27ap446C
public class NasaResponse {

    @SerializedName("latest_photos")
    @Expose
    private ArrayList<LatestPhotos> latestPhotos;

    public ArrayList<LatestPhotos> getLatestPhotos() {
        return latestPhotos;
    }

    public void setLatestPhotos(ArrayList<LatestPhotos> latestPhotos) {
        this.latestPhotos = latestPhotos;
    }

    @Override
    public String toString() {
        return "NasaResponse{" +
                "latestPhotos=" + latestPhotos + '}';
    }
}
