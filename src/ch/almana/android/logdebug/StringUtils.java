package ch.almana.android.logdebug;

public class StringUtils {

	/**
	 * Check for a empty or null string
	 * 
	 * @param s
	 *            string
	 * @return true if the string is null, null length or null length after
	 *         trimming and false otherwise
	 */
	public static boolean isEmpty(final String s) {
		return s == null || s.length() == 0 || s.trim().length() == 0;
	}

	/**
	 * Compare to strings <br>
	 * Where null ==""
	 * 
	 * @param s1
	 *            1st string
	 * @param s2
	 *            2nd string
	 * @return true the sting are equal or both either "" or null and false
	 *         oterwise
	 */
	public static boolean equal(final String s1, final String s2) {

		return (s1 == null ? s1 : "").equals(s2 == null ? s2 : "");
	}

}
