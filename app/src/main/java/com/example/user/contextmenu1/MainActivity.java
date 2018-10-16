package com.example.user.contextmenu1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1,rb2;
    Button btn1;
    EditText et1,et2;
    Intent t1;
    double num1,d;
    String st1, st2;
    int typeProj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.firstNum);
        et2 = (EditText) findViewById(R.id.MultOrDif);
        rb1 = (RadioButton) findViewById(R.id.aritProg);
        rb2 = (RadioButton) findViewById(R.id.geoProg);
    }

    public void go(View view) {
        typeProj1 = 0;
        t1 = new Intent(this, Main2Activity.class);
        st1 = et1.getText().toString();
        st2 = et2.getText().toString();

        if (rb1.isChecked())
            typeProj1 = 1;
        else if (rb2.isChecked())
            typeProj1 = 2;

        if ((st1.isEmpty()) || (st1.equals(".")) || (st1.equals("-")) || (st1.equals("-.") || st2.equals(".")) || (st2.equals("-.")) || (st2.isEmpty()) || (st2.equals("-")) || ((typeProj1!=1)&&(typeProj1!=2)) )
            Toast.makeText(this, "you must enter a appropriate input", Toast.LENGTH_SHORT).show();
        else {
            num1 = Double.parseDouble(st1);
            d = Double.parseDouble(st2);
            t1.putExtra("typeProj", typeProj1);
            t1.putExtra("firstNum", num1);
            t1.putExtra("d", d);
            startActivity(t1);
        }
    }

    public void credits(View view) {
        Intent t2 = new Intent(this, Main3Activity.class);
        startActivity(t2);
    }
}