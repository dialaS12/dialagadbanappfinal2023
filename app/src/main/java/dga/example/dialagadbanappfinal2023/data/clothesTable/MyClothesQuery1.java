package dga.example.dialagadbanappfinal2023.data.clothesTable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
@Dao
public interface MyClothesQuery1 {
    /**
     * *اعادة جميع معطيات جدول المهمات
     * @return * قائمة من الملابس
     */
    @Query("SELECT * FROM  myClothes")
    List<myClothes> getAllmyClothes();
    /**
     * واجهه تحوي عمليات /دوال/استعمالات على قاعدة البايانات
     *///لتحديد ان الواجهه تحوي استعلامات على قاعدة بيانات
    @Query("SELECT * FROM myClothes")
    List<myClothes> getAll();
    /**
     * ادخال الملابس
     * @param clothes * مجموعة الملابس
     */
    @Insert
    void insertAll(myClothes... clothes);
    /**
     * حذف مطاعم
     * @param clothes * حذف الملابس (  حسب المفاتح الرئيسي)
     */
    @Delete
    void delete(myClothes clothes);
    @Query("Delete From myClothes WHERE keyid=:id ")
    void delete(int id);
    @Insert
    void insert(myClothes myClothes);
    /**
     * تعديل المطاعم
     * @param  * مجموعة الملابس للتعديل
     * clothes
     */
    @Update
    void update(myClothes... values);
    //عملية تعيد جميع الصور حسب  رقم القطعه
    @Query("SELECT * FROM myClothes WHERE CloId=:key_id ")
    List<myClothes> getClothesByCloId(Long key_id);
}





