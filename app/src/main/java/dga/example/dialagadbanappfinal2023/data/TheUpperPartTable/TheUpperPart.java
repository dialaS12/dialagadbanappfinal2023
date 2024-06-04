package dga.example.dialagadbanappfinal2023.data.TheUpperPartTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.data.clothesTable.MyClothes;

@Entity
public class TheUpperPart extends MyClothes
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    /**
     * نوع الجزء العلوي (بنطال,تنورة,تايتس)
     */
    public String TheUpperPartType;

}
