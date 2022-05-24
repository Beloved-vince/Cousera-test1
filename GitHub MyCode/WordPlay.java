
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
public class WordPlay {
    public Boolean isVowel(char ch){
        String vowel ="aeiouAEIOU";
        vowel = vowel.toLowerCase().toUpperCase();
        int index = vowel.indexOf(ch);
        if(index == -1) {
            return false;
        }
        return true;     
  }
public void testResult(){
   System.out.println(isVowel('A'));
}
public String replaceVowels(String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase.toLowerCase().toUpperCase());
        for(int i =0; i<newPhrase.length(); i++){
            if(isVowel(newPhrase.charAt(i))){
            newPhrase.setCharAt(i, ch);
          
        }
     
        }
          return newPhrase.toString();
        }

    
     public void testIt(){
 String input = "This is a test example."
        +" All vowels will be replaced by *.";
        String replaced = replaceVowels(input, '*');
        System.out.println(replaced);
        }
        public String emphazise (String phrase, char ch){
            phrase = phrase.toLowerCase().toUpperCase();
            StringBuilder builder = new StringBuilder(phrase);
            for(int i = 0; i< builder.length(); i++){
            int even = builder.charAt(i);
            if(i%3== 1 ){
                ch = '*';
                builder.setCharAt(i, ch);
            }
            
           
            }
        return builder.toString();
        }
        public void testRun(){
        String testRun = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String run = emphazise(testRun, 'a');
        System.out.println(run);
        }
}

    