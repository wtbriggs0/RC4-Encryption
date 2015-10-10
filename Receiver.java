/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securecomputing;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author William Briggs
 */
public class Receiver {

    public static void main(String args[]) throws Exception {


        ServerSocket server = null;
        boolean valid = false;

        //Will Find a valid port number
        for (int port = 5555; !valid; port++) {
            try {
                server = new ServerSocket(port);
                valid = true;
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }

            //Will Display the IP address
            try {
                System.out.println("Server's IP Address: " + InetAddress.getLocalHost().getHostAddress());
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

            //Will display the Port number
            System.out.println("Port: " + server.getLocalPort());

            boolean running = true;
            Socket serverSocket = null;
            //Will accept socket connection
            serverSocket = server.accept();
            
            //PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            
            InputStream in = serverSocket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            //Will get length of Document 
            int len = dis.readInt();
            byte[] data = new byte[len];
            if (len > 0) {
                dis.readFully(data);
            }
            //Will write contents to new file
            Files.write(Paths.get("CiphertextReceived.txt"),data);
           
            int counter = 0;
            FileInputStream fis = null;
            FileOutputStream fos = null;


            try {

                //Will ask for key to encrypt with
                Scanner sc = new Scanner(System.in);
                System.out.println("Please Enter the Key file");
                String keyword = sc.nextLine();

                FileReader read = new FileReader(keyword);
                BufferedReader br = new BufferedReader(read);

                String strLine;
                String keyy = "";
                //Will put all characters in document into key
                while ((strLine = br.readLine()) != null) {
                    for (int i = 0; i < strLine.length(); i++) {
                        keyy += strLine.charAt(i);
                    }
                }

                byte[] key = new byte[256];
                key = keyy.getBytes();


                //Prompt user to enter document to decrypt
                System.out.println("Please enter document you wish to decrypt");
                String document = sc.nextLine();
                File doc = new File(document);
                fis = new FileInputStream(doc);
                InputStreamReader isr = new InputStreamReader(fis, "windows-1252");

                //Will write contents of plaintext to message
                File CipherText = new File("Message_wtbriggs0.txt");
                if (!CipherText.exists()) {
                    CipherText.createNewFile();
                }
                //Will create OutputStreamWriter
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(CipherText), "windows-1252");
                int strLine2;
                String files = "";

                //Will read through ciphertext document
                while ((strLine2 = isr.read()) != -1) {

                    //increment counter
                    counter = counter + 1;
                    files += (char) strLine2;

                }

                //DISPLAY CIPHERTEXT

                //create a byte array[size of document]
                byte[] array = new byte[256];
                //Fill array with bytes of character read
                array = files.getBytes("Windows-1252");
                //Fill string with plaintext
                String input2 = new String(array, "Windows-1252");
                //System.out.println("Ciphertext:" + input2);

                //PRODUCE PLAINTEXT

                RC4 encoder = new RC4(key);
                String ciphertext = "";
                //create byte array to store encrypted data
                byte[] encryptedText = new byte[256];
                //Store output of Encryption Method into byte array
                encryptedText = encoder.Generation(array);
                //Store output into a string
                ciphertext = new String(encryptedText, "Windows-1252");
                //Print output
                //System.out.println("Plaintext Produced: " + ciphertext);

                writer.write(ciphertext);
                writer.close();

                in.close();
                dis.close();
                fis.close();
                fos.close();



            } catch (Exception e) {
            }

             
        }

    }
}
