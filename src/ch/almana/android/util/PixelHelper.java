package ch.almana.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class PixelHelper {

	public static float dp2px(final Context ctx, final int px) {
		Resources r = ctx.getResources();
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, r.getDisplayMetrics());
	}

	public static float px2dp(final Context ctx, final int px) {
		Resources r = ctx.getResources();
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, r.getDisplayMetrics());
	}
}
