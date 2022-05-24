
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
public int [] countWordLengths(FileResource resource, int []  counts) {
        for (String word: resource.words()) {
            int n = word.length();
            int len = 0;
            for (int i = 0; i < n; i++) {
                if (Character.isLetter(word.charAt(i))) len += 1;
            }
            if (len <= counts.length & len != 0) counts[len-1] += 1;
            else System.out.println("The length of ARRAY counts is not enough!");
        }
        return counts;
    }

public void testcountWordLengths() {
        FileResource resource = new FileResource();
        int [] counts = new int[31];
        int [] result = countWordLengths(resource, counts);
        for (int i = 0; i < 31; i++) {
            System.out.println(result[i] + " words of length "+ (i+1));
        }
        System.out.println("The most common word length in the file is " + result.toString());
    }
public int indexofMax(int [] values) {
        int maxvalue = 0;
        int position = 0;
        for (int i = 0; i < values.length; i++) {
            if (maxvalue == 0) maxvalue = values[i];
            else {
                if (maxvalue < values[i]) {
                    maxvalue = values[i];
                    position = i;
                }
            }
        }
        return position+1;
    }

}
    
    
    
