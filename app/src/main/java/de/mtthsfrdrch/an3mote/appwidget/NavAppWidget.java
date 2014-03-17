package de.mtthsfrdrch.an3mote.appwidget;

import android.app.PendingIntent;
import android.widget.RemoteViews;

import de.mtthsfrdrch.an3mote.Keycode;
import de.mtthsfrdrch.an3mote.appwidget.R;

/**
 * Created by mtthsfrdrch on 1/13/14.
 */
public class NavAppWidget extends AbstractButtonAppWidget {
    @Override
    protected int getLayoutId() {
        return R.layout.layout_nav;
    }

    @Override
    protected void setButtons(int appWidgetId, RemoteViews remoteViews) {
        PendingIntent pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_BACK);
        remoteViews.setOnClickPendingIntent(R.id.buttonBack, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_DPAD_CENTER);
        remoteViews.setOnClickPendingIntent(R.id.buttonDpadCenter, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_HOME);
        remoteViews.setOnClickPendingIntent(R.id.buttonHome, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_MENU);
        remoteViews.setOnClickPendingIntent(R.id.buttonMenu, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_DPAD_LEFT);
        remoteViews.setOnClickPendingIntent(R.id.buttonDpadLeft, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_DPAD_DOWN);
        remoteViews.setOnClickPendingIntent(R.id.buttonDpadDown, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_DPAD_UP);
        remoteViews.setOnClickPendingIntent(R.id.buttonDpadUp, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_DPAD_RIGHT);
        remoteViews.setOnClickPendingIntent(R.id.buttonDpadRight, pendingIntent);

        String[] keycodes = { Keycode.KEYCODE_TV_POWER, Keycode.KEYCODE_STB_POWER,
                Keycode.KEYCODE_AVR_POWER };
        pendingIntent = getPendingIntentForKeyCodes(appWidgetId, keycodes);
        remoteViews.setOnClickPendingIntent(R.id.buttonPower, pendingIntent);
    }
}
