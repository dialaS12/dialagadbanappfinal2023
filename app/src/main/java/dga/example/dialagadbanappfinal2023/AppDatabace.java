package dga.example.dialagadbanappfinal2023;

import android.content.Context;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.Room;
import dga.example.dialagadbanappfinal2023.data.usersTable.MyUser;
import dga.example.dialagadbanappfinal2023.data.usersTable.MyUserQuery;

@Database(entities = {MyUser.class },version = 1)

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
    public abstract MyUserQuery getMyUserQuery();
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
