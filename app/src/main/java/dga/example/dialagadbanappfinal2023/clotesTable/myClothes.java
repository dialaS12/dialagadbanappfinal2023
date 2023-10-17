package dga.example.dialagadbanappfinal2023.clotesTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class myClothes {
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    /**
     * نوع القطعه
     */
    public String TheType;
    /**
     * الصوره للقطعه
     */
    public String ThePic;
    /**
     * الفصل المناسب لارتداء القطعه
     */
    public String TheSeason;
    /**
     * لون القطعه
     */
    public String TheColor;
    /**
     * خامه القطعه(حرير,قطن..)
     */
    public String TheMaterial;



}





