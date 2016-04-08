package com.nyu.mouzhang.ratemyfashiondemo.Model;

/**
 * Created by kai on 4/8/16.
 */
public class Recommendation {
    private String description1;
    private String description2;
    private int photoID;

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public Recommendation(String d1, String d2, int photoID){
        description1 = d1;
        description2 = d2;
        this.photoID = photoID;
    }
}
