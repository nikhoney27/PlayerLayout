package com.nickworld.playerlayout.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nikhil Sharma on 6/9/2017.
 */

public class HeaderModel implements Parcelable {
    private String imagePathName;
    private String imagetitle;

    public HeaderModel() {
    }

    public HeaderModel(String imagePathName, String imagetitle) {
        this.imagePathName = imagePathName;
        this.imagetitle = imagetitle;
    }

    protected HeaderModel(Parcel in) {
        imagePathName = in.readString();
        imagetitle = in.readString();
    }

    public static final Creator<HeaderModel> CREATOR = new Creator<HeaderModel>() {
        @Override
        public HeaderModel createFromParcel(Parcel in) {
            return new HeaderModel(in);
        }

        @Override
        public HeaderModel[] newArray(int size) {
            return new HeaderModel[size];
        }
    };

    public String getImagePathName() {
        return imagePathName;
    }

    public void setImagePathName(String imagePathName) {
        this.imagePathName = imagePathName;
    }

    public String getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(String imagetitle) {
        this.imagetitle = imagetitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagePathName);
        dest.writeString(imagetitle);
    }
}
