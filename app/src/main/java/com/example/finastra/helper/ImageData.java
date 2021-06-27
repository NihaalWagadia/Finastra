package com.example.finastra.helper;

public class ImageData {
    private String imageUrl, roverName, roverLand, roverLaunch;

    public   ImageData(String imageUrl, String roverName, String roverLand, String roverLaunch){
        this.imageUrl = imageUrl;
        this.roverLand = roverLand;
        this.roverLaunch = roverLaunch;
        this.roverName = roverName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRoverName() {
        return roverName;
    }

    public void setRoverName(String roverName) {
        this.roverName = roverName;
    }

    public String getRoverLand() {
        return roverLand;
    }

    public void setRoverLand(String roverLand) {
        this.roverLand = roverLand;
    }

    public String getRoverLaunch() {
        return roverLaunch;
    }

    public void setRoverLaunch(String roverLaunch) {
        this.roverLaunch = roverLaunch;
    }
}
