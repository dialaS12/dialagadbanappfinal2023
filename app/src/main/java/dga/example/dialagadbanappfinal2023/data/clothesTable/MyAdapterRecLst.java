package dga.example.dialagadbanappfinal2023.data.clothesTable;

import static java.security.AccessController.getContext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dga.example.dialagadbanappfinal2023.MainActivity;
import dga.example.dialagadbanappfinal2023.R;

public class MyAdapterRecLst {
//        extends RecyclerView.Adapter<MyAdapterRecLst.ViewHolder> {
//
//    // ... ViewHolder class and its constructor as per above
//
//
//    ArrayList<MyClothes> list;
//    MainActivity contexct;
//
//    public MainActivity getContexct() {
//        return contexct;
//    }
//
//    public ArrayList<MyClothes> getList() {
//        return list;
//    }
//
//    // Constructor
//    public MyAdapterRecLst(ArrayList<MyClothes> list,MainActivity contexct){
//        this.contexct=contexct;
//        this.list = list;
//    }
//
//    // Creating a viewHolder
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // Inflate the layout
//        View contactView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.clothes_item_layout, parent, false);
//
//        // Return a new holder instance
//        ViewHolder viewHolder = new ViewHolder(contactView);
//
//        return viewHolder;
//    }
//
//    // Assigning respective data for the views based on the position of the current item
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapterRecLst.ViewHolder holder, int position) {
//        // Get the Subject based on the current position
//        MyClothes currentItem = list.get(position);
//        downloadImageUsingPicasso(currentItem.getThePic(),holder.imageView);
////        // Setting views with the corresponding data
////        ImageView imageView = holder.subjectImageView;
////        imageView.setImageResource(currentItem.getImageId());
////
////        TextView subjectTextView = holder.subjectTextView;
////        subjectTextView.setText(currentItem.getSubject());
////
////        TextView likesTextView = holder.numOfLikesTextView;
////        likesTextView.setText(currentItem.getSubject());
//    }
//
//    // Indicating how long your data is
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        ImageView imageView;
//
//        // Constructor - accepts entire row item
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            // //קבלת הפניות לרכיבים בקובץ העיצוב
//             imageView=itemView.findViewById(R.id.imageVitm);
//
//
//
//        }
//    }
//    /**
//     * הצגת תמונה ישירות מהענן בעזרת המחלקה ״פיקאסו״
//     * @param imageUrL כתובת התמונה בענן/שרת
//     * @param toView רכיב תמונה המיועד להצגת התמונה אחרי ההורדה
//     */
//    private void downloadImageUsingPicasso(String imageUrL, ImageView toView)
//    {
//        // אם אין תמונה= כתובת ריקה אז לא עושים כלום מפסיקים את הפעולה
//        if(imageUrL==null) return;
//        //todo: add dependency to module gradle:
//        Picasso.with(getContexct())
//                .load(imageUrL)//הורדת התמונה לפי כתובת
//                .centerCrop()
//                .error(R.drawable.logodiala_background)//התמונה שמוצגת אם יש בעיה בהורדת התמונה
//                .resize(100,100)//שינוי גודל התמונה
//                .into(toView);// להציג בריכיב התמונה המיועד לתמונה זו
//    }
}
