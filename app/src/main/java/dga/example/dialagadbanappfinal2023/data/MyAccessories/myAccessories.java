package dga.example.dialagadbanappfinal2023.data.MyAccessories;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.data.clothesTable.myClothes;

@Entity
public class myAccessories extends myClothes
{
    //تحديد الصفة كمفتاح رئيسي والذي ينتج بشكل اوتماتي
    @PrimaryKey(autoGenerate = true)
    public long keyid;

}
