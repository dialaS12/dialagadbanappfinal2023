package dga.example.dialagadbanappfinal2023.data.clothesTable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import dga.example.dialagadbanappfinal2023.R;

public class MyClothesAdapter extends ArrayAdapter<MyClothes> {
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
        //בניית הפריט הגרפי מתו קובץ העיצוב
        View vitem= convertView;
        if(vitem==null)
            vitem=LayoutInflater.from(getContext()).inflate(itemLayout,parent,false);
        // //קבלת הפניות לרכיבים בקובץ העיצוב
        ImageView imageView=vitem.findViewById(R.id.imageVitm);
        //קבלת הנתון (עצם) הנוכחי
        MyClothes current=getItem(position);
       // downloadImageUsingPicasso(current.getThePic(),im);



        return vitem;




    }
    /**
     * הצגת תמונה ישירות מהענן בעזרת המחלקה ״פיקאסו״
     * @param imageUrL כתובת התמונה בענן/שרת
     * @param toView רכיב תמונה המיועד להצגת התמונה אחרי ההורדה
     */
    private void downloadImageUsingPicasso(String imageUrL, ImageView toView)
    {
        // אם אין תמונה= כתובת ריקה אז לא עושים כלום מפסיקים את הפעולה
        if(imageUrL==null) return;
        //todo: add dependency to module gradle:
        //    implementation 'com.squareup.picasso:picasso:2.5.2'
        Picasso.with(getContext())
                .load(imageUrL)//הורדת התמונה לפי כתובת
                .centerCrop()
                .error(R.drawable.logodiala_background)//התמונה שמוצגת אם יש בעיה בהורדת התמונה
                .resize(90,90)//שינוי גודל התמונה
                .into(toView);// להציג בריכיב התמונה המיועד לתמונה זו
    }

}

