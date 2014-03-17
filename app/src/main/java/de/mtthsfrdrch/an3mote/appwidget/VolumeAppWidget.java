package de.mtthsfrdrch.an3mote.appwidget;

import android.app.PendingIntent;
import android.widget.RemoteViews;

import de.mtthsfrdrch.an3mote.appwidget.R;

public class VolumeAppWidget extends AbstractButtonAppWidget {


    @Override
    protected int getLayoutId() {
        return R.layout.layout_volume;
    }

    @Override
    protected void setButtons(int appWidgetId, RemoteViews remoteViews) {
        PendingIntent pendingIntent = getPendingIntentForKeyCode(appWidgetId, "KEYCODE VOLUME UP");
        remoteViews.setOnClickPendingIntent(R.id.buttonVolUp, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, "KEYCODE VOLUME DOWN");
        remoteViews.setOnClickPendingIntent(R.id.buttonVolDown, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, "KEYCODE MUTE");
        remoteViews.setOnClickPendingIntent(R.id.buttonVolMute, pendingIntent);
    }
}
