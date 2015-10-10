/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securecomputing;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author William Briggs
 */
public class Sender {
        static InetAddress destAddress = null;
        static Socket serverSoc = null;
        static boolean validAddress = false;
        static boolean valid = false;

        
        
    public static void main(String[] args) {

        int counter = 0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //Will set key
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter the Key file");
            String keyword = sc.nextLine();
            //Will read the Key
            FileReader read = new FileReader(keyword);
            BufferedReader br = new BufferedReader(read);
            String strLine;
            String keyy = "";
            //Will put all characters in document into key
            while((strLine = br.readLine()) !=null){
                for(int i = 0; i < strLine.length();i++){
                    keyy += strLine.charAt(i);
                }
            }
            
            byte[]key = new byte[256];
            key = keyy.getBytes();

            //File Input Stream
            System.out.println("Please enter the document you wish to Encrypt");
            String dest = sc.nextLine();
            
            File doc = new File(dest);
            fis = new FileInputStream(doc);

            //File Output Stream

            File CiphertextSent = new File("CiphertextSent.txt");
            if (!CiphertextSent.exists()) {
                CiphertextSent.createNewFile();
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(CiphertextSent), "windows-1252");

            int strLine2 = 0;
            String files = "";
            //Read through each character in the text
            while ((strLine2 = fis.read()) != -1) {

                //Add character to String files
                files += (char) strLine2;
                //increment counter
                counter = counter + 1;
            }

            //Will create a new RC4 Object(key)
            RC4 input = new RC4(key);

            //DISPLAY PLAINTEXT

            //create a byte array[size of document]
            byte[] array = new byte[256];
            //Fill array with bytes of character read
            array = files.getBytes();
            //Fill string with plaintext
            String input2 = new String(array);
            //System.out.println("Plaintext:" + input2);

            //PRODUCE CIPHERTEXT
 
            //create byte array to store encrypted data
            byte[] encryptedText;
            //Store output of Encryption Method into byte array
            input = new RC4(key);
            encryptedText = input.Generation(array);

            String ciphertext = "";
            //Store output into a string
            ciphertext = new String(encryptedText, "Windows-1252");

            //Will write the contents into the outputstream
            writer.write(ciphertext);
            writer.close();

            //Will attempt to Connect to Receiver's IP address
            String host = "";
            System.out.println("Enter IP address");
            host = sc.nextLine();
            //Will attempt to connect to Port number
            int port = 0;
            System.out.println("Enter port number");
            port = sc.nextInt();
            
            //Will set up socket
            Socket s = new Socket(host, port);
            //Set outputStream
            OutputStream out = s.getOutputStream(); 
            DataOutputStream dos = new DataOutputStream(out);

            //Write the length of doc
            dos.writeInt(encryptedText.length);
            //Will write contents of ciphertext
            dos.write(encryptedText, 0, encryptedText.length);
            
            out.close();
            sc.close();
            fos.close();
            fis.close();

        } catch (Exception e) {
        }
    }
}
