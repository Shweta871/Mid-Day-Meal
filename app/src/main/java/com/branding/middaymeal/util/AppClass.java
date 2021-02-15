/*

 */

package com.branding.middaymeal.util;

import android.app.Application;

public class AppClass extends Application {

    private static AppClass appClass;

    public static AppClass getAppClass() {
        return appClass;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appClass = this;
    }
}
