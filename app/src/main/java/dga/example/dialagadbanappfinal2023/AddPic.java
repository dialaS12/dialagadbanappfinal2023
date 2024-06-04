package dga.example.dialagadbanappfinal2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothes;

public class AddPic extends AppCompatActivity {
    //spnr3 تعريف صفه للكائن المرئي
    private TextView whichPart;
    private Spinner spinnerPart;
    private TextView whichSeason;
    private Spinner spinnerSeason;
    private Button btnpickcolor;
    private Button btnSave;
    private Button btnCancle;
    private ImageButton image8;
    //upload: 1 add Xml image view or button and upload button
    //upload: 2 add next fileds
    private final int IMAGE_PICK_CODE = 100;// קוד מזהה לבקשת בחירת תמונה
    private final int PERMISSION_CODE = 101;//קוד מזהה לבחירת הרשאת גישה לקבצים
    private Uri toUploadimageUri;// כתוב הקובץ(תמונה) שרוצים להעלות
    private Uri downladuri;//כתובת הקוץ בענן אחרי ההעלאה
    private MyClothes clothes=new MyClothes(); //עצם/נתון שרוצים לשמור
    private TextInputEditText etTitle;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pic);
        whichSeason = (TextView) findViewById(R.id.whichSeason);
        whichPart = (TextView) findViewById(R.id.whichPart);
        btnpickcolor = (Button) findViewById(R.id.btnpickcolor);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancle = (Button) findViewById(R.id.btnCancle);
        etTitle=findViewById(R.id.etTitle);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAndSaveClothes();
            }
        });
        //upload: 3
        image8=(ImageButton)findViewById(R.id.image8);
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();

            }
        });



        //spnr3 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spinnerPart = findViewById(R.id.spinnerPart);
