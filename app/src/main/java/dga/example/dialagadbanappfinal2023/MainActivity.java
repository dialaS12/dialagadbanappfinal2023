package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity
{
    //spnr1 تعريف صفه للكائن المرئي
    private Spinner spnrSubject1;
    private FloatingActionButton fabAdd1;
    private FloatingActionButton fabAdd2;
    private FloatingActionButton fabAdd3;
    private FloatingActionButton fabAdd4;
    private FloatingActionButton fabAdd5;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)

        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            spnrSubject1 = (Spinner) findViewById(R.id.spnrSubject1);
            imageView1=(ImageView) findViewById(R.id.imageView1);
            imageView2=(ImageView) findViewById(R.id.imageView2);
            imageView3=(ImageView) findViewById(R.id.imageView3);
            imageView4=(ImageView) findViewById(R.id.imageView4);
            fabAdd1 = (FloatingActionButton) findViewById(R.id.fabAdd1);
            fabAdd2 = (FloatingActionButton) findViewById(R.id.fabAdd2);
            fabAdd3 = (FloatingActionButton) findViewById(R.id.fabAdd3);
            fabAdd4 = (FloatingActionButton) findViewById(R.id.fabAdd4);
            fabAdd5 = (FloatingActionButton) findViewById(R.id.fabAdd5);
           fabAdd1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
               Intent i=new Intent(MainActivity.this,AddPic.class);
               startActivity(i);

               }
           });


            //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
            spnrSubject1= findViewById(R.id.spnrSubject1);
            //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
            String[] ar = {"Random", "Specific color", "Sporty", "Formal or Business Attire", "Casual Style, other..."};
            //spnr5تحديد المعطيات للوسيط
            adapter.addAll(ar);
            //spnr6ربط الكائن المرئي بالوسيط
            spnrSubject1.setAdapter(adapter);

        }
    //public void onClickAddPic(View v)
    {
        //to open new activity from current to next
        //Intent i= new Intent(MainActivity.this,AddPic.class);
       // startActivity(i);
        //to close current activity

    }


    }
