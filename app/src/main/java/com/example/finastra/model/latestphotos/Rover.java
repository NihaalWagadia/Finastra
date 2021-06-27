package com.example.finastra.model.latestphotos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rover {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("landing_date")
    @Expose
    private String landing_date;

    @SerializedName("launch_date")
    @Expose
    private String launch_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public void setLanding_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "name='" + name + '\'' +
                ", landing_date='" + landing_date + '\'' +
                ", launch_date='" + launch_date + '\'' +
                '}';
    }
}

