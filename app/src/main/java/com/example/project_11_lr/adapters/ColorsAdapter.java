package com.example.project_11_lr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.project_11_lr.R;

public class ColorsAdapter<S> extends BaseAdapter {
    private String[] arr;
    private int[] arr_2;

    public ColorsAdapter(String[] my_arr, int[] my_int_arr){ //конструктор класса
        arr = my_arr;
        arr_2 = my_int_arr;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr_2[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext(); /* Context – это класс, который содержит многие полезные методы.  Любая активность является наследником от этого класса, поэтому к его методам можно обращаться из класса-активности, но адаптер не является наследником от Context, следовательно, если нам потребуются методы Context-а в адаптере, следует получить там каким-либо образом объект класса Context, например, с помощью метода getContext списка. */

        if(view == null) {  //объекта – элемента разметки для нашего пункта списка не существует, поэтому
            //мы его создаем
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  //с помощью метода
            // getSystemService объекта context класса Context создаем объект inflater класса LayoutInflater
            view = inflater.inflate(R.layout.le, parent, false); //с помощью метода inflate объекта inflater
            //создаем из разметки для элемента списка, находящегося в файле list_item.xml папки layout,
            // дерево объектов и возвращаем ссылку на корневой элемент этого дерева.  В данном случае
            //дерево у нас состоит из одного узла - элемента TextView.
        }
        TextView textView = (TextView) view; //преобразуем класс объекта – элемента разметки к TextView
        textView.setText(arr[position]); //в элемент, находящийся в списке на позиции position, помещаем
        textView.setBackgroundColor(arr_2[position]);//текст из элемента массива строк с индексом position
        //устанавливаем цвет в зависимости от position
        //если мы хотим использовать цвет из ресурса цветов, то обращение к ресурсу может
        //выглядеть так:
        //textView.setBackgroundColor(ContextCompat.getColor(context, R.color.имя_ресурса));
        //обратите внимание, что первый параметр метода getColor – это объект класса Context;
        //когда мы использовали этот метод из активности, мы могли в качестве такого параметра
        //указать this, так как активность – наследник от Context, следовательно, ее саму можно
        //передать туда, где требуется Context
        return view; //возвращаем сформированный объект-элемент разметки

    }
}
