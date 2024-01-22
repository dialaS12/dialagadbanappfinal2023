package dga.example.dialagadbanappfinal2023;

import android.content.Context;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.Room;

import dga.example.dialagadbanappfinal2023.data.MyAccessories.myAccessories;
import dga.example.dialagadbanappfinal2023.data.MySeasonTable.MySeason;
import dga.example.dialagadbanappfinal2023.data.MySeasonTable.MySeasonQuery1;
import dga.example.dialagadbanappfinal2023.data.TheLowerPartTable.MyTheLowerPartQuery1;
import dga.example.dialagadbanappfinal2023.data.TheLowerPartTable.TheLowerPart;
import dga.example.dialagadbanappfinal2023.data.TheShoesTable.MyShoesQuery1;
import dga.example.dialagadbanappfinal2023.data.TheShoesTable.TheShoes;
import dga.example.dialagadbanappfinal2023.data.TheUpperPartTable.MyTheUpperPartQuery1;
import dga.example.dialagadbanappfinal2023.data.TheUpperPartTable.TheUpperPart;
import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothesQuery1;
import dga.example.dialagadbanappfinal2023.data.clothesTable.myClothes;
import dga.example.dialagadbanappfinal2023.data.usersTable.MyUser;
import dga.example.dialagadbanappfinal2023.data.usersTable.MyUserQuery;

@Database(entities = {MyUser.class, MySeason.class, myClothes.class, myAccessories.class, TheLowerPart.class, TheShoes.class, TheUpperPart.class},version = 1)

public  abstract class AppDatabace extends RoomDatabase
{
    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDatabace db;
    /**
     * يعيد مؤشر لعمليات جدول المستعملين
     * @return
     */
    public abstract MySeasonQuery1 getMySeasonQuery1();

    public abstract MyUserQuery getMyUserQuery();
    public abstract MyTheUpperPartQuery1 getMyTheUpperPartQuery1();
    public abstract MyShoesQuery1 getMyShoesQuery1();
    public abstract MyTheLowerPartQuery1 getTheLowerPartQuery1();
    public abstract MyClothesQuery1 getMyClothesQuery1();
    public static AppDatabace getDB(Context context)
    {
        if(db==null)
        {
            db = Room.databaseBuilder(context,AppDatabace.class, "database-DialaDataBase")//اسم قاعدة البيانات
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;

    }

}
