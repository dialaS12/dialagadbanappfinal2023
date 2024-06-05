package dga.example.dialagadbanappfinal2023;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyAdudioPlayerService extends Service {
    private MediaPlayer mediaPlayer;//נגן מידיה
    private boolean isPlaying;// משתנה לשמור אם הנגן מנגן או עצר



    public MyAdudioPlayerService() {
    }
    public void onCreate(){
        super.onCreate();
        //יצירת נגן אודיו וקביעת קובץ האודיו
        mediaPlayer= MediaPlayer.create(getApplicationContext(),R.raw.music);
        isPlaying=false;//נמצא במצב ללא נגינה
    }


    /**
     *  בפעולה זו מתחיל השירות ומכיל את הקוד שיפעל ברקע
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mediaPlayer!=null && !isPlaying)
        {
            isPlaying=true;
            mediaPlayer.start();
        }
        return START_STICKY;
    }


    /**
     * פעולה זו מתבצעת כאשר עוצרים את השירות
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null && isPlaying)
        {
            mediaPlayer.release();
            isPlaying=false;
            mediaPlayer=null;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}







