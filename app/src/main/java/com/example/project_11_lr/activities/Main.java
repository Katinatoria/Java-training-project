package com.example.project_11_lr.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_11_lr.R;

public class Main extends MyBaseActivity {
    
    SharedPreferences preferences_main;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        preferences_main = getSharedPreferences(getString(R.string.preferences),MODE_PRIVATE);
    }

    public void btn_color(View v){ //переход на вторую активность для выбора цвета фона
        Intent intent1 = new Intent(this, Second.class); //создаем объект класса Intent, в качестве
        //второго параметра передаем ему указание
        //класс активности, которую требуется открыть
        startActivity(intent1); //запускаем активность.  Методу startActivity передаем параметр – объект
        //класса Intent, в котором содержатся сведения о классе запускаемой
        //активности
    }

    public void btn_third(View view){
        Intent intent1 = new Intent(this, Third.class); //создаем объект класса Intent, в качестве
        //второго параметра передаем ему указание
        //класс активности, которую требуется открыть
        startActivity(intent1); //запускаем активность.  Методу startActivity передаем параметр – объект
        //класса Intent, в котором содержатся сведения о классе запускаемой
        //активности
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        String colorKey = getString(R.string.colorKey);
//        int color = preferences_main.getInt(colorKey,R.color.prefColor);
//
//        getWindow().getDecorView().setBackgroundColor(color);
//    }
}
