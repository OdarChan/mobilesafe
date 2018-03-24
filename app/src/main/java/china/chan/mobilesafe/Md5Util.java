package china.chan.mobilesafe;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 64913 on 2018/3/23.
 */

public class Md5Util {

    private static String tag = "长度";

    public static String encoder(String psd){

        try {
            psd = psd + "mobilesafe";
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(psd.getBytes());
            Log.i(tag, Integer.toString(bs.length));

            StringBuffer stringBuffer = new StringBuffer();

            for (byte b : bs) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }

                stringBuffer.append(hexString);
            }
            Log.i(tag, stringBuffer.toString());
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

}
