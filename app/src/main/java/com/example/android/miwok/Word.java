package com.example.android.miwok;

public class Word {
    // class state
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId;

    // class constructors
    public Word(String miwokTranslation, String defaultTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String miwokTranslation, String defaultTranslation, int imageResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
    }

    // class methods
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
