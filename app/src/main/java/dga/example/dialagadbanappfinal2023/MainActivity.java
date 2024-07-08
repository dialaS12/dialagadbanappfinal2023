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
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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
import dga.example.dialagadbanappfinal2023.data.clothesTable.MyAdapterRecLst;
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



    MyClothesAdapter adapterUpper,adapterLower,adapterTheShoes,adapterAccessories;
    private RecyclerView lstvUpperr;
    private RecyclerView lstvLower;
    private RecyclerView lstTheShose;
    private RecyclerView lstvmyAccessories;
    private MyAdapterRecLst adapterRecLstUpper;
    private MyAdapterRecLst adapterRecLstLower;
    private MyAdapterRecLst adapterRecLstTheShoes;
    private MyAdapterRecLst adapterRecLstmyAccessories;



    public MainActivity() {
    }

    /**
     *هذا الكود يقوم بتهيئة عناصر الواجهة المختلفة للنشاط (عناصر Spinner وFloatingActionButton وبعض ImageView غير المفعلة)، ويقوم بتهيئة المحولات التي ستستخدم لتوفير البيانات لعناصر Spinner.
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd1 = (FloatingActionButton) findViewById(R.id.fabAdd1);
        // يقوم بإنشاء كائن جديد من النوع MyClothesAdapter ويبدو أنه يتم استخدامه في تطبيقك كمحول (Adapter) لعناصر البيانات
        adapterUpper=new MyClothesAdapter(getApplicationContext(),R.layout.clothes_item_layout);
         adapterLower = new MyClothesAdapter(getApplicationContext(), R.layout.clothes_item_layout);
        adapterTheShoes = new MyClothesAdapter(getApplicationContext(), R.layout.clothes_item_layout);
        adapterAccessories = new MyClothesAdapter(getApplicationContext(), R.layout.clothes_item_layout);

////هدف هذا الكود هو إعداد مكون RecyclerView في تطبيق أندرويد لعرض قائمة من العناصر بشكل أفقي. إليك شرح لكل جزء من الكود وما يهدف إلى تحقيقه:
        //العثور على RecyclerView في ملف التخطيط (layout):
         lstvUpperr = findViewById(R.id.lstvUpper);
      //  إنشاء محول (adapter) مخصص باستخدام قائمة فارغة:

// Instantiate SubjectAdapter with the data
         adapterRecLstUpper = new MyAdapterRecLst(new ArrayList<MyClothes>(),this);
// Set adapter with RecyclerView       //تعيين المحول إلى RecyclerView:
        lstvUpperr.setAdapter(adapterRecLstUpper);
// Set LayoutManagerعيين  LayoutManager لتنظيم العناصر بشكل أفقي:
        lstvUpperr.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


        // Find RecyclerView by Id (from the activity_main.xml)
        lstvLower=findViewById(R.id.lstvLowerPart);
        // Instantiate SubjectAdapter with the data
        adapterRecLstLower = new MyAdapterRecLst(new ArrayList<MyClothes>(),this);
// Set adapter with RecyclerView
        lstvLower.setAdapter(adapterRecLstLower);
// Set LayoutManager
        lstvLower.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        // Find RecyclerView by Id (from the activity_main.xml)
        lstTheShose=findViewById(R.id.lstTheShose);
        // Instantiate SubjectAdapter with the data
        adapterRecLstTheShoes = new MyAdapterRecLst(new ArrayList<MyClothes>(),this);
// Set adapter with RecyclerView
        lstTheShose.setAdapter(adapterRecLstTheShoes);
// Set LayoutManager
        lstTheShose.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


        // Find RecyclerView by Id (from the activity_main.xml)
        lstvmyAccessories=findViewById(R.id.lstvmyAccessories);
        // Instantiate SubjectAdapter with the data
        adapterRecLstmyAccessories = new MyAdapterRecLst(new ArrayList<MyClothes>(),this);
// Set adapter with RecyclerView
        lstvmyAccessories.setAdapter(adapterRecLstmyAccessories);
// Set LayoutManager
        lstvmyAccessories.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));








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





    }



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
     * تجهيز قائمة جميع الملابس  وعرضها ب list view
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
       // public void showPopUpMenu(View v, MyClothes item) {
            //بناء القائمة popup menu
           // PopupMenu popup = new PopupMenu(this, v);
            //ملف القائمة
          //  popup.inflate(R.menu.pupupmenu);
            //اضافة معالج حدث لاختيار عنصر من القائمة
           // popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
              //  @Override
              //  public boolean onMenuItemClick(MenuItem menuItem) {
               //     if (menuItem.getItemId() == R.id.mnTakePhoto) {
                        //هنا نكتب ردة فعل لاختيار هذا العنصر من القائمة
                 //       Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_SHORT).show();
                  //      Intent i = new Intent(MainActivity.this, AddPic.class);
                 //       startActivity(i);
                  //  }
                  //  if (menuItem.getItemId() == R.id.mnDelete) {
                  //      Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                 //   }
                  //  if (menuItem.getItemId() == R.id.mnEdit) {
                  //      Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                 //   }
                 //   return true;
              //  }


           // });
      //  }

    /**
     * الهدف من هذا الكود هو معالجة تفاعل المستخدم مع عناصر القائمة (Menu Items) في نشاط (Activity) أندرويد. بناءً على العنصر الذي تم اختياره، ينفذ التطبيق إجراءات محددة مثل عرض رسائل قصيرة (Toasts)، بدء أنشطة جديدة، أو بدء/إيقاف خدمة تشغيل الموسيقى.
     * @param item
     * @return
     */

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       //يتحقق هذا السطر مما إذا كان المعرف الخاص بالعنصر الذي تم اختياره هو itmProfile.
        if (item.getItemId() == R.id.itmProfile)
        {
            //عرض هذا السطر رسالة قصيرة على الشاشة تحتوي على النص "Profile".
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            //ينشئ هذا الجزء نية (Intent) جديدة للانتقال من النشاط الحالي MainActivity إلى النشاط الجديد MyProfile، ثم يبدأ النشاط الجديد باستخدام startActivity(i).
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
        if (item.getItemId() == R.id.itmSaveoutfits) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MainActivity.this, MyProfile.class);
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
            stopService(serviceIntn);
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
    // تُستدعى هذه الدالة عندما يعود النشاط إلى المقدمة ويصبح تفاعليًا للمستخدم بعد أن كان في وضع التوقف (Paused). الهدف من الكود داخل onResume هو تنفيذ عمليات معينة كلما عاد النشاط إلى الواجهة.
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
    //دالة onDestroy هي جزء من دورة حياة النشاط (Activity) في تطبيقات أندرويد. يتم استدعاء هذه الدالة عندما يتم تدمير النشاط، إما لأن النظام قرر ذلك لتحرير الذاكرة، أو لأن النشاط ينهي نفسه بشكل نهائي (مثلاً، عندما يستدعي finish()).
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
    public void onClickFavorits(View v) {
        //to open new activity from current to next
        Intent i = new Intent(MainActivity.this, FavoritesPage.class);
        startActivity(i);
        //to close current activity
    }
    public void onClickDate(View v) {
        //to open new activity from current to next
        Intent i = new Intent(MainActivity.this, MyProfile.class);
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
                            //قوم بعملية تفريغ (إزالة كل العناصر) من قائمة البيانات التي يستخدمها المحول (adapter) في RecyclerView
                            adapterRecLstUpper.getList().clear();
                            adapterRecLstLower.getList().clear();
                            adapterRecLstTheShoes.getList().clear();
                            adapterRecLstmyAccessories.getList().clear();
                            //מעבר על כל ה״מסמכים״= עצמים והוספתם למבנה הנתונים
                            for (DocumentSnapshot document : task.getResult().getDocuments()) {
                                //המרת העצם לטיפוס שלו// הוספת העצם למבנה הנתונים
                                MyClothes clothes = document.toObject(MyClothes.class);
                                ///        String[] ar = {"The Upper Part", "The Lower Part", "The Shoe", "Accessories"};
                                if (clothes.getTheType().equals("The Upper Part")) {
                                    //إذا تحقق الشرط السابق، يتم إضافة كائن clothes إلى قائمة البيانات في المحول (adapterRecLstUpper).
                                    //getList() هي دالة مخصصة ضمن المحول تعيد قائمة البيانات التي يحتفظ بها المحول.
                                    adapterRecLstUpper.getList().add(clothes);
                                    //بعد إضافة العنصر إلى القائمة، يتم استدعاء notifyDataSetChanged() على المحول لإعلامه بأن البيانات قد تغيرت.
                                    //هذا يؤدي إلى تحديث واجهة المستخدم لعرض العنصر الجديد في RecyclerView.
                                    adapterRecLstUpper.notifyDataSetChanged();
                                }
                                if (clothes.getTheType().equals("The Lower Part"))
                                    adapterRecLstLower.getList().add(clothes);
                                adapterRecLstLower.notifyDataSetChanged();

                                if (clothes.getTheType().equals("The Shoe"))
                                    adapterRecLstTheShoes.getList().add(clothes);
                                adapterRecLstTheShoes.notifyDataSetChanged();

                                if (clothes.getTheType().equals("Accessories"))
                                    adapterRecLstmyAccessories.getList().add(clothes);
                                adapterRecLstmyAccessories.notifyDataSetChanged();


                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error Reading data"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }












}



