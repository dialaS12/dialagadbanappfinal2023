package dga.example.dialagadbanappfinal2023.data.clothesTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class myClothes {
    @PrimaryKey(autoGenerate = true)
    /**
     * رقم القطعه
     */
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

    /**
     *رقم القطعه
     */
    public long CloId;


    @Override
    public String toString() {
        return "myClothes{" +
                "keyid=" + keyid +
                ", TheType='" + TheType + '\'' +
                ", ThePic='" + ThePic + '\'' +
                ", TheSeason='" + TheSeason + '\'' +
                ", TheColor='" + TheColor + '\'' +
                ", TheMaterial='" + TheMaterial + '\'' +
                '}';
    }
}





