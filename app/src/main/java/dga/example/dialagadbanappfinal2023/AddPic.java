package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class AddPic extends AppCompatActivity {
    //spnr3 تعريف صفه للكائن المرئي
    private TextView textView6;
    private Spinner spinner;
    private TextView textView5;
    private Spinner spinner2;
    private ImageView imageView8;
    private Button btnpickcolor;
    private Button btnSave;
    private Button btnCancle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pic);
        textView5=(TextView) findViewById(R.id.textView5);
        textView6=(TextView) findViewById(R.id.textView6);
        btnpickcolor=(Button) findViewById(R.id.btnpickcolor);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnCancle=(Button) findViewById(R.id.btnCancle);
        imageView8=(ImageView) findViewById(R.id.imageView8);



        //spnr3 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spinner= findViewById(R.id.spinner);
//        spnr4 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spinner2= findViewById(R.id.spinner2);
//        spnr3,4 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr3 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar = {"The Upper Part", "The Lower Part", "The Shoe", "Accessories"};
        //spnr3تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr3ربط الكائن المرئي بالوسيط
        spinner.setAdapter(adapter);

        //spnr4 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] arr = {"Summer", "Spring", "Winter", "Autumn"};
        //spnr4تحديد المعطيات للوسيط
       adapter.addAll(ar);
        //spnr4ربط الكائن المرئي بالوسيط
        spinner2.setAdapter(adapter);
        }
    }