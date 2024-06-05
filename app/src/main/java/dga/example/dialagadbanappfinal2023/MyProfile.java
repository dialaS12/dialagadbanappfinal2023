package dga.example.dialagadbanappfinal2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
    }
    @Override//داله لكي يبين التلت نقاط في الشاشه
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MyProfile.this, MyProfile.class);
            startActivity(i);


        }
        if (item.getItemId() == R.id.itmLogOut) {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
            showYesNoDialog();

        }
        if (item.getItemId() == R.id.itmAddPic) {
            Toast.makeText(this, "AddPic", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MyProfile.this, AddPic.class);
            startActivity(i);
        }
        //Exstra(m.sameh)
        if (item.getItemId() == R.id.itemFavorites) {
            Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
            //to open new activity from current to next activity
            Intent i = new Intent(MyProfile.this, FavoritesPage.class);
            startActivity(i);
        }

        return true;
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
                Toast.makeText(MyProfile.this, "Signing Out", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        //الضغط على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقه
                Toast.makeText(MyProfile.this, "Signing Out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();//بناء شباك الحوار -دايالوج
        dialog.show();//عرض الشباك

    }

}
