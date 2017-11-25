package appcentralpet.com.newcentralpet.Vacinas;

/**
 * Created by Jadson on 12/10/2017.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import appcentralpet.com.newcentralpet.R;


public class MyAlarmService extends Service
{



    @Override
    public IBinder onBind(Intent arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);

        Notification.Builder builder = new Notification.Builder(MyAlarmService.this);
        Intent notificationIntent = new Intent(this,Vacinas.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,notificationIntent, 0);
        builder.setSmallIcon(R.drawable.iconnotificacao)
                .setContentTitle("Central Pet")
                .setContentText("Seu pet tem uma vacina agendada para hoje")
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.getNotification();
        notificationManager.notify(R.drawable.iconnotificacao, notification);

    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();

    }

}