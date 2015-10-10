/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securecomputing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Owner
 */
public class DecryptData {

    /**
     * Will take the Encrypted Document and Substitute the Ciphertext
     * With the correct corresponding PlainText
     * Will also display the character count for each letter
     */
    public static void main(String[] args) {
        //Will initialize all 26 characters A-Z
        //Along with an overall character Count
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        int s = 0;
        int t = 0;
        int u = 0;
        int v = 0;
        int w = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int counter = 0;
        String strLine;


        try {

            //Will Create a new File, FileReader, and BufferedReader for the
            //Encrypted Document named (Ciphertext2.txt)
            File doc = new File("Ciphertext.txt");
            FileReader fr = new FileReader(doc);
            BufferedReader br = new BufferedReader(fr);

            //Will Create a new File, FileWriter, and BufferedWriter for the
            //Decrypted Ciphertext2 document named (Plaintext.txt)
            //Will Create the PlainText.txt document if it doesn't exist already
            
            File plainText = new File("P1_William_Plaintext.txt");
            if (!plainText.exists()) {
                plainText.createNewFile();
            }
            FileWriter fw = new FileWriter(plainText.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);


            //Will read Ciphertext2.txt, Line by Line
            while ((strLine = br.readLine()) != null) {
                //Will read each Line, character by character 
                //Counting whatever letter is being evaluated A-Z
                for (int ii = 0; ii < strLine.length(); ii++) {
                    //Determine if character is a
                    if (strLine.charAt(ii) == 'a') {
                        a = a + 1;
                        counter = counter + 1;
                        bw.write('w');

                    } 
                    //Determine if character is b
                    else if (strLine.charAt(ii) == 'b') {
                        b = b + 1;
                        counter = counter + 1;
                        bw.write('t');
                    } 
                    //Determine if character is c
                    else if (strLine.charAt(ii) == 'c') {
                        c = c + 1;
                        counter = counter + 1;
                        bw.write('u');
                    } 
                    //Determine if character is d
                    else if (strLine.charAt(ii) == 'd') {
                        d = d + 1;
                        counter = counter + 1;
                        bw.write('q');
                    } 
                    //Determine if character is e
                    else if (strLine.charAt(ii) == 'e') {
                        e = e + 1;
                        counter = counter + 1;
                        bw.write('b');
                    } 
                    //Determine if character is f
                    else if (strLine.charAt(ii) == 'f') {
                        f = f + 1;
                        counter = counter + 1;
                        bw.write('l');
                    } 
                    //Determine if character is g
                    else if (strLine.charAt(ii) == 'g') {
                        g = g + 1;
                        counter = counter + 1;
                        bw.write('m');
                    } 
                    //Determine if character is h
                    else if (strLine.charAt(ii) == 'h') {
                        h = h + 1;
                        counter = counter + 1;
                        bw.write('y');
                    } 
                    //Determine if character is i
                    else if (strLine.charAt(ii) == 'i') {
                        i = i + 1;
                        counter = counter + 1;
                        bw.write('p');
                    } 
                    //Determine if character is j
                    else if (strLine.charAt(ii) == 'j') {
                        j = j + 1;
                        counter = counter + 1;
                        bw.write('f');
                    }
                    //Determine if character is k
                    else if (strLine.charAt(ii) == 'k') {
                        k = k + 1;
                        counter = counter + 1;
                        bw.write('g');
                    }
                    //Determine if character is l
                    else if (strLine.charAt(ii) == 'l') {
                        l = l + 1;
                        counter = counter + 1;
                        bw.write('s');
                    }
                    //Determine if character is m
                    else if (strLine.charAt(ii) == 'm') {
                        m = m + 1;
                        counter = counter + 1;
                        bw.write('e');
                    } 
                    //Determine if character is n
                    else if (strLine.charAt(ii) == 'n') {
                        n = n + 1;
                        counter = counter + 1;
                        bw.write('z');
                    } 
                    //Determine if character is o
                    else if (strLine.charAt(ii) == 'o') {
                        o = o + 1;
                        counter = counter + 1;
                        bw.write('v');
                    } 
                    //Determine if character is p
                    else if (strLine.charAt(ii) == 'p') {
                        p = p + 1;
                        counter = counter + 1;
                        bw.write('d');
                    }
                    //Determine if character is q
                    else if (strLine.charAt(ii) == 'q') {
                        q = q + 1;
                        counter = counter + 1;
                        bw.write('n');
                    } 
                    //Determine if character is r
                    else if (strLine.charAt(ii) == 'r') {
                        r = r + 1;
                        counter = counter + 1;
                        bw.write('j');
                    }
                    //Determine if character is s
                    else if (strLine.charAt(ii) == 's') {
                        s = s + 1;
                        counter = counter + 1;
                        bw.write('o');
                    } 
                    //Determine if character is t
                    else if (strLine.charAt(ii) == 't') {
                        t = t + 1;
                        counter = counter + 1;
                        bw.write('k');
                    } 
                    //Determine if character is u
                    else if (strLine.charAt(ii) == 'u') {
                        u = u + 1;
                        counter = counter + 1;
                        bw.write('h');
                    } 
                    //Determine if character is v
                    else if (strLine.charAt(ii) == 'v') {
                        v = v + 1;
                        counter = counter + 1;
                        bw.write('a');
                    } 
                    //Determine if character is w
                    else if (strLine.charAt(ii) == 'w') {
                        w = w + 1;
                        counter = counter + 1;
                        bw.write('x');
                    } 
                    //Determine if character is x
                    else if (strLine.charAt(ii) == 'x') {
                        x = x + 1;
                        counter = counter + 1;
                        bw.write('r');
                    } 
                    //Determine if character is y
                    else if (strLine.charAt(ii) == 'y') {
                        y = y + 1;
                        counter = counter + 1;
                        bw.write('i');
                    } 
                    //Determine if character is z
                    else if (strLine.charAt(ii) == 'z') {
                        z = z + 1;
                        counter = counter + 1; 
                        bw.write('c');
                    } 
                    
                    //Will write any other character to the File
                    //Will not be a character to keep track of
                    //But will keep the Format of the File read
                    else {
                        bw.write(strLine.charAt(ii));
                    }

                }
                //Will Read the Next line in the File
                bw.newLine();
            }
            //Close BufferedReader and BufferedWriter
            bw.close();
            br.close();

        } catch (Exception ee) {
            System.out.println("EXCEPTION: " + ee);
        }
        
        //Will Print all the Character Counts along with the Correct Substitution

        System.out.println("CipherText m = PlainText e; Character Count --> " + m);
        System.out.println("CipherText b = PlainText t; Character Count --> " + b);
        System.out.println("CipherText v = PlainText a; Character Count --> " + v);
        System.out.println("CipherText L = PlainText s; Character Count --> " + l);
        System.out.println("CipherText q = PlainText n; Character Count --> " + q);
        System.out.println("CipherText y = PlainText i; Character Count --> " + y);
        System.out.println("CipherText s = PlainText o; Character Count --> " + s);
        System.out.println("CipherText x = PlainText r; Character Count --> " + x);
        System.out.println("CipherText z = PlainText c; Character Count --> " + z);
        System.out.println("CipherText p = PlainText d; Character Count --> " + p);
        System.out.println("CipherText g = PlainText m; Character Count --> " + g);
        System.out.println("CipherText u = PlainText h; Character Count --> " + u);
        System.out.println("CipherText f = PlainText l; Character Count --> " + f);
        System.out.println("CipherText J = PlainText f; Character Count --> " + j);
        System.out.println("CipherText i = PlainText p; Character Count --> " + i);
        System.out.println("CipherText c = PlainText u; Character Count --> " + c);
        System.out.println("CipherText k = PlainText g; Character Count --> " + k);
        System.out.println("CipherText e = PlainText b; Character Count --> " + e);
        System.out.println("CipherText h = PlainText y; Character Count --> " + h);
        System.out.println("CipherText w = PlainText x; Character Count --> " + w);
        System.out.println("CipherText o = PlainText v; Character Count --> " + o);
        System.out.println("CipherText a = PlainText w; Character Count --> " + a);
        System.out.println("CipherText t = PlainText k; Character Count --> " + t);
        System.out.println("CipherText d = PlainText q; Character Count --> " + d);
        System.out.println("CipherText n = PlainText z; Character Count --> " + n);
        System.out.println("CipherText r = PlainText j; Character Count --> " + r);
        System.out.println("Entire Document Character Count: " + counter);

    }
}
