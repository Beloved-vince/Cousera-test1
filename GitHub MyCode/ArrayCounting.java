
/**
 * Write a description of ArrayCounting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class ArrayCounting {
    public String [] getCommon(){
    FileResource fr = new FileResource();
    String [] common = new String[20];
    int index = 0;
    for(String s : fr.words()){
    common[index]= s;
    index++;
    
    }
    /**the
of
and
to
a
in
for
is
on
that
by
this
with
if
you
it
not
or
be
are **/
        return common; 
    }
    
    public void countShakespare(){
   String play [] ={"ceaser.txt", "errors.txt", "hamlet.t.xt", "likeit.txt",
       "macbeth.txt", "romeo.txt"};
       String[] common = getCommon();
       int[] count = new int[common.length];
       for(int k =0; k<play.length; k++){
        FileResource fr = new FileResource("data" + play[k]);
        System.out.println("done with " + play[k]);
        
        }
        for (int k =0; k<common.length; k++){
        System.out.println("common words " + common[k] + count[k]);
        }
    }
    public void random(String len){
        
    for (int k=0; k < len.length; k++ ){
    
    }
    }
}
