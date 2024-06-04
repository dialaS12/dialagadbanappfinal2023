package dga.example.dialagadbanappfinal2023.data.clothesTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyClothes {
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
    public String CloId;
    public String uId;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCloId() {
        return CloId;
    }

    public void setCloId(String cloId) {
        CloId = cloId;
    }

    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public String getTheType() {
        return TheType;
    }

    public void setTheType(String theType) {
        TheType = theType;
    }

    public String getThePic() {
        return ThePic;
    }

    public void setThePic(String thePic) {
        ThePic = thePic;
    }

    public String getTheSeason() {
        return TheSeason;
    }

    public void setTheSeason(String theSeason) {
        TheSeason = theSeason;
    }

    public String getTheColor() {
        return TheColor;
    }

    public void setTheColor(String theColor) {
        TheColor = theColor;
    }

    public String getTheMaterial() {
        return TheMaterial;
    }

    public void setTheMaterial(String theMaterial) {
        TheMaterial = theMaterial;
    }



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





