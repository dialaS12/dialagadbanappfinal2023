package dga.example.dialagadbanappfinal2023.TheShoesTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.clotesTable.myClothes;

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
