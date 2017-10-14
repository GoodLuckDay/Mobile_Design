package com.example.haon4658.practice3_2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haon4658 on 17. 10. 14.
 */

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int num, String message){
        this.number = num;
        this.message = message;
    }

    public SimpleData(Parcel src) {
        this.number = src.readInt();
        this.message = src.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);
    }

    public int getNumber(){return number;}
    public void setNumber(int number){this.number = number;}
    public String getMessage(){return message;}
    public void setMessage(String message){this.message = message;}
}
