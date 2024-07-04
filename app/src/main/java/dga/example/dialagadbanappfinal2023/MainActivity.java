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
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import dga.example.dialagadbanappfinal2023.data.MySeasonTable.MySeason;
import dga.example.dialagadbanappfinal2023.data.MySeasonTable.MySeasonQuery1;
import dga.example.dialagadbanappfinal2023.data.clothesTable.HorizontalListView;
import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothes;
import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothesAdapter;
import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothesQuery1;

/**
 * داله الصفحة الرئيسية التي تحوي طقم الملابس
 */

public class MainActivity extends AppCompatActivity {
    //spnr1 تعريف صفه للكائن المرئي
    private Spinner spnrSubject1;
    private FloatingActionButton fabAdd1;
    private HorizontalListView lstvUpperr;
    private HorizontalListView lstvLowerPart;
    private HorizontalListView lstvTheShoes;
    private HorizontalListView lstvrmyAccessories;
    MyClothesAdapter adapterUpper,adapterLower,adapterTheShoes,adapterAccessories;


    // private FloatingActionButton fabAdd4;
   // private FloatingActionButton fabAdd5;
  //  private ImageView imageView1;
   // private ImageView imageView2;
  //  private ImageView imageView3;
    //private ImageView imageView4;


    /**
     *هذا الكود يقوم بتهيئة عناصر الواجهة المختلفة للنشاط (عناصر Spinner وFloatingActionButton وبعض ImageView غير المفعلة)، ويقوم بتهيئة المحولات التي ستستخدم لتوفير البيانات لعناصر Spinner.
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstvUpperr=findViewById(R.id.lstvUpper) ;
        lstvLowerPart=findViewById(R.id.lstvLowerPart);
        lstvTheShoes=findViewById(R.id.lstvTheShoes);
        lstvrmyAccessories=findViewById(R.id.lstvrmyAccessories);
//        imageView1 = (ImageView) findViewById(R.id.imageView1);
       // imageView2 = (ImageView) findViewById(R.id.imageVitm);
//        imageView3 = (ImageView) findViewById(R.id.imageView3);
        //imageView4 = (ImageView) findViewById(R.id.imageView4);
        fabAdd1 = (FloatingActionButton) findViewById(R.id.fabAdd1);
//        fabAdd2 = (FloatingActionButton) findViewById(R.id.fabAdd2);
//        fabAdd3 = (FloatingActionButton) findViewById(R.id.fabAdd3);
//        fabAdd4 = (FloatingActionButton) findViewById(R.id.fabAdd4);
       // fabAdd5 = (FloatingActionButton) findViewById(R.id.fav1);
        adapterUpper = new MyClothesAdapter(getApplicationContext(),R.layout.clothes_item_layout);
         adapterLower = new MyClothesAdapter(getApplicationContext(), R.layout.clothes_item_layout);
        adapterTheShoes = new MyClothesAdapter(getApplicationContext(), R.layout.clothes_item_layout);
        adapterAccessories = new MyClothesAdapter(getApplicationContext(), R.layout.clothes_item_layout);
        lstvUpperr.setAdapter(adapterUpper);
       lstvLowerPart.setAdapter(adapterLower);
        lstvrmyAccessories.setAdapter(adapterAccessories);
       lstvTheShoes.setAdapter(adapterTheShoes);





/**
 * الهدف هو فتح نشاط (Activity) جديد يسمى AddPic عند النقر على زر fabAdd1.
 */
        fabAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddPic.class);
                startActivity(i);

            }
        });

/**
 * الهدف من هذه الأسطر هو ربط محولات البيانات (Adapters) مع عناصر القوائم المنسدلة (Spinners) في واجهة المستخدم. وهذا يسمح بعرض البيانات في هذه القوائم المنسدلة. بمعنى آخر، يقوم الكود بتعيين المحولات لعناصر Spinner بحيث يتم ملء القوائم المنسدلة بالبيانات التي توفرها هذه المحولات.
 */
        lstvUpperr.setAdapter(adapterUpper);
        lstvLowerPart.setAdapter(adapterLower);
        lstvrmyAccessories.setAdapter(adapterAccessories);
       lstvTheShoes.setAdapter(adapterTheShoes);



        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
