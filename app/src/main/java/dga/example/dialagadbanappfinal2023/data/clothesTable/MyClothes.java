package dga.example.dialagadbanappfinal2023.data.clothesTable;


import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyClothes  {
    @PrimaryKey(autoGenerate = true)
    /**
     * رقم القطعه
     */
    public long keyid;

    /**
     * نوع القطعه
     */
    public String theType;
    /**
     * الصوره للقطعه
     */
    public String thePic;
    /**
     * الفصل المناسب لارتداء القطعه
     */
    public String theSeason;
    /**
     * لون القطعه
     */
    public String theColor;
    /**
     * خامه القطعه(حرير,قطن..)
     */
    public String theMaterial;
    public String title;

    /**
     *رقم القطعه
     */
    public String cloId;
    public String uid;

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public String getTheType() {
        return theType;
    }

    public void setTheType(String theType) {
        this.theType = theType;
    }

    public String getThePic() {
        return thePic;
    }

    public void setThePic(String thePic) {
        this.thePic = thePic;
    }

    public String getTheSeason() {
        return theSeason;
    }

    public void setTheSeason(String theSeason) {
        this.theSeason = theSeason;
    }

    public String getTheColor() {
        return theColor;
    }

    public void setTheColor(String theColor) {
        this.theColor = theColor;
    }

    public String getTheMaterial() {
        return theMaterial;
    }

    public void setTheMaterial(String theMaterial) {
        this.theMaterial = theMaterial;
    }

    public String getCloId() {
        return cloId;
    }

    public void setCloId(String cloId) {
        this.cloId = cloId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}





