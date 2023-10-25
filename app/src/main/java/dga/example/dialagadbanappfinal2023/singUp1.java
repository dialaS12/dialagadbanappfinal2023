package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class singUp1 extends AppCompatActivity
{
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
        etEmail= (TextInputEditText) findViewById(R.id.etPassword);
        etpassword= (TextInputEditText) findViewById(R.id.etPassword);
        etRePassword= (TextInputEditText) findViewById(R.id.etRePassword);
        etName= (TextInputEditText) findViewById(R.id.etName);
        etPhone= (TextInputEditText) findViewById(R.id.etPhone);
        btnSave= (Button) findViewById(R.id.btnSave);
    }
}