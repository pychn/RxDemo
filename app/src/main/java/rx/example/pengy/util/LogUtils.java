package rx.example.pengy.util;

import android.util.Log;

public class LogUtils {
    private static final String LOG_TAG = "RxDemo";

    public static void e(String log) {
        e(LOG_TAG, log);
    }

    public static void e(String tag, String log) {
        Log.e(tag, log);
    }
}
