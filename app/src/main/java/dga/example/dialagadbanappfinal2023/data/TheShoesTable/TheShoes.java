package dga.example.dialagadbanappfinal2023.data.TheShoesTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.data.clothesTable.myClothes;

@Entity
public class TheShoes extends myClothes
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    /**
     * قياس الحذاء
     */
    public int ShoesSize;
}
