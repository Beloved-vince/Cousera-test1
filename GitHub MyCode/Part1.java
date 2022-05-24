 


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part1 {
     public int findStopCodon(String dna, int startIndex , String stopCodon){
            int currIndex = dna.indexOf( stopCodon, startIndex +3 );
            
            while(currIndex != -1){
            if( (currIndex-startIndex) % 3==0 ){
                return currIndex;           }
            else {
                currIndex = dna.indexOf(stopCodon , currIndex +1);
            }
            }
            currIndex = dna.indexOf(stopCodon, startIndex +3);
         
            return dna.length();
            }
    
     public void testFindStopCodon() {
         
         //            01234567891011
     String dna = "ACTTTTTAAATGTGAAACCCTTTTAA";
        int gene = findStopCodon(dna ,0 , "TAA");
        //  print gene
        if (gene !=6){ System.out.println("erroe");
        }
        System.out.println(gene);
        
     }
     public String findGene(String dna) {
         int startIndex = dna.indexOf("ATG");
         if (startIndex == -1) {
             return "Empty";
         }
         
         int taaIndex = findStopCodon(dna, startIndex, "TAA");
         int tagIndex = findStopCodon(dna, startIndex, "TAG");
         int tgaIndex = findStopCodon(dna, startIndex, "TAC");
         
         int temp = Math.min(taaIndex , tagIndex);
          int parm = Math.min(temp, tgaIndex);
          if(parm == dna.length()) {
              return "No gene found";
          }
         return dna.substring(startIndex, parm +3);

           }
     
     public void testFindGene() {
         //     DNA WITH no ATG BUT WITH A STOP CODON
         String dna = "ACTTAACATTTAA";
         dna = findGene(dna);
         System.out.println(dna);
         // return empty
         // dna with ATG an a valid stop Codon
         dna = "ATGAAATTTTAA";
         dna= findGene(dna);
         System.out.println(dna);
         // return valid
         //DNA with ATG an multiple stop codon
         dna = "ATGCCTCCAAATTAATAGAATTAC";
         dna = findGene(dna);
         System.out.println(dna);
         // DNA with ATG and no valid sopCodon
         dna = "ATGCCTTATTATAATACTAG";
         dna = findGene(dna);
         System.out.println(dna);
         
     }
     public String multipleGene(String dna){
         int startIndex = dna.indexOf("ATG");
       if(startIndex ==-1){
        return "Invalid gene";}
        int taaIndex = findStopCodon(dna , startIndex, "TAA");                
       int tagIndex = findStopCodon(dna , startIndex, "TAG");
       int tgaIndex = findStopCodon(dna, startIndex, "TGA");
      /* int tempM = Math.min(taaIndex,tagIndex);
       int parmM = Math.min(tempM,tgaIndex);*/
       int parmM = 0;
       if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)){
       parmM = tagIndex;
    }
    else{
    parmM = taaIndex;
    }
    if(parmM== -1 ||(tagIndex != -1 && tgaIndex < parmM )){
        parmM = tgaIndex;
    }
    if(parmM == -1){
        return "";
       }
       return dna.substring(startIndex , parmM +3);
        }
    public void prrintAllGenes(){
        String dna= "ATGTAATAGTGA"; 
     
        while (true) {
            System.out.println("printing genes" + multipleGene(dna));
            if (multipleGene(dna).length() == -1) {
                System.out.println("Invalid");
            }
    }
}}


