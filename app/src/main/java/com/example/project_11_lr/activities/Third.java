package com.example.project_11_lr.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_11_lr.R;
import com.example.project_11_lr.activities.Main;

public class Third extends MyBaseActivity {

    SharedPreferences preferences_third;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_act);

        preferences_third = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        String colorKey = getString(R.string.colorKey); //получаем из строкового ресурса ключ
//        int color = preferences_third.getInt(colorKey, R.color.prefColor);
//
//        getWindow().getDecorView().setBackgroundColor(color);
//    }

    public void btn_back(View v){ //переход на вторую активность для выбора цвета фона
        Intent intent1 = new Intent(this, Main.class); //создаем объект класса Intent, в качестве
        //второго параметра передаем ему указание
        //класс активности, которую требуется открыть
        startActivity(intent1); //запускаем активность.  Методу startActivity передаем параметр – объект
        //класса Intent, в котором содержатся сведения о классе запускаемой активности
    }

}
