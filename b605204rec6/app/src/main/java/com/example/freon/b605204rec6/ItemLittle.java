package com.example.freon.b605204rec6;


import android.os.Parcel;
import android.os.Parcelable;

public class ItemLittle implements Parcelable {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ItemLittle(int imageResource, String text1, String text2){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    protected ItemLittle(Parcel in) {
        mImageResource = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
    }

    public static final Creator<ItemLittle> CREATOR = new Creator<ItemLittle>() {
        @Override
        public ItemLittle createFromParcel(Parcel in) {
            return new ItemLittle(in);
        }

        @Override
        public ItemLittle[] newArray(int size) {
            return new ItemLittle[size];
        }
    };

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mImageResource);
        parcel.writeString(mText1);
        parcel.writeString(mText2);
    }
}
