package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddPic extends AppCompatActivity {
    //spnr3 تعريف صفه للكائن المرئي
    private Spinner spnrSubject3;
    private Spinner spnrSubject4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pic);
        //spnr3 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spnrSubject3= findViewById(R.id.spnrSubject3);
        //spnr4 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spnrSubject4= findViewById(R.id.spnrSubject4);
        //spnr3,4 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr3 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar = {"The Upper Part", "The Lower Part", "The Shoe", "Accessories"};
        //spnr3تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr3ربط الكائن المرئي بالوسيط
        spnrSubject3.setAdapter(adapter);

        //spnr4 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] arr = {"Summer", "Spring", "Winter", "Autumn"};
        //spnr4تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr4ربط الكائن المرئي بالوسيط
        spnrSubject4.setAdapter(adapter);
    }
}