//        spnrSubject1 = findViewById(R.id.pickDis1);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar = {"Random", "Specific color", "Sporty", "Formal or Business Attire", "Casual Style, other..."};
        //spnr5تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr6ربط الكائن المرئي بالوسيط
        //spnrSubject1.setAdapter(adapter);

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
//

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
        List<MyClothes> allClothes = clothesQuery1.getAllmyClothes();
        ArrayAdapter<MyClothes> ClothesAdapter = new ArrayAdapter<MyClothes>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);

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
            List<MyClothes> allClothes = clothesQuery1.getClothesByCloId(key_id);
            ArrayAdapter<MyClothes> ClothesAdapter = new ArrayAdapter<MyClothes>(this, android.R.layout.simple_spinner_dropdown_item);
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
        public void showPopUpMenu(View v, MyClothes item) {
            //بناء القائمة popup menu
            PopupMenu popup = new PopupMenu(this, v);
            //ملف القائمة
            popup.inflate(R.menu.pupupmenu);
            //اضافة معالج حدث لاختيار عنصر من القائمة
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.mnTakePhoto) {
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

    /**
     * الهدف من هذا الكود هو معالجة تفاعل المستخدم مع عناصر القائمة (Menu Items) في نشاط (Activity) أندرويد. بناءً على العنصر الذي تم اختياره، ينفذ التطبيق إجراءات محددة مثل عرض رسائل قصيرة (Toasts)، بدء أنشطة جديدة، أو بدء/إيقاف خدمة تشغيل الموسيقى.
     * @param item
     * @return
     */

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MainActivity.this, MyProfile.class);
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
            Intent i = new Intent(MainActivity.this, FavoritesPage.class);
            startActivity(i);

        }
        if(item.getItemId()==R.id.mnPlayMusic)
        {
            Toast.makeText(this, "Play Music", Toast.LENGTH_SHORT).show();
            Intent serviceIntn=new Intent(getApplicationContext(),MyAdudioPlayerService.class);
            startService(serviceIntn);
        }
        if(item.getItemId()==R.id.mnStopMusic)
        {
            Toast.makeText(this, "Stop Music", Toast.LENGTH_SHORT).show();
            Intent serviceIntn=new Intent(getApplicationContext(),MyAdudioPlayerService.class);
            startService(serviceIntn);
        }

        return true;
    }

    /**
     * الهدف من الكود في دالة onRestart هو تنفيذ إجراءات معينة عند إعادة تشغيل نشاط (Activity) أندرويد بعد أن كان في وضع التوقف المؤقت أو بعد أن تم إيقافه بالكامل ثم استئنافه. هذا هو جزء من دورة حياة النشاط في أندرويد.
     *
     */
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
//        initSubjectSpnr();
      //  initAllListView();
        readTaskFrom_FB();
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
    /**
     *  קריאת נתונים ממסד הנתונים firestore
     * @return .... רשימת הנתונים שנקראה ממסד הנתונים
     */
    public void readTaskFrom_FB()
    {
        //مؤشر لقاعدة البيانات
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //استخراج الرقم المميز للمستعمل الذ يسجل دخول لاستعماله كاسم لل"document
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //معالج حدث لفحص هل تم المطلوب من قاعدة البيانات
        db.collection("users").document(uid).collection("clothes");

        //בניית רשימה ריקה
        ArrayList<MyClothes> arrayList =new ArrayList<>();
        //קישור לקבוצה לקבוצה שרוצים לקרוא
        db.collection("MyUsers").document(uid).collection("clothes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    /**
                     * תגובה לאירוע השלמת קריאת הנתונים
                     * @param task הנתונים שהתקבלו מענן מסד הנתונים
                     */
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful())// אם בקשת הנתונים התקבלה בהצלחה
                        {
                            adapterUpper.clear();
                            adapterLower.clear();
                            adapterAccessories.clear();
                            adapterTheShoes.clear();
                            //מעבר על כל ה״מסמכים״= עצמים והוספתם למבנה הנתונים
                            for (DocumentSnapshot document : task.getResult().getDocuments()) {
                                //המרת העצם לטיפוס שלו// הוספת העצם למבנה הנתונים
                                MyClothes clothes = document.toObject(MyClothes.class);
                                ///        String[] ar = {"The Upper Part", "The Lower Part", "The Shoe", "Accessories"};
                                if (clothes.getTheType().equals("The Upper Part"))
                                    adapterUpper.add(clothes);
                                if (clothes.getTheType().equals("The Lower Part"))
                                    adapterLower.add(clothes);
                                if (clothes.getTheType().equals("The Shoe"))
                                    adapterTheShoes.add(clothes);
                                if (clothes.getTheType().equals("Accessories"))
                                    adapterAccessories.add(clothes);

                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error Reading data"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }












}



