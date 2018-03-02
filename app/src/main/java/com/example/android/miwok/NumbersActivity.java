/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        Log.v("NumbersActivity", "Word at index zero: " + words.get(0));
        Log.v("NumbersActivity", "Word at index one: " + words.get(1));
        Log.v("NumbersActivity", "Word at index two: " + words.get(2));
        Log.v("NumbersActivity", "Word at index three: " + words.get(3));
        Log.v("NumbersActivity", "Word at index four: " + words.get(4));
        Log.v("NumbersActivity", "Word at index five: " + words.get(5));
        Log.v("NumbersActivity", "Word at index six: " + words.get(6));
        Log.v("NumbersActivity", "Word at index seven: " + words.get(7));
        Log.v("NumbersActivity", "Word at index eight: " + words.get(8));
        Log.v("NumbersActivity", "Word at index nine: " + words.get(9));
    }
}
