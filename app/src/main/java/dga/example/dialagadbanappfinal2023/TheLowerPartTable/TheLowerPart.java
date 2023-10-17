package dga.example.dialagadbanappfinal2023.TheLowerPartTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.clotesTable.myClothes;
@Entity
public class TheLowerPart extends myClothes
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    /**
     * قياس الجزء السفلي
     */
    public int TheLowerPartSize;


}
