
/**
 * Write a description of Csv2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Csv2 {
  
    public void countryInfo(CSVParser parser, String country){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        for(CSVRecord record: parser){
        String info = record.get("Exports");
        if(info.contains(record.get(country))){
            country = record.get("Country");
        System.out.println(country);
        }

    }
        
    }
    
   
 public void run(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    countryInfo(parser , "Rwanda");
    }
}
