package dga.example.dialagadbanappfinal2023.TheUpperPartTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dga.example.dialagadbanappfinal2023.clotesTable.myClothes;

@Entity
public class TheUpperPart extends myClothes
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    /**
     * نوع الجزء العلوي (بنطال,تنورة,تايتس)
     */
    public String TheUpperPartType;



}
