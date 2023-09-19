package com.example.project_11_lr.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_11_lr.R;

public class MyBaseActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences),MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String colorKey = getString(R.string.colorKey); //получаем из строкового ресурса ключ
        int color = preferences.getInt(colorKey, R.color.prefColor);

        getWindow().getDecorView().setBackgroundColor(color);
    }
}
