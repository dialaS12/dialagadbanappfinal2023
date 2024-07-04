package dga.example.dialagadbanappfinal2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;

public class MyProfile extends AppCompatActivity {
    public Spinner etSummer1;
    public Spinner etSummer2;
    public Spinner etSpring1;
    public Spinner etSpring2;
    public Spinner etWinter1;
    public Spinner etWinter2;
    public Spinner etAutumn1;
    public Spinner etAutumn2;
    public TextView tvSummer;
    public TextView tvSpring;
    public TextView tvWinter;
    public TextView tvAutumn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        tvSummer=findViewById(R.id.tvSummer);
        tvSpring=findViewById(R.id.tvSpring);
        tvWinter=findViewById(R.id.tvWinter);
        tvAutumn=findViewById(R.id.tvAutumn);
        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etSummer1=findViewById(R.id.etSummer1);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar1 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter1.addAll(ar1);
        //spnr6ربط الكائن المرئي بالوسيط
        etSummer1.setAdapter(adapter1);


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etSummer2=findViewById(R.id.etSummer2);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar2 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter2.addAll(ar2);
        //spnr6ربط الكائن المرئي بالوسيط
        etSummer2.setAdapter(adapter2);


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etSpring1=findViewById(R.id.etSpring1);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar3 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter3.addAll(ar3);
        //spnr6ربط الكائن المرئي بالوسيط
        etSpring1.setAdapter(adapter3);


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etSpring2=findViewById(R.id.etSpring2);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar4 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter4.addAll(ar4);
        //spnr6ربط الكائن المرئي بالوسيط
        etSpring2.setAdapter(adapter4);


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etWinter1=findViewById(R.id.etWinter1);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar5 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter5.addAll(ar5);
        //spnr6ربط الكائن المرئي بالوسيط
        etWinter1.setAdapter(adapter5);


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etWinter2=findViewById(R.id.etWinter2);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar6 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter6.addAll(ar6);
        //spnr6ربط الكائن المرئي بالوسيط
        etWinter2.setAdapter(adapter6);



        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etAutumn1=findViewById(R.id.etAutumn1);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter7 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar7 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter7.addAll(ar7);
        //spnr6ربط الكائن المرئي بالوسيط
        etAutumn1.setAdapter(adapter7);


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        etAutumn2=findViewById(R.id.etAutumn2);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter8 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar8 = {"January", "February", "March", "April","May","June ","July","August","September","October","November","December"};
        //spnr5تحديد المعطيات للوسيط
        adapter8.addAll(ar8);
        //spnr6ربط الكائن المرئي بالوسيط
        etAutumn2.setAdapter(adapter8);



    }




        @Override//داله لكي يبين التلت نقاط في الشاشه
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MyProfile.this, MyProfile.class);
            startActivity(i);


        }
        if (item.getItemId() == R.id.itmLogOut) {
            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
            showYesNoDialog();

        }
        //Exstra(m.sameh)
        if (item.getItemId() == R.id.itemFavorites) {
            Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MyProfile.this, FavoritesPage.class);
            startActivity(i);

        }
        if (item.getItemId() == R.id.mnPlayMusic) {
            Toast.makeText(this, "Play Music", Toast.LENGTH_SHORT).show();
            Intent serviceIntn = new Intent(getApplicationContext(), MyAdudioPlayerService.class);
            startService(serviceIntn);
        }
        if (item.getItemId() == R.id.mnStopMusic) {
            Toast.makeText(this, "Stop Music", Toast.LENGTH_SHORT).show();
            Intent serviceIntn = new Intent(getApplicationContext(), MyAdudioPlayerService.class);
            startService(serviceIntn);
        }
        return true;
    }



    public void showYesNoDialog()
    {
        //جهيز بناء شباك حوار "دايلوغ"يتلقى برامتر مؤشر للنشاط(اكتيففتي)الحالي
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Log Out");//تحديد العوان
        builder.setMessage("Are You Sure?");//تحديد فحوى شباك الحوار
        //الضغط على الزر ومعالج الحدث
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقه
                FirebaseAuth.getInstance().signOut();//לביצוע רישום יציאה
                Toast.makeText(MyProfile.this, "Signing Out", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        //الضغط على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقه
                Toast.makeText(MyProfile.this, "Signing Out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();//بناء شباك الحوار -دايالوج
        dialog.show();//عرض الشباك

    }


}
