package com.example.freon.b603205rec;

public class ItemLittle {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ItemLittle(int imageResource, String text1, String text2){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

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
}
