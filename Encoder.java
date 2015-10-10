/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securecomputing;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author William Briggs
 */
public class Encoder {

    static Scanner sc = new Scanner(System.in);
    static int strLine = 0;
    static private SecretKeySpec skeySpec;
    static private Cipher cipher;

    public static void main() {
        
        FileOutputStream fos = null;
       //Will Read in a File and Store into String
        try {
            System.out.println("Please enter the document you wish to Encrypt");
            String dest = sc.nextLine();

            File doc = new File(dest);
            FileInputStream fis = new FileInputStream(doc);
           
            String files = "";
            
            while((strLine = fis.read()) != -1){
             
             files += (char)strLine;
             
            }
            //Will put String into a byte array
            byte[] bytesOfMessage = files.getBytes();
            //FileOutputStream to new File
            File test = new File("Output_wtbriggs0.txt");
            fos = new FileOutputStream(test);
            
            //Will execute MD5 
            long startTime = System.currentTimeMillis();
            MD5(bytesOfMessage);
            long endTime = System.currentTimeMillis();
            int MD5time = (int)(endTime-startTime);  
            fos.write(("MD5 Run Time: "+ MD5time).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());
            
            //Will execute SHA1
            startTime = System.currentTimeMillis();
            SHA1(bytesOfMessage);
            endTime = System.currentTimeMillis();
            int SHA1time = (int)(endTime-startTime);
            fos.write(("SHA1 Run Time: "+ SHA1time).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());

            
            //Will execute SHA512
            startTime = System.currentTimeMillis();
            SHA512(bytesOfMessage);
            endTime = System.currentTimeMillis();
            int SHA512time = (int)(endTime-startTime);
            fos.write(("SHA512 Run Time: "+ SHA512time).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());

            
            //Will execute DES
            startTime = System.currentTimeMillis();
            DES(bytesOfMessage);
            endTime = System.currentTimeMillis();
            int DEStime = (int)(endTime-startTime);
            fos.write(("DES Run Time: "+ DEStime).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());

            //Will execute 3DES
            startTime = System.currentTimeMillis();
            DESede(bytesOfMessage);
            endTime = System.currentTimeMillis();
            int DES3time = (int)(endTime-startTime);
            fos.write(("3DES Run Time: "+ DES3time).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());
            
            //Will execute AES
            startTime = System.currentTimeMillis();
            AES(bytesOfMessage);
            endTime = System.currentTimeMillis();
            int AEStime = (int)(endTime-startTime);
            fos.write(("AES Run Time: "+ AEStime).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());

            //Will execute RSA
            startTime = System.currentTimeMillis();
            RSA(bytesOfMessage);
            endTime = System.currentTimeMillis();
            int RSAtime = (int)(endTime-startTime);
            fos.write(("RSA Run Time: "+ RSAtime).getBytes());
            fos.write(System.getProperty("line.separator").getBytes());

            
            //Close Readers/Writers
            fos.flush();
            fos.close();
            fis.close();
        } catch (Exception e) {
        }
    }


    /**
     * RSA algorithm
     * @param message 
     */
    public static void SHA1(byte[] message) {
        FileOutputStream fos = null;
        try {
            File doc = new File("HashingCode_SHA-1.txt");
            fos = new FileOutputStream(doc);

            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] output = md.digest(message);
            fos.write(output);
            fos.close();
        } catch (Exception e) {
        }

    }
    
    /**
     * MD5 Algorithm
     * @param message 
     */
    public static void MD5(byte[] message){
        FileOutputStream fos = null;
        try{
            File doc = new File("HashingCode_MD5.txt");
            fos = new FileOutputStream(doc);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(message);
            fos.write(output);
            fos.close();
        }catch(Exception e){
            
        }
    }
    
    /**
     * AES algorithm
     * @param message 
     */
    public static void AES(byte[] message){
        FileOutputStream fos = null;
        
        try{
            File doc = new File("CiphertextAES.txt");
            fos = new FileOutputStream(doc);
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //Plaintext to cipherText           
            SecretKey skey = kgen.generateKey();
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] ciphertext = cipher.doFinal(message);
            fos.write(ciphertext);
            fos.close();
            //Ciphertext to Plaintext
            File doc2 = new File("CiphertextAES_Decrypted.txt");
            fos = new FileOutputStream(doc2);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            byte[] plaintext = cipher.doFinal(ciphertext);
            fos.write(plaintext);
            fos.close();
            
        }
        catch(Exception e){
            System.out.println("AES exception " + e.getMessage());
            
        }
    }
    
    /**
     * SHA512 Algorithm
     * @param message 
     */
    public static void SHA512(byte[] message){
        FileOutputStream fos = null;
        try{
            File doc = new File("HashingCode_SHA-512.txt");
            fos = new FileOutputStream(doc);

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] output = md.digest(message);
            fos.write(output);
            fos.close();
         }catch(Exception e){
             
         }
         
    }

    /**
     * DES Algorithm
     * @param message 
     */
public static void DES(byte[] message){
    
    FileOutputStream fos = null;
        try{
            File doc = new File("CiphertextDES.txt");
            fos = new FileOutputStream(doc);
            KeyGenerator kgen = KeyGenerator.getInstance("DES");
            //Plaintext to cipherText
            SecretKey skey = kgen.generateKey();
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] ciphertext = cipher.doFinal(message);
            fos.write(ciphertext);
            fos.close();
            //Ciphertext to Plaintext
            File doc2 = new File("CiphertextDES_Decrypted.txt");
            fos = new FileOutputStream(doc2);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            byte[] plaintext = cipher.doFinal(ciphertext);
            fos.write(plaintext);
            fos.close();
        }
        catch(Exception e){
            System.out.println("DES Exception: " + e.getMessage());
        }
    }
    
/**
 * RSA Algorithm
 * @param message 
 */
public static void RSA(byte[] message){
    
    FileOutputStream fos = null;
        try{
            File doc = new File("CiphertextRSA.txt");
            fos = new FileOutputStream(doc);
            KeyPairGenerator kgen = KeyPairGenerator.getInstance("RSA");
            //Plaintext to cipherText            
            KeyPair skey = kgen.genKeyPair();
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, skey.getPublic());
            byte[] ciphertext = cipher.doFinal(message);
            fos.write(ciphertext);
            fos.close();
            //Ciphertext to Plaintext
            File doc2 = new File("CiphertextRSA_Decrypted.txt");
            fos = new FileOutputStream(doc2);
            cipher.init(Cipher.DECRYPT_MODE, skey.getPrivate());
            byte[] plaintext = cipher.doFinal(ciphertext);
            fos.write(plaintext);
            fos.close();
        }
        catch(Exception e){
           System.out.println("rsa Exception: " + e.getMessage());

        }
    }
    
    
public static void DESede(byte[] message){
    
    FileOutputStream fos = null;
        try{
            File doc = new File("Ciphertext3DES.txt");
            fos = new FileOutputStream(doc);
            KeyGenerator kgen = KeyGenerator.getInstance("desede");
            //Plaintext to cipherText
            SecretKey skey = kgen.generateKey();
            cipher = Cipher.getInstance("desede");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] ciphertext = cipher.doFinal(message);
            fos.write(ciphertext);
            fos.close();
            //Ciphertext to Plaintext
            File doc2 = new File("Ciphertext3DES_Decrypted.txt");
            fos = new FileOutputStream(doc2);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            byte[] plaintext = cipher.doFinal(ciphertext);
            fos.write(plaintext);
            fos.close();
        }
        catch(Exception e){
            System.out.println("3DES Exception: " + e.getMessage());
        }
    }

}





