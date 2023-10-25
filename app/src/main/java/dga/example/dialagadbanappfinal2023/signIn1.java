package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class signIn1 extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etpassword;
    private Button btnSingin;
    private Button btnSingup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in1);
        etEmail= (TextInputEditText) findViewById(R.id.etEmail);
        etpassword= (TextInputEditText) findViewById(R.id.etPassword);
        btnSingin= (Button) findViewById(R.id.btnSingin);
        btnSingup= (Button) findViewById(R.id.btnSingup);
    }
}

