package com.example.user.contextmenu1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {
    Intent t1;
    double num1 , d , sum1;
    int typeProj1;
    int i = 0;
    ListView l1;
    Double[] array1;
    TextView tv1;
    public int position1;
    Intent t11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textView);
        l1 = (ListView) findViewById(R.id.ListView1);
        l1.setOnItemClickListener(this);
        l1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        array1 = new Double[21];
        ArrayAdapter<Double> adp;
        adp = new ArrayAdapter<Double>(this,R.layout.support_simple_spinner_dropdown_item , array1);
        l1.setAdapter(adp);

        l1.setOnCreateContextMenuListener(this);


        t1 = getIntent();
        num1 = t1.getDoubleExtra("firstNum", 1);
        typeProj1 = t1.getIntExtra("typeProj", 1);
        d = t1.getDoubleExtra("d", 1);
        array1[0] = num1;
        if (typeProj1 == 1) {
            num1 = t1.getDoubleExtra("firstNum", 1);
            for (i = 1; i <=20; i++) {
                array1[i] = num1 + d;
                num1 = num1 + d;
            }
        }
        if (typeProj1 == 2) {
            num1 = t1.getDoubleExtra("firstNum", 1);
            for (i = 1; i <= 20; i++) {
                array1[i] = num1 * d;
                num1 = num1 * d;
            }
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        num1 = t1.getDoubleExtra("firstNum", 1);
        sum1 = 0;
        for (i=0; i<=position; i++) {
            sum1 = array1[i] + sum1;
        }
        position1 = position++;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Element Stats");
        menu.add("x1");
        menu.add("d");
        menu.add("n");
        menu.add("Sn");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String str=item.getTitle().toString();
        if (str.equals("x1"))
            tv1.setText("X1=  "+num1);
        if (str.equals("d"))
            tv1.setText("d=  " + d);
        if (str.equals("n"))
            tv1.setText("n=  " + position1);
        if (str.equals("Sn"))
            tv1.setText("Sn=  " + sum1);

        return super.onContextItemSelected(item);
    }


    public void return1(View view) {
        t11 = new Intent(this, MainActivity.class);
        startActivity(t11);
    }
}