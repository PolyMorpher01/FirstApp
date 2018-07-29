package com.example.ayush.firstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableDemo implements Parcelable {

  String mSName;
  int mSAge;
  String mSAddress;
  String mSCourse;

  public ParcelableDemo(String mSName, String mSAge, String mSAddress, String mSCourse) {
    this.mSName = mSName;
    this.mSAge = Integer.parseInt(mSAge);
    this.mSAddress = mSAddress;
    this.mSCourse = mSCourse;
  }

  protected ParcelableDemo(Parcel in) {
    mSName = in.readString();
    mSAge = in.readInt();
    mSAddress = in.readString();
    mSCourse = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mSName);
    dest.writeInt(mSAge);
    dest.writeString(mSAddress);
    dest.writeString(mSCourse);
  }

  public static final Creator<ParcelableDemo> CREATOR = new Creator<ParcelableDemo>() {
    @Override
    public ParcelableDemo createFromParcel(Parcel in) {
      return new ParcelableDemo(in);
    }

    @Override
    public ParcelableDemo[] newArray(int size) {
      return new ParcelableDemo[size];
    }
  };
}
