package com.example.project_11_lr.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_11_lr.adapters.ColorsAdapter;
import com.example.project_11_lr.R;

public class Second extends MyBaseActivity implements AdapterView.OnItemClickListener {

    private ListView listV;
    Button btnback;
    //НАСТРОЙКИ
    private SharedPreferences preferences; //ссылка на объект-настройку

    View curView = null; //предыдущий элемент
    int curP; //целочисленный номер элемента в списке

    private ColorsAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        listV = (ListView)findViewById(R.id.listV);
        btnback = (Button) findViewById(R.id.btn_back);

        //НАСТРОЙКИ
        preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);

        //Работа с классом адаптера
        listV = (ListView) findViewById(R.id.listV);
        //восстанавливаем массив строк из ресурса, создаём объект класса нашего адаптера,
        // передаём ему в конструкторе этот массив строк и установливаем адаптер для списка ListView
        adapter = new ColorsAdapter<String>(getResources().getStringArray(R.array.arr_str_color), getResources().getIntArray(R.array.arr_int_color));
        listV = (ListView) findViewById(R.id.listV);
        listV.setAdapter(adapter); //setadapter связывание определенного адаптера с листвью
        listV.setOnItemClickListener(this); // связываем список с событием!
    }

    public void btn_back(View v){ //переход на вторую активность для выбора цвета фона
        Intent intent1 = new Intent(this, Main.class); //создаем объект класса Intent, в качестве
        //второго параметра передаем ему указание
        //класс активности, которую требуется открыть
        startActivity(intent1); //запускаем активность.  Методу startActivity передаем параметр – объект
        //класса Intent, в котором содержатся сведения о классе запускаемой активности
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        getWindow().getDecorView().setBackgroundColor(getResources().getIntArray(R.array.arr_int_color)[position]);
        curP = getResources().getIntArray(R.array.arr_int_color)[position];
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        String colorKey = getString(R.string.colorKey); //получаем из строкового ресурса ключ
//        int color = preferences.getInt(colorKey, R.color.prefColor);
//
//        getWindow().getDecorView().setBackgroundColor(color);
//    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.colorKey),curP);
        editor.apply();
    }
}
