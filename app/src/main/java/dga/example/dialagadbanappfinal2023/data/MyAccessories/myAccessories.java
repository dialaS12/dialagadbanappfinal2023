package dga.example.dialagadbanappfinal2023.data.MyAccessories;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothes;

@Entity
public class myAccessories extends MyClothes
{
    //تحديد الصفة كمفتاح رئيسي والذي ينتج بشكل اوتماتي
    @PrimaryKey(autoGenerate = true)
    public long keyid;

}
