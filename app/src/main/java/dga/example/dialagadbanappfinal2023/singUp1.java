package dga.example.dialagadbanappfinal2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import dga.example.dialagadbanappfinal2023.data.usersTable.MyUser;
import dga.example.dialagadbanappfinal2023.data.usersTable.MyUserQuery;

public class singUp1 extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etpassword;
    private TextInputEditText etRePassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up1);
        setContentView(R.layout.activity_sing_up1);
        etEmail = (TextInputEditText) findViewById(R.id.etPassword);
        etpassword = (TextInputEditText) findViewById(R.id.etPassword);
        etRePassword = (TextInputEditText) findViewById(R.id.etRePassword);
        etName = (TextInputEditText) findViewById(R.id.etName);
        etPhone = (TextInputEditText) findViewById(R.id.etPhone);
        btnSave = (Button) findViewById(R.id.btnSave);
    }

    /*
        public void onClickmain(View v) {
            //to open new activity from current to next
            Intent i = new Intent(singUp1.this, MainActivity.class);
            startActivity(i);
            //to close current activity
            finish();
        }
    */
    public void onClickCancle(View v) {
        finish();
    }

    public void onClickCheckSave(View v) {
        checkEPRP();
    }

    public void checkEPRP() {
        boolean isAllOk = true;
        String name=etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etpassword.getText().toString();
        String repassword = etRePassword.getText().toString();
        String phone = etPhone.getText().toString();

        if (email.length() < 6 || email.contains("@") == false) ;
        {
            isAllOk = false;
            etEmail.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains("") == true) {
            isAllOk = false;
            etpassword.setError("Wrong Password");
        }
        if (repassword.length() == password.length() || repassword.contains(password) == true) {
            isAllOk = false;
            etRePassword.setError("Wrong RePassword");
        }

        if (phone.length() < 10 || phone.length() > 10 || phone.length() != 10 || phone.contains("") == true) {
            isAllOk = false;
            etPhone.setError("Wrong Phone");
        }
        if (isAllOk) {
            Toast.makeText(this, "All Ok`", Toast.LENGTH_SHORT).show();
            AppDatabace db = AppDatabace.getDB(getApplicationContext());
            MyUserQuery userQuery = db.getMyUserQuery();
            //فحص هل الايميل موجود من قبل ان يتم التسجيل من قبل
            if (userQuery.checkEmail (email) != null)
            {
                etEmail.setError("found email");
            }
            else //ان لم يكن الايميل موجودا نقوم ببناء كائن للمستعمل وادخاله في الجدول MyUser للستعملين
            {
                //بناء الكائن
                MyUser myUser = new MyUser();
                //تحديد قيم الصفات بالقيم التي استخرجناها
                myUser.fullName = name;
                myUser.phone = phone;
                myUser.passw = password;
                myUser.email = email;
                //اضافة الكائن الجديد للجدول
                userQuery.insert((myUser));
                //اغلاق الشاشة الحالية
                finish();

            }


        }
    }

    public void onClickSave1 (View v)

    {
        checkEPRP_FB();
    }

    public void checkEPRP_FB()
    {
        boolean isAllOk1 = true;
        String name1 = etName.getText().toString();
        String email1 = etEmail.getText().toString();
        String password1 = etpassword.getText().toString();
        String repassword1 = etRePassword.getText().toString();
        String phone1 = etPhone.getText().toString();


        if (email1.length() < 6 || email1.contains("@") == false) {
            isAllOk1 = false;
            etEmail.setError("Wrong Email");
        }
        if (password1.length() < 8 || password1.contains(" ") == true) {
            isAllOk1 = false;
            etpassword.setError("Wrong Password");
        }

        if (repassword1.length() != password1.length() || repassword1.equals(password1) == false) {
            isAllOk1 = false;
            etRePassword.setError("Wrong RePassword");
        }

        if (phone1.length() < 10 || phone1.length() > 10 || phone1.length() != 10 || phone1.contains(" ") == true) {
            isAllOk1 = false;
            etPhone.setError("Wrong Phone");
        }
        if (isAllOk1) {
            //كائن لعمليه التسجيل
            Firebas auth= FirebaseAuth.getInstance();
            //צירת חשבון בעזרת מיל וסיסמה




        }


    }


}

}
