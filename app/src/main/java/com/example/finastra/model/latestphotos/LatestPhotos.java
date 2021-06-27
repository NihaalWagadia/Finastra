package com.example.finastra.model.latestphotos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatestPhotos {

    @SerializedName("img_src")
    @Expose
    private String img_src;

    @SerializedName("rover")
    @Expose
    private Rover rover;

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    @Override
    public String toString() {
        return "LatestPhotos{" +
                "img_src='" + img_src + '\'' +
                ", rover=" + rover +
                '}';
    }
}
