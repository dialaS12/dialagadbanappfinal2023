package dga.example.dialagadbanappfinal2023.data.MySeasonTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class MySeason
{
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي ينتج بشكل اوتماتي
    public long key_id;
    public String SeasonName;

    @Override
    public String toString() {
        return "MySubject{" +
                "key_id=" + key_id +
                ", fullName='" + SeasonName + '\'' +
                '}';
    }

    public long getKey_id() {
        return key_id;
    }
}

