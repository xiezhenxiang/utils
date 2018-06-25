package util;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {
    public static boolean isNullOrEmpty(String url){
        if(url==null || "".equals(url))
            return true;
        return false;
    }
    public static String getHash (String title,String author){
        return DigestUtils.md5Hex(title+author);
    }



}
