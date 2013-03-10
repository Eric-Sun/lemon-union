package com.lemon.union.tools;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: liuqingyao
 * Date: 12-9-7
 * Time: 下午5:54
 * To change this template use File | Settings | File Templates.
 */
public class MD5Util {
    public static String get(String str){
        String hashValue="";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] byteHash=md5.digest();//取散列值
            int i=0;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteHash.length; offset++){
                i = byteHash[offset];
                if (i < 0) i += 256; //i为负数加256.
                if (i < 16) buf.append("0"); //小于16则十六进制数为1位,需补一位0.
                buf.append(Integer.toHexString(i));//转16进制数.
            }
            hashValue=buf.toString();
        } catch (NoSuchAlgorithmException e) {

        } catch (Exception e){

        }
        return hashValue;
    }

}
