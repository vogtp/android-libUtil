package ch.almana.android.util;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class Debug {

	private static final int DEBUG_SIGNATURE_HASH = -1623526495;

	public static boolean isUnsinedPackage(Activity act) {
		String packageName = act.getApplication().getPackageName();
		try {
			PackageInfo packageInfo = act.getApplication().getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
			int hash = packageInfo.signatures[0].hashCode();
			if (hash == DEBUG_SIGNATURE_HASH) {
				return true;
			}
		} catch (NameNotFoundException e) {
		}
		return false;
	}
}
