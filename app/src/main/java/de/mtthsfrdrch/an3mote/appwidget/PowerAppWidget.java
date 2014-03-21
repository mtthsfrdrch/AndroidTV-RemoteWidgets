package de.mtthsfrdrch.an3mote.appwidget;

import android.app.PendingIntent;
import android.widget.RemoteViews;

import de.mtthsfrdrch.an3mote.Keycode;

/**
 * Created by mtthsfrdrch on 2/3/14.
 */
public class PowerAppWidget extends AbstractButtonAppWidget {
    @Override
    protected int getLayoutId() {
        return R.layout.layout_power;
    }

    @Override
    protected void setButtons(int appWidgetId, RemoteViews remoteViews) {
        PendingIntent pendingIntent =
                getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_STB_POWER);
        remoteViews.setOnClickPendingIntent(R.id.buttonStbPower, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_TV_POWER);
        remoteViews.setOnClickPendingIntent(R.id.buttonTvPower, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_AVR_POWER);
        remoteViews.setOnClickPendingIntent(R.id.buttonAvrPower, pendingIntent);
    }
}
