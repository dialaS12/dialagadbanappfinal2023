package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

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

    public void onClickmain(View v) {
        //to open new activity from current to next
        Intent i = new Intent(singUp1.this, MainActivity.class);
        startActivity(i);
        //to close current activity
        finish();
    }

    public void onClickCancle(View v)
    {
        finish();
    }
    public void onClickCheckEPRP(View v)
    {
        checkEPRP();
    }

    public void checkEPRP() {
        boolean isAllOk = true;
        String email = etEmail.getText().toString();
        String password = etpassword.getText().toString();
        String repassword = etRePassword.getText().toString();
        String phone=etPhone.getText().toString();

        if (email.length() < 6 || email.contains("@") == false) ;
        {
            isAllOk = false;
            etEmail.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains("") == true)//يجب فحص الاستاذ
        {
            isAllOk = false;
            etpassword.setError("Wrong Password");
        }
        if (repassword.length() ==password.length() || repassword.contains(password) == true)//يجب فحص الاستاذ
        {
            isAllOk=false;
            etRePassword.setError("Wrong RePassword");
        }

        if (phone.length()<10||password.contains("")==true)//يجب فحص الاستاذ
        {
            isAllOk=false;
            etPhone.setError("Wrong Phone");
        }
        if (isAllOk) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }

    }
}
