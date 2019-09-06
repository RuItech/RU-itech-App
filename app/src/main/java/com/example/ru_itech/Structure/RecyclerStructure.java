package com.example.ru_itech.Structure;

public class RecyclerStructure {

    private int Image;
    private String Decription;
    private String  date;
    private String location;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String decription) {
        Decription = decription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public RecyclerStructure() {
    }

    public RecyclerStructure(int image, String decription, String date, String location) {
        Image = image;
        Decription = decription;
        this.date = date;
        this.location = location;
    }


}
