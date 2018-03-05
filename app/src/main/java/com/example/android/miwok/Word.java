package com.example.android.miwok;

public class Word {
    // class state
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    // class constructor
    public Word(String miwokTranslation, String defaultTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    // class methods
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
}
