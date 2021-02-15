/*

 */

package com.branding.middaymeal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Utils {
    public static void showErrorToastMessage(Context con, String message){
        Toast.makeText(con,message,Toast.LENGTH_LONG).show();
    }

    public static boolean getConnectivityStatusString(Context context) {
        String status = null;
        boolean statusRes = false;
        ConnectivityManager cm = (ConnectivityManager)           context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                status = "Wifi enabled";
                statusRes = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                status = "Mobile data enabled";
                statusRes = true;
            }
        } else {
            status = "No internet is available";
            statusRes = false;
        }
        return statusRes;
    }



}
