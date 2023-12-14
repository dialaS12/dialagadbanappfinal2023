package dga.example.dialagadbanappfinal2023;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {MyUser.class },version = 2)

public  abstract class AppDatabace extends RoomDatabase
{
    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDatabace db;


}
