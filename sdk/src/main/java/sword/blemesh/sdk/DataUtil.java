package sword.blemesh.sdk;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Utilities for converting between Java and Database friendly types
 *
 * Created by davidbrodsky on 10/13/14.
 */
public class DataUtil {

    public static SimpleDateFormat storedDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * When we query rows by a BLOB column we must
     * convert the BLOB to its String hex form
     * see:
     * http://www.sqlite.org/lang_expr.html#litvalue
     */
    public static String  bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        String rawHex = new String(hexChars);
        return rawHex;
//        String blobLiteral = "X'" + rawHex + "'";
//        return blobLiteral;
    }

    public static byte[] hexToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
