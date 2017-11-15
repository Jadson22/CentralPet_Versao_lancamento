package appcentralpet.com.newcentralpet.Vacinas;

/**
 * Created by Jadson on 12/10/2017.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import appcentralpet.com.newcentralpet.NavigationDrawer;
import appcentralpet.com.newcentralpet.R;

public class MyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Calendar calendar = Calendar.getInstance();
        long date = System.currentTimeMillis();
        SimpleDateFormat sfd = new SimpleDateFormat("d/M/yyyy");
        String dt = sfd.format(date);

        Cursor c = Vacinas.sqLiteHelperVacinas.getData("SELECT * FROM VACINAS");
        ArrayList<String> arrID = new ArrayList<>();
        while (c.moveToNext()){
            arrID.add(c.getString(3));
        }
        Toast.makeText(context, dt, Toast.LENGTH_LONG).show();

        String hj="[" + dt + "]";
        if(hj.equals(arrID.toString())){
        Intent service1 = new Intent(context, MyAlarmService.class);
        context.startService(service1);

    }else{
            Toast.makeText(context, "não é o dia", Toast.LENGTH_LONG).show();
        }

    }
}
