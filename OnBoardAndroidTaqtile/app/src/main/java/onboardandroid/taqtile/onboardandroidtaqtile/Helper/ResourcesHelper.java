package onboardandroid.taqtile.onboardandroidtaqtile.Helper;

import android.content.Context;

/**
 * Created by taqtile on 1/6/16.
 */
public class ResourcesHelper {

    public static String getStringResourceByName(String aString, Context context) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(aString, "string", packageName);
        return context.getString(resId);
    }
}
