package com.iwen.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/12/10.
 */
public class PassUtils {

    /**
     * 加密
     * @param passwors
     * @param path
     * @return
     * @throws Exception
     */
    public static String Encryption(String passwors, String path) throws Exception {
        String[] arstr = findPasswprdPath(path);
        Key keySpec = new SecretKeySpec(arstr[0].getBytes(), "AES"); // 两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
        IvParameterSpec ivSpec = new IvParameterSpec(arstr[1].getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// 实例化加密类，参数为加密方式，要写全
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] b = cipher.doFinal(passwors.getBytes());// 加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE,7bit等等。此处看服务器需要什么编码方式
        return Base64.encodeBase64String(b);
    }

    /**
     * 解密
     *
     * @param password
     * @return
     * @throws FileNotFoundException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String Decrypt(String password, String path) throws Exception {
        String[] arstr = findPasswprdPath(path);
        byte[] passByte = Base64.decodeBase64(password); // 先用Base64解码
        IvParameterSpec ivSpec = new IvParameterSpec(arstr[1].getBytes());
        Key key = new SecretKeySpec(arstr[0].getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);// 与加密时不同MODE:Cipher.DECRYPT_MODE
        byte[] ret = cipher.doFinal(passByte);
        return new String(ret, "utf-8");
    }

    /**
     * 获得秘钥
     *
     * @param path
     * @throws FileNotFoundException
     */
    @SuppressWarnings("resource")
    public static String[] findPasswprdPath(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner in = null;
        String result = "";
        in = new Scanner(file);
        while (in.hasNextLine()) {
            result += in.nextLine() + ",";
        }
        String[] ar = result.split(",");
        return ar;
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
}
