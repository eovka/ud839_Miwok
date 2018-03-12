package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Urszula Drabińska on 12.03.2018.
 **/

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView miwokTranslationView = listItemView.findViewById(R.id.miwok_word);
        miwokTranslationView.setText(currentWord.getMiwokTranslation());
        TextView defaultTranslationView = listItemView.findViewById(R.id.english_word);
        defaultTranslationView.setText(currentWord.getDefaultTranslation());
        return listItemView;
    }
}
