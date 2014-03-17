package de.mtthsfrdrch.an3mote.appwidget;

import android.app.PendingIntent;
import android.widget.RemoteViews;

import de.mtthsfrdrch.an3mote.Keycode;
import de.mtthsfrdrch.an3mote.appwidget.R;

/**
 * Created by mtthsfrdrch on 1/13/14.
 */
public class MediaAppWidget extends AbstractButtonAppWidget {
    @Override
    protected int getLayoutId() {
        return R.layout.layout_media;
    }

    @Override
    protected void setButtons(int appWidgetId, RemoteViews remoteViews) {
        PendingIntent pendingIntent =
                getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_MEDIA_PREVIOUS);
        remoteViews.setOnClickPendingIntent(R.id.buttonPrev, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_MEDIA_PLAY_PAUSE);
        remoteViews.setOnClickPendingIntent(R.id.buttonPause, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_MEDIA_PLAY);
        remoteViews.setOnClickPendingIntent(R.id.buttonPlay, pendingIntent);

        pendingIntent = getPendingIntentForKeyCode(appWidgetId, Keycode.KEYCODE_MEDIA_NEXT);
        remoteViews.setOnClickPendingIntent(R.id.buttonNext, pendingIntent);
    }
}
