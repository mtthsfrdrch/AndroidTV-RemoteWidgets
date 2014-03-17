package de.mtthsfrdrch.an3mote.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import de.mtthsfrdrch.an3mote.An3Mote;

/**
 * Created by mtthsfrdrch on 1/8/14.
 */
public abstract class AbstractButtonAppWidget extends AppWidgetProvider {

    private Context context;

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        this.context = context;

        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId());
            setButtons(appWidgetId, remoteViews);
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

    protected PendingIntent getPendingIntentForKeyCode(int appWidgetId, String keycode) {
        Intent intent = new Intent();
        intent.setAction(An3Mote.ACTION_API_INVOKE);
        intent.putExtra(An3Mote.EXTRA_TYPE, An3Mote.TYPE_KEYCODE);
        intent.putExtra(An3Mote.EXTRA_KEYCODE, keycode);

        int requestCode = 10000 * appWidgetId + keycode.hashCode();
        return PendingIntent.getBroadcast(context, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    protected PendingIntent getPendingIntentForKeyCodes(int appWidgetId, String[] keycodes) {
        Intent intent = new Intent();
        intent.setAction(An3Mote.ACTION_API_INVOKE);
        intent.putExtra(An3Mote.EXTRA_TYPE, An3Mote.TYPE_KEYCODE_GROUP);
        intent.putExtra(An3Mote.EXTRA_KEYCODE_GROUP, keycodes);

        int requestCode = 10000 * appWidgetId + keycodes.hashCode();
        return PendingIntent.getBroadcast(context, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    protected abstract int getLayoutId();

    protected abstract void setButtons(int appWidgetId, RemoteViews remoteViews);

}
