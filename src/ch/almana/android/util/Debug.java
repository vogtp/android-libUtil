package ch.almana.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Toast;

public class Debug {

	private static final int DEBUG_SIGNATURE_HASH = -1623526495;

	public static boolean isUnsinedPackage(Context ctx) {
		String packageName = ctx.getApplicationInfo().packageName;
		try {
			PackageInfo packageInfo = ctx.getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
			int hash = packageInfo.signatures[0].hashCode();
			if (hash == DEBUG_SIGNATURE_HASH) {
				return true;
			}
		} catch (NameNotFoundException e) {
		}
		return false;
	}

	public static void notImplemented(Context context) {
		Toast.makeText(context, "Not implemented!", Toast.LENGTH_SHORT).show();
	}
}
