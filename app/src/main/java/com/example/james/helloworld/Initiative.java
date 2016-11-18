package com.example.james.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by james on 11/18/16.
 */

public class Initiative implements Parcelable {

    public Initiative() {
        name = "";
        roll = 0;
    }

    public Initiative(Parcel source) {
        name = source.readString();
        roll = source.readInt();
    }

    private String name;
    private int roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(roll);
    }

    public static final Parcelable.Creator<Initiative> CREATOR = new Parcelable.Creator<Initiative>() {

        @Override
        public Initiative createFromParcel(Parcel source) {
            return new Initiative(source);
        }

        public Initiative[] newArray(int size) {
            return new Initiative[size];
        }

    };
}
