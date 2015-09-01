package io.anotherwise.flashlight;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by marcelobarbosa on 9/1/15.
 */
public class FlashlightReceiver extends BroadcastReceiver {

    private static Flashlight flashlight;

    @Override
    public void onReceive(Context context, Intent intent) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.flashlight_app_widget);

        flashlight = new Flashlight(context);

        if(flashlight.flashSwitch() != "torch") {
            views.setImageViewResource(R.id.flashButton, R.drawable.abc_btn_rating_star_off_mtrl_alpha);
        } else {
            views.setImageViewResource(R.id.flashButton, R.drawable.abc_btn_rating_star_on_mtrl_alpha);
        }

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        appWidgetManager.updateAppWidget(new ComponentName(context, FlashlightAppWidget.class),views);
    }
}
