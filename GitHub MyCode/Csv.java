import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of Csv here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Csv {
    public void tester( CSVParser parser, String exportsOfInterest ){

    for(CSVRecord record : parser){
    // lokk for the country that export
        String export = record.get("Exports");
       
        if(export.contains(exportsOfInterest)){
        String country = record.get("Country");
        System.out.println(country);
        }
    }
    }
    public void countryInfo(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        tester(parser , "Peru");
    }
    public void countryInfo(CSVParser parser, String country){
        FileResource fr = new FileResource();
         parser= fr.getCSVParser();
         int exit=0;
         for(CSVRecord record : parser){
             String export = record.get("Exports");
             String value = record.get("Value (dollars)");
             if(record.get("Country").equals(country)){
             System.out.println(record.get("Country") + ": " +export + ": " + value);
             exit =1;
            }
            }
            if(exit == 0) System.out.println("VOID");
    }
    public void run(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser,"Nauru");
        countryInfo(parser, "Nigeria");
        countryInfo(parser, "United States");
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
    FileResource fr = new FileResource();
     parser = fr.getCSVParser();
    for(CSVRecord record : parser){
    String export1 = record.get("Exports");
    String export2 = record.get("Exports");
    if(export1.contains(exportItem1) && export2.contains(exportItem2)){
        
        System.out.println(record.get("Country"));
    }
    }
    }
    public void testRun(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamond");
    }
    
    public void numberOfExporters(CSVParser parser, String exportItem){
    FileResource fr =new FileResource();
    parser = fr.getCSVParser();
    int count = 0;
    for(CSVRecord record : parser){
        String export = record.get("Exports");
        if(export.contains(exportItem)) {
          String country = record.get("Country");
        System.out.println(country);
         count=count +1;
    }
    }
    System.out.println();
    System.out.println("country that export "+ exportItem +" "+count);
    }
    
    public void getTotal(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    numberOfExporters(parser, "gold");
    }
    
    public void bigExporters(CSVParser parser, String amount){
    FileResource fr = new FileResource();
    parser = fr.getCSVParser();
     int eight = 0;
     for(CSVRecord record : parser){
        String value =record.get("Value (dollars)");

        if(value.length() > amount.length()){
            String country = record.get("Country");
            System.out.println(country + value );
            }
            
        }
    }
    
    public void testBigExporter(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    
    bigExporters(parser, "$999,999,999,999");
    }
}