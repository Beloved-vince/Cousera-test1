
/**
 * Write a description of CeaserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class CeaserCipher {
    public String encrypt(String input, int key){
    StringBuilder encrypted = new StringBuilder(input);
    String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String reverseAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    for(int i =0; i<encrypted.length(); i++){
    char currChar = encrypted.charAt(i);
    int index = alphabet.indexOf(currChar);
    if(index != -1){
    char newChar = reverseAlphabet.charAt(index);
    encrypted.setCharAt(i, newChar);
    }
    }
    return encrypted.toString();
    }
    
    public void testCeaser(){
        int key =15;
       String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
      String title = encrypt(message, key);
        if(title == encrypt(message, key)){
        message.toLowerCase();
        message.toUpperCase();
        }
        System.out.println(title);  
        }
public String encryptTwoKeys(String input, int key1, int key2) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet 
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Compute the shifted alphabet
        String ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i <encrypted.length();i+=2){
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
            if ((i %2 == 0) && (Character.isLowerCase(currChar))) {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                // If currChar is in the alphabet
            if (idx!= 0)
            {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet1.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
        
            else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
            {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = Alphabet.indexOf(currChar);
                // If currChar is in the alphabet
            if (idx != 0)
            {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = ShiftedAlphabet1.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
        
    }
    
       for (int i = 1; i <encrypted.length();i+=2){
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
            if ((i %2 != 0) && (Character.isLowerCase(currChar)))
            {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                // If currChar is in the alphabet
            if (idx != 0)
            {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet2.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 != 0) && (Character.isUpperCase(currChar))) {
            // Find the index of currChar in the alphabet (call it idx)
            int idx = Alphabet.indexOf(currChar);
            // If currChar is in the alphabet
        if (idx != 0)
            {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = ShiftedAlphabet2.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
                
    } 
    
    return encrypted.toString();
 
}

    public void result(){
    int key =8;
    int key2 = 21;
    String message=  "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!First Legion";
    String result = encryptTwoKeys(message, key, key2);
    System.out.println(result);
}
}
