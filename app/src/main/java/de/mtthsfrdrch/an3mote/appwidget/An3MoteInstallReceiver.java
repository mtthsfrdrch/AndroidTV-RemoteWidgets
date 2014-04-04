package de.mtthsfrdrch.an3mote.appwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by mtthsfrdrch on 31.03.14.
 */
public class An3MoteInstallReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            String addedPackageName = intent.getData().getSchemeSpecificPart();
            if (addedPackageName.equals("de.mtthsfrdrch.an3mote")) {
                Intent broadcast = new Intent("de.mtthsfrdrch.an3mote.appwidget.UPDATE");
                context.sendBroadcast(broadcast);
            }
        }
    }
}
