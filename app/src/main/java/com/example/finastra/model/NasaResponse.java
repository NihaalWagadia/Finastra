package com.example.finastra.model;

import com.example.finastra.model.latestphotos.LatestPhotos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

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
