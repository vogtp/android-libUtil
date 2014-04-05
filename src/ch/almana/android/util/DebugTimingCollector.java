package ch.almana.android.util;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public class DebugTimingCollector {
	private static final String TAG = "DebugTimingCollector";

	private static final Map<CharSequence, Long> timers = new HashMap<CharSequence, Long>();

	public static void startTimer(final CharSequence name) {
		timers.put(name, System.currentTimeMillis());
	}

	public static void stopTimer(final CharSequence name) {
		Long start = timers.get(name);
		if (start == null) {
			Log.e(TAG, "Timer does not exist: " + name);
			return;
		}
		long diff = System.currentTimeMillis() - start;
		Log.w(TAG, name + " took millies: " + diff);
	}
}
