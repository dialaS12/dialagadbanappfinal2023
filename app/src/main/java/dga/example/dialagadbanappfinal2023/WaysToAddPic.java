package dga.example.dialagadbanappfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

public class WaysToAddPic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ways_to_add_pic);
    }
    @Override//داله لكي يبين التلت نقاط في الشاشه
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


}
