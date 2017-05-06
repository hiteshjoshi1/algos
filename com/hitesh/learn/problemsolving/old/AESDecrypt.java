package com.hitesh.learn.problemsolving.old;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.Arrays;

public class AESDecrypt {

    private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String aesEncryptionAlgorithm = "AES";
    private static final String UNICODE_FORMAT  = "UTF8";

    public static byte[] decryptBase64EncodedWithManagedIV(String encryptedText, String key) throws Exception {
        byte[] cipherText = Base64.decodeBase64(encryptedText.getBytes(UNICODE_FORMAT));
        byte[] keyBytes = Base64.decodeBase64(key.getBytes(UNICODE_FORMAT));
        return decryptWithManagedIV(cipherText, keyBytes);
    }

    public static byte[] decryptWithManagedIV(byte[] cipherText, byte[] key) throws Exception{
        byte[] initialVector = Arrays.copyOfRange(cipherText,0,16);
        byte[] trimmedCipherText = Arrays.copyOfRange(cipherText,16,cipherText.length); 
        return decrypt(trimmedCipherText, key, initialVector);
    }

    public static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) throws Exception{
       Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }
    
    public static String symmetricDecrypt(String text, String secretKey) {
        Cipher cipher;
        String encryptedString;
        byte[] encryptText = null;
        byte[] raw;
        SecretKeySpec skeySpec;
        try {
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            encryptText = Base64.decodeBase64(text);
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            encryptedString = new String(cipher.doFinal(encryptText));
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return encryptedString;
    }
    public static String symmetricEncrypt(String text, String secretKey) {
        byte[] raw;
        String encryptedString;
        SecretKeySpec skeySpec;
        byte[] encryptText = text.getBytes();
        Cipher cipher;
        try {
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encryptedString = Base64.encodeBase64String(cipher.doFinal(encryptText));
        } 
        catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return encryptedString;
    }

    

    public static void main(String args[]) throws Exception{
        byte[] clearText = decryptBase64EncodedWithManagedIV("KT3QqHTvYzPWoRAjdE0c5zF9hFsunjDGlP94k%2Bwxb%2FyV%2BUCfllNUlwgx6w%2BKNktcRwL0jnXv0s9m0ft4KUYBelsgWORLWFx%2FJfDUGzswW9vQHMywnG%2FFjfsm2WJuO%2BfGUiD7pJ%2FraN%2FmMUpw1t03reb%2F1cQJd8gRKHmVwY2ya%2BZiOzfP4Ftikiz9UvTvYQgY", "mRMjHmlC1C+1L/Dkz8EJuw==");
        System.out.println("ClearText:" + new String(clearText,characterEncoding));
//    	String encrypt = symmetricEncrypt("cc=us&lc=en&rc=AMERICAS&countryISO=us&systemName=cfgoldg&agentname=Piyush Bathwal&agentId=005J0000001pubxIAA&agentFedID=piyush.bathwal@hp.com", "mRMjHmlC1C+1L/Dkz8EJuw==");
//    	System.out.println("Encrypted  "+encrypt);
//        String test = symmetricDecrypt(encrypt, "mRMjHmlC1C+1L/Dkz8EJuw==");
//        
//        System.out.println("Descrpted String "+test);
    }
}

