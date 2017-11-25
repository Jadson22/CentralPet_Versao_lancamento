package appcentralpet.com.newcentralpet.Vacinas;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

import appcentralpet.com.newcentralpet.R;

/**
 * Created by Jadson on 14/10/2017.
 */
public class ServicoAlarme extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        NotificationManager nm= (NotificationManager) getBaseContext().getSystemService(getBaseContext().NOTIFICATION_SERVICE);
        Intent intent= new Intent(getBaseContext(), Vacinas.class);
        intent.putExtra("mensagem", "Alarme disparado");
        int id = (int) (Math.random() * 1000);PendingIntent pi= PendingIntent.getActivity(getBaseContext(), id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification noti= new Notification.Builder(getBaseContext())
                .setContentTitle("Central Pet" )
                .setContentText("Vacina marcada para hoje")
                .setSmallIcon(R.drawable.iconnotificacao).setContentIntent(pi).build();
        NotificationManager notificationManager= (NotificationManager) getBaseContext().getSystemService(getBaseContext().NOTIFICATION_SERVICE);
        noti.flags|= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(id, noti);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
