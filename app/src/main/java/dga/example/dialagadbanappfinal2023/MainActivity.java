package dga.example.dialagadbanappfinal2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import dga.example.dialagadbanappfinal2023.data.MySeasonTable.MySeason;
import dga.example.dialagadbanappfinal2023.data.MySeasonTable.MySeasonQuery1;
import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothesQuery1;
import dga.example.dialagadbanappfinal2023.data.clothesTable.myClothes;

public class MainActivity extends AppCompatActivity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnrSubject1 = (Spinner) findViewById(R.id.spnrSubject1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        fabAdd1 = (FloatingActionButton) findViewById(R.id.fabAdd1);
        fabAdd2 = (FloatingActionButton) findViewById(R.id.fabAdd2);
        fabAdd3 = (FloatingActionButton) findViewById(R.id.fabAdd3);
        fabAdd4 = (FloatingActionButton) findViewById(R.id.fabAdd4);
        fabAdd5 = (FloatingActionButton) findViewById(R.id.fabAdd5);
        fabAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddPic.class);
                startActivity(i);

            }
        });


        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spnrSubject1 = findViewById(R.id.spnrSubject1);
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
    // {
    //to open new activity from current to next
    //Intent i= new Intent(MainActivity.this,AddPic.class);
    // startActivity(i);
    //to close current activity

    // }

    private void initSubjectSpnr() {
        AppDatabace db = AppDatabace.getDB(getApplicationContext());// قاعدة بناء
        MySeasonQuery1 seasonQuery1 = db.getMySeasonQuery1();//  عمليات جدول المواضيع
        List<MySeason> allSeason = seasonQuery1.getAll();// استخراج جميع المواضيع
        // تجهيز الوسيط
        ArrayAdapter<String> SeasonAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);
        SeasonAdapter.add("ALL");//ستظهر اولا بالسبنر تعني عرض جميع المهمات
        for (MySeason season : allSeason)//  اضافة المواضبع للوسيط
        {
            SeasonAdapter.addAll(season.SeasonName);
        }
        spnrSubject1.setAdapter(SeasonAdapter);//ربط السبنر بالوسيط
        spnrSubject1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // استخراج الموضوع حسب رقمه الترتيبي i
                String item = SeasonAdapter.getItem(i);
                if (item.equals("ALL"))//هذا يعني اعترض جميع المهام
                {
                    initAllListView();//استدعاء الداله التي  تجهيز قائمة جميع المهمهات وعرضها ب list view
                } else {
                    //استخراج كائن الموضوع الذي اخترناه لاسنخراج رقمه id
                    MySeason season = seasonQuery1.checkSeason(item);
                    //استدعاء العملية التي تجهز القائمة حسب رقم الموضوع
                    initListViewBySubjId(season.key_id);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override//داله لكي يبين التلت نقاط في الشاشه
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * تجهيز قائمة جميع المهمهات وعرضها ب list view
     */
    private void initAllListView() {

        AppDatabace db1 = AppDatabace.getDB(getApplicationContext());// قاعدة بناء

        MyClothesQuery1 clothesQuery1 = db1.getMyClothesQuery1();
        List<myClothes> allClothes = clothesQuery1.getAllmyClothes();
        ArrayAdapter<myClothes> ClothesAdapter = new ArrayAdapter<myClothes>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);

        ClothesAdapter.addAll(allClothes);
        spnrSubject1.setAdapter(ClothesAdapter);
//        .setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                showPopUpMenu(view, ClothesAdapter.getItem(i));
//            }
//        });
    }
        /**
         * تجهيز قا~مة الصور حسب رقم القطعه
         * رقم الموضوع param key_id
         */
        private void initListViewBySubjId ( long key_id){
            AppDatabace db = AppDatabace.getDB(getApplicationContext());
            MyClothesQuery1 clothesQuery1 = db.getMyClothesQuery1();
            //يجب اضافة عملية تعيد جميع المهمات حسب رقم الموضوغ
            List<myClothes> allClothes = clothesQuery1.getClothesByCloId(key_id);
            ArrayAdapter<myClothes> ClothesAdapter = new ArrayAdapter<myClothes>(this, android.R.layout.simple_spinner_dropdown_item);
            ClothesAdapter.addAll(allClothes);
            spnrSubject1.setAdapter(ClothesAdapter);

        }

        /**
         * داله مساعدة لفنح قائمة تتلقى بارمتر للكائن الذي سبب فتح القائمة
         *
         * @param v
         */
        public void showMenu (View v) {
                // بناء قائمة popup menu
                PopupMenu popup = new PopupMenu(this, v);//الكائن الذي سبب فتح القائمة v
        popup.inflate(R.menu.pupupmenu);//ملف القائمة
        popup.show();//فتح وعرض القائمة

            }


        public void onClick (View v){
            showMenu(v);
        }

        /**
         * داله مساعدة لفتح قائمة تتلقى بارمتر للكائن الذي سبب فتح القائمة
         *
         * @param v
         * @param item
         */
        public void showPopUpMenu(View v, myClothes item) {
            //بناء القائمة popup menu
            PopupMenu popup = new PopupMenu(this, v);
            //ملف القائمة
            popup.inflate(R.menu.pupupmenu);
            //اضافة معالج حدث لاختيار عنصر من القائمة
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.mnComplete) {
                        //هنا نكتب ردة فعل لاختيار هذا العنصر من القائمة
                        Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, AddPic.class);
                        startActivity(i);
                    }
                    if (menuItem.getItemId() == R.id.mnDelete) {
                        Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                    }
                    if (menuItem.getItemId() == R.id.mnEdit) {
                        Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();

                    }
                    return true;
                }


            });
        }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MainActivity.this, MyProfile.class);
            startActivity(i);


        }
        if (item.getItemId() == R.id.itmSignOut) {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
            showYesNoDialog();

        }
        if (item.getItemId() == R.id.itmAddPic) {
            Toast.makeText(this, "AddPic", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MainActivity.this, AddPic.class);
            startActivity(i);
        }
        //Exstra(m.sameh)
        if (item.getItemId() == R.id.itemFavorites) {
            Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MainActivity.this, FavoritesPage.class);
            startActivity(i);
        }

        return true;
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("HA","onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HA","onStart");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HA","onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        initSubjectSpnr();
        initAllListView();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HA","onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HA","onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HA","onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this, "Signing Out", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        //الضغط على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقه
                Toast.makeText(MainActivity.this, "Signing Out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();//بناء شباك الحوار -دايالوج
        dialog.show();//عرض الشباك
    }
    public void onClickSaveOutFitForTheWeek(View v) {
        //to open new activity from current to next
        Intent i = new Intent(MainActivity.this, SaveOutFitForTheWeek.class);
        startActivity(i);
        //to close current activity
    }








}