//        spnr4 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spinnerSeason =findViewById(R.id.spinnerSeason);
//        spnr3,4 بناء الوسيط(للاجزاء) وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr3 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar = {"The Upper Part", "The Lower Part", "The Shoe", "Accessories"};
        //spnr3تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr3ربط الكائن المرئي بالوسيط
        spinnerPart.setAdapter(adapter);
        //وسسط للفلصول
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        //spnr4 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] arr = {"Summer", "Spring", "Winter", "Autumn"};
        //spnr4تحديد المعطيات للوسيط
        adapter2.addAll(arr);
        //spnr4ربط الكائن المرئي بالوسيط
        spinnerSeason.setAdapter(adapter2);
    }

    private void pickImageFromGallery() {
        //implicit intent (מרומז) to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//ستعمال ال* لكي نشمل كل الملفات او التطبيقات التي تخص الصور
        startActivityForResult(intent, IMAGE_PICK_CODE);//הפעלתה האינטנט עם קוד הבקשה
    }
    //אחרי שבוחרים את התמונה בעזרת startActivityForResult  חוזרים לפעולה onActivityResult (שהיא חלק ממעגל החיים של אקטיביטי) לפעולה זו מקבלים מה שבחרנו.
    //דורסים (Overriding) את הפעולה onActivityResult:
    //upload: 5:handle result of picked images
    /**
     *
     * @param requestCode מספר הקשה
     * @param resultCode תוצאה הבקשה (אם נבחר משהו או בוטלה)
     * @param data הנתונים שנבחרו
     */
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //אם נבחר משהו ואם זה קוד בקשת התמונה
        if (resultCode==RESULT_OK && requestCode== IMAGE_PICK_CODE){
            //a עידכון תכונת כתובת התמונה
            toUploadimageUri = data.getData();//קבלת כתובת התמונה הנתונים שניבחרו
            image8.setImageURI(toUploadimageUri);// הצגת התמונה שנבחרה על רכיב התמונה
        }
    }
    //בדיקת ועדכון הרשאות:
    //upload: 6
    /**
     * בדיקה האם יש הרשאה לגישה לקבצים בטלפון
     */
    private void checkPermission()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//בדיקת גרסאות
            //בדיקה אם ההשאה לא אושרה בעבר
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                //רשימת ההרשאות שרוצים לבקש אישור
                String[] permissions = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
                //בקשת אישור ההשאות (שולחים קוד הבקשה)
                //התשובה תתקבל בפעולה onRequestPermissionsResult
                requestPermissions(permissions, PERMISSION_CODE);
            } else {
                //permission already granted אם יש הרשאה מקודם אז מפעילים בחירת תמונה מהטלפון
                pickImageFromGallery();
            }
        }
        else {//אם גרסה ישנה ולא צריך קבלת אישור
            pickImageFromGallery();
        }
    }
    //התשובה של בקשת ההרשאות על ידי requestPermissions מתקבלות הפעולה onRequestPermissionsResult:
    //upload: 7
    /**
     * @param requestCode The request code passed in מספר בקשת ההרשאה
     * @param permissions The requested permissions. Never null. רשימת ההרשאות לאישור
     * @param grantResults The grant results for the corresponding permissions תוצאה עבור כל הרשאה
     *   PERMISSION_GRANTED אושר or PERMISSION_DENIED נדחה . Never null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISSION_CODE) {//בדיקת קוד בקשת ההרשאה
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permission was granted אם יש אישור
                pickImageFromGallery();
            } else {
                //permission was denied אם אין אישור
                Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
            }

        }


    }

    /**
     *
     * @param clothes
     */
    private void Saveclothes_FB(MyClothes clothes) {
        //مؤشر لقاعدة البيانات
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //استخراج الرقم المميز للمستعمل الذ يسجل دخول لاستعماله كاسم لل"document
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //ناء الكائن الذي سيتم حفظه
        clothes.setUid(uid);
        String id = db.collection("MyUsers").document(uid).collection("clothes").document().getId();
        clothes.setCloId(id);
        //اضافه كائن "لمجموعه" المستعلمين ومعالج حدث لفحص نجاح المطلوب
        //معالج حدث لفحص هل تم المطلوب من قاعدة البيانات
        db.collection("MyUsers").document(uid).collection("clothes").document(id).set(clothes).addOnCompleteListener(new OnCompleteListener<Void>() {
            //داله معالج الحدث
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //هل تم تنفيذ المطلوب بنجاح
                if (task.isSuccessful()) {
                    Toast.makeText(AddPic.this, "Succeeded to add pic", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddPic.this, "Failed to add pic", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    /**
     *
     */
    private void checkAndSaveClothes()
    {
        boolean isAllOk1 = true;
        String Title = etTitle.getText().toString();
        String part=spinnerPart.getSelectedItem().toString();
        String season=spinnerSeason.getSelectedItem().toString();

        if (Title.length()==0)
        {
            isAllOk1=false;
            etTitle.setError("must have a title to this utf");

        }
        if (toUploadimageUri==null)
        {
            isAllOk1=false;
            Toast.makeText(this, "add image???", Toast.LENGTH_SHORT).show();

        }
        if (isAllOk1)
        {
            clothes.setTitle(Title);
            clothes.setTheType(part);
            clothes.setTheSeason(season);

            uploadImage(toUploadimageUri);
        }

        //[;p,


    }

    /**
     *
     * @param filePath
     */
    private void uploadImage(Uri filePath) {
        if (filePath != null) {
            //יצירת דיאלוג התקדמות
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();//הצגת הדיאלוג
            //קבלת כתובת האחסון בענן
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReference();
            //יצירת תיקיה ושם גלובלי לקובץ
            final StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
            // יצירת ״תהליך מקביל״ להעלאת תמונה
            ref.putFile(filePath)
                    //הוספת מאזין למצב ההעלאה
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();// הסתרת הדיאלוג
                                //קבלת כתובת הקובץ שהועלה
                                ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Uri> task) {
                                        downladuri = task.getResult();
                                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                                        clothes.setThePic(downladuri.toString());//עדכון כתובת התמונה שהועלתה
                                        Saveclothes_FB(clothes);
                                    }
                                });
                            } else {
                                progressDialog.dismiss();//הסתרת הדיאלוג
                                Toast.makeText(getApplicationContext(), "Failed " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    //הוספת מאזין שמציג מהו אחוז ההעלאה
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //חישוב מה הגודל שהועלה
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()/ taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        } else {

        }

    }
    public void onClickSave_FB(View v) {

        checkAndSaveClothes();


    }








}






