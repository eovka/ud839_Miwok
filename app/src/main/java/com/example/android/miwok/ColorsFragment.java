package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mMediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    mMediaPlayer.stop();
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), words, R.color.category_colors);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int soundId = words.get(position).getSoundResourceId();
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), soundId);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
