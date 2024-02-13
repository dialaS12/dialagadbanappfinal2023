package dga.example.dialagadbanappfinal2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import dga.example.dialagadbanappfinal2023.data.usersTable.MyUser;
import dga.example.dialagadbanappfinal2023.data.usersTable.MyUserQuery;

public class signIn1 extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etpassword;
    private Button btnSingin;
    private Button btnSingup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in1);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etpassword = (TextInputEditText) findViewById(R.id.etPassword);
        btnSingin = (Button) findViewById(R.id.btnSingin);
        btnSingup = (Button) findViewById(R.id.btnSingup);
    }

    public void onClickSingUp(View v) {
        //to open new activity from current to next
        Intent i = new Intent(signIn1.this, singUp1.class);
        startActivity(i);
        //to close current activity
    }

    /*public void onClickmain2(View v) {
        //to open new activity from current to next
        Intent i = new Intent(signIn1.this, MainActivity.class);
        startActivity(i);
        //to close current activity
        finish();
    }
*/
    public void onClickSingincheck(View v) {

        checkEmailPassw();

    }

    public void checkEmailPassw() {
        boolean isAllOk = true;
        String email = etEmail.getText().toString();
        String password = etpassword.getText().toString();
        if (email.length() < 6 || email.contains("@") == false) {
            isAllOk = false;
            etEmail.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains(" ") == true) {
            isAllOk = false;
            etpassword.setError("Wrong Password");
        }
        if (isAllOk) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
            //بناء قاعدة البيانات وارجاع مؤشر عليها
            AppDatabace db = AppDatabace.getDB(getApplicationContext());
            // مؤشر لكائن عمليات الجدول
            MyUserQuery userQuery = db.getMyUserQuery();
            // ان لم يكن موجود ,استعداء العملية التي تنفذ الاستعلام الذي يفحص البريد وكلمه المرور ويعيد كائنا ان كان موجودا او لا
            MyUser myUser = userQuery.checkEmailPassw(email, password);
            if (myUser == null) {
                Toast.makeText(this, "Wrong Email Or Password`", Toast.LENGTH_LONG).show();


            } else {

                //ان كان هناالك حساب الايمل والباسورد ننتقل الى شاشه الرئيسيه
                Intent i = new Intent(signIn1.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }
    }
    public void onClickSingincheck_FB(View v) {

        checkEmailPassw_FB();

    }

    public void checkEmailPassw_FB() {
        boolean isAllOk = true;
        String email1 = etEmail.getText().toString();
        String password1 = etpassword.getText().toString();
        if (email1.length() < 6 || email1.contains("@") == false) {
            isAllOk = false;
            etEmail.setError("Wrong Email");
        }
        if (password1.length() < 8 || password1.contains(" ") == true) {
            isAllOk = false;
            etpassword.setError("Wrong Password");
        }
        if (isAllOk) {
            //עצם לביצוע רישום
            FirebaseAuth auth=FirebaseAuth.getInstance();
            //כניסה לחשבון בעזרת מיל וסיסמה
            auth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())//אם הפעולה הצליחה
                    {
                        Toast.makeText(signIn1.this,"Signing in Succeeded",Toast.LENGTH_SHORT).show();
                        //מעבר למסך הראשי
                        Intent i=new Intent(signIn1.this,MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(signIn1.this,"Signing in Failed",Toast.LENGTH_SHORT).show();
                        etEmail.setError(task.getException().getMessage());//

                    }
                }

            });
            }
        }
    }





