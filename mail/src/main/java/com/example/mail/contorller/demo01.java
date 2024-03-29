package com.example.mail.contorller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class demo01 {
    private static Key key;
    private static String KEY_STR="myKey";
    private static String CHARSETNAME="UTF-8";
    private static String ALGORITHM="DES";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEY_STR.getBytes());
            generator.init(secureRandom);
            key = generator.generateKey();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     * 获取加密的信息
     * @param str
     * @return
     */
    public static String getEncryptString(String str) {
        //基于BASE64编码，接收byte[]并转换成String
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            //按utf8编码
            byte[] bytes = str.getBytes(CHARSETNAME);
            //获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //加密
            byte[] doFinal = cipher.doFinal(bytes);
            //byte[]to encode好的String 并返回
            return encoder.encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 获取解密之后的信息
     * @param str
     * @return
     */
    public static String getDecryptString(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //将字符串decode成byte[]
            byte[] bytes = decoder.decodeBuffer(str);
            //获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化解密信息
            cipher.init(Cipher.DECRYPT_MODE, key);
            //解密
            byte[] doFial = cipher.doFinal(bytes);

            return new String(doFial, CHARSETNAME);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> demo01 = Class.forName("com.example.mail.contorller.demo01");
            System.out.println("demo01 = " + demo01);
            System.out.println("demo01 = " + demo01.getName());
            System.out.println("demo01 = " + demo01.getFields().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
