
/**
 * Write a description of Course4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class Course4 {
    public String CeaserCipher(String s, int key){
    StringBuilder builder = new StringBuilder(s);
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String shiftAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    
    for(int i = 0; i< builder.length(); i++){
        char currChar = builder.charAt(i);
        int index = alphabet.indexOf(currChar);
        if(index != -1){
            
         char newChar = shiftAlphabet.charAt(index);
         builder.setCharAt(i,newChar);
        }
    }

    return builder.toString();
}
    public void test(){
    int key = 19;
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypt = CeaserCipher(message, key);
    System.out.println(encrypt.toLowerCase());
    String decrypt = CeaserCipher(encrypt , 26-key);
    System.out.println(decrypt.toLowerCase());
    
    }

}
