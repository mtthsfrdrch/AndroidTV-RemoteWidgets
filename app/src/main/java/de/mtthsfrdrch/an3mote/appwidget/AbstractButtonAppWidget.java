package de.mtthsfrdrch.an3mote.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import de.mtthsfrdrch.an3mote.An3Mote;

/**
 * Created by mtthsfrdrch on 1/8/14.
 */
public abstract class AbstractButtonAppWidget extends AppWidgetProvider {

    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (intent.getAction().equals("de.mtthsfrdrch.an3mote.appwidget.UPDATE")) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_root);
            remoteViews.setViewVisibility(R.id.textViewInstall, View.GONE);
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            ComponentName compName = new ComponentName(context, getClass().getCanonicalName());
            int[] ids = manager.getAppWidgetIds(compName);
            manager.partiallyUpdateAppWidget(ids, remoteViews);
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        this.context = context;

        boolean isAn3MoteInstalled = isAn3MoteInstalled();

        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews rootView = new RemoteViews(context.getPackageName(), R.layout.layout_root);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId());
            rootView.addView(R.id.containerContent, remoteViews);
            setButtons(appWidgetId, remoteViews);
            if (!isAn3MoteInstalled) {
                String url = "https://plus.google.com/communities/114784222385113449350";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                rootView.setOnClickPendingIntent(R.id.textViewInstall, pendingIntent);
                rootView.setViewVisibility(R.id.textViewInstall, View.VISIBLE);
            }
            appWidgetManager.updateAppWidget(appWidgetId, rootView);
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

    private boolean isAn3MoteInstalled() {
        try {
            context.getPackageManager().
                    getApplicationInfo("de.mtthsfrdrch.an3mote", PackageManager.GET_META_DATA);
            return true;
        } catch(PackageManager.NameNotFoundException ex) {
            return false;
        }
    }
}
