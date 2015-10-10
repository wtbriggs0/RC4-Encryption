/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securecomputing;

/**
 *
 * @author William Briggs
 */
public final class RC4 {
    
        int keylen = 0;
        byte[] K;
        byte[] S = new byte[256];
        byte[] T = new byte[256];
        
        
    public RC4(byte[] key)  {
       
     keylen = key.length;
     int j = 0;
       
     //Initalize
     for (int i = 0; i<256; i++){
            
            S[i] = (byte) i; 
            T[i] = key[i % keylen] ;    
            
        }
     //Initial permutation
     for (int i = 0; i < 256; i++) {
                j = (j + S[i] + T[i]) & 0xFF;
                Swap(i,j);
     }
}
    
    
    /**
     * Generation method will output the ciphertext byte array
     * @param stream
     * @return 
     */
    //Will encrypt/decrypt using byte array
    public byte[] Generation(byte[] stream){
        int i=0, j=0,t;
        byte k;
        
        byte[] result = new byte[stream.length];
        
        
        try{
        for(int w = 0; w < stream.length ; w++){
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            Swap(i,j);
            t = (S[i] + S[j]) &0xFF;
            k = S[t];     
            result[w] = (byte)(stream[w] ^ k);        
        }
        
        return result;
        }
        catch(Exception e){
            return null;
        }
    }
    
    /**
     * Swap Method will swap 2 elements
     * @param s
     * @param t 
     */
    
    public void Swap(int s , int t){
        byte temp = 0;
        temp = S[s];
        S[s] = S[t];
        S[t] = temp;
         
    } 
}
