package com.example.android.miwok;

import android.content.Context;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private Context mContext;

    public Word(Context context) {
        mMiwokTranslation = "";
        mDefaultTranslation = "";
        mContext = context;
    }

    public Word(String miwokTranslation, String defaultTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
}
