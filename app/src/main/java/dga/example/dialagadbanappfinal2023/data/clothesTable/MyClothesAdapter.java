package dga.example.dialagadbanappfinal2023.data.clothesTable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MyClothesAdapter extends ArrayAdapter<myClothes> {
    //המזהה של קובץ עיצוב הפריט
    private final int itemLayout;
    /**
     * פעולה בונה מתאם
     * @param context קישור להקשר (מסך- אקטיביטי)
     * @param resource עיצוב של פריט שיציג הנתונים של העצם
     */
    public MyClothesAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.itemLayout =resource;
    }
    /**
     * בונה פריט גרפי אחד בהתאם לעיצוב והצגת נתוני העצם עליו
     * @param position מיקום הפריט החל מ 0
     * @param convertView
     * @param parent רכיב האוסף שיכיל את הפריטים כמו listview
     * @return  . פריט גרפי שמציג נתוני עצם אחד
     */
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent)
    {
        return super.getView(position,convertView,parent);
        //



    }
}

