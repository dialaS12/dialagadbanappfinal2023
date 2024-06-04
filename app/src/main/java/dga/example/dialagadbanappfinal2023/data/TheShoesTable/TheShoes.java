package dga.example.dialagadbanappfinal2023.data.TheShoesTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothes;

@Entity
public class TheShoes extends MyClothes
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    /**
     * قياس الحذاء
     */
    public int ShoesSize;
}
