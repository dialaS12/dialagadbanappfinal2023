package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    //spnr1 تعريف صفه للكائن المرئي
    private Spinner spnrSubject1;
    @Override
    protected void onCreate(Bundle savedInstanceState)

        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
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
    public void onClickAddPic(View v)
    {
        //to open new activity from current to next
        Intent i= new Intent(MainActivity.this,AddPic.class);
        startActivity(i);
        //to close current activity
    }


    }
