package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SaveOutFitForTheWeek extends AppCompatActivity {
    //spnr3 تعريف صفه للكائن المرئي
    private Spinner spnrSubject44;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_out_fit_for_the_week);
        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spnrSubject44= findViewById(R.id.spnrSubject44);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar = {"Sunday", "Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday"};
        //spnr5تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr6ربط الكائن المرئي بالوسيط
        spnrSubject44.setAdapter(adapter);
    }
    @Override//داله لكي يبين التلت نقاط في الشاشه
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

}


