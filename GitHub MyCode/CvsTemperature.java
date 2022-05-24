/**
 * Write a description of CvsTemperature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CvsTemperature {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestTemp = null;
        for(CSVRecord currRow : parser){
            if(coldestTemp == null){
            coldestTemp = currRow;
            }
            
            else{
            double lowTemp = Double.parseDouble(currRow.get("TemperatureF"));
            double higherTemp = Double.parseDouble(coldestTemp.get("TemperatureF"));
            if(lowTemp<higherTemp){
                coldestTemp = currRow;
            }
            
            }
        }
        return coldestTemp;       
    }
    
    public void  testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest =  coldestHourInFile(fr.getCSVParser());
        System.out.println("The coldest hour temperature in weather report in the:" + coldest.get("TemperatureF") + "Time" );
    
    }
    public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestFile = null;
        String fileName = null;
        for(File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);

            CSVRecord currFile = coldestHourInFile( fr.getCSVParser());
        if(coldestFile == null){
            coldestFile = currFile;
            }
            else{
            double colderTemp = Double.parseDouble(currFile.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestFile.get("TemperatureF"));
            if(colderTemp< coldestTemp && colderTemp > -50){
            coldestFile = currFile;
            fileName = f.getAbsolutePath();
            }
        }
        }
            return fileName;
    }

    public void testFileWithColdestTemperature(){
   String file = fileWithColdestTemperature();
    File f = new File(file);
    String fileName = f.getName();
    System.out.println("coldest day was in file :" + fileName);
    FileResource fr = new FileResource(fileWithColdestTemperature());
    CSVParser parser = fr.getCSVParser();
    CSVRecord coldestTemp = coldestHourInFile(parser);
    System.out.println("Coldest temperature on that day was :" + coldestTemp.get("TemperatureF"));
    System.out.println("All the Temperatures on the coldest day were");
    CSVParser parser2 = fr.getCSVParser();
    for (CSVRecord record : fr.getCSVParser()){
       double temp = Double.parseDouble(record.get("TemperatureF"));
       
       System.out.println("Temperature" + " "+ "Time");
       System.out.println(temp+"        "+ record.get("TimeEST"));
			
}
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
    CSVRecord lowestHumidity = null;
    int count = 0;
        for(CSVRecord currHumidity : parser){
            if(lowestHumidity == null){
                lowestHumidity = currHumidity;
            }
            else{
                if(currHumidity.get("Humidity") != "N/A" && lowestHumidity.get("Humidity") != "N/A"){
                int humidity = Integer.parseInt(currHumidity.get("Humidity"));
                int lowest = Integer.parseInt(lowestHumidity.get("Humidity"));
                if(humidity < lowest){
                   
                    lowestHumidity = currHumidity;
                }
            }
            else{
                lowestHumidity = currHumidity;
            }
            }
     
        }
        return lowestHumidity;
    }
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
    System.out.println("The lowest humidity was :" + csv.get("Humidity")  +" " + "In :" + csv.get("DateUTC"));
    }
    
     public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestFile = null;
        for(File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);
            CSVRecord currFile = lowestHumidityInFile( fr.getCSVParser());
        if(lowestFile == null){
            lowestFile = currFile;
            }
            else{
                if(currFile.get("Humidity") != "N/A" && lowestFile.get("Humidity") != "N/A"){
            int lowerHum = Integer.parseInt(currFile.get("Humidity"));
            int lowestHum = Integer.parseInt(lowestFile.get("Humidity"));
            if(lowerHum < lowestHum){
            lowestFile = currFile;
            }}
        }
        }
            return lowestFile;
    }
    public void testLowestHumidityInManyFile(){
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println(record.get("Humidity") + record.get("DateUTC"));
    }

 public void testAverageTemperatureInFile(){
    FileResource fr = new FileResource(fileWithColdestTemperature());
    CSVParser parser = fr.getCSVParser();
    CSVRecord coldestTemp = coldestHourInFile(parser);
    System.out.println("Coldest temperature on that day was :" + coldestTemp.get("TemperatureF"));
    System.out.println("All the Temperatures on the coldest day were");
    CSVParser parser2 = fr.getCSVParser();
    double count=0.0;
    double temp = 0.0;
    double sum = 0.0;
    for (CSVRecord record : fr.getCSVParser()){
        count++;
        temp = Double.parseDouble(record.get("TemperatureF"));
        sum += temp;
       System.out.println("Temperature" + " "+ "Time");
       System.out.println(sum);			
    }
        
System.out.println(sum/count);
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
            double sum = 0.0;
            double average = 0.0;
             double num =0.0;
          for(CSVRecord record : parser){
       int hum = Integer.parseInt(record.get("Humidity"));
        double temp = Double.parseDouble(record.get("TemperatureF"));
       if(hum >= value){ 
           sum += temp;
           num ++;
        }    
                 }
       average = sum/num;
        return average;
}

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double record =  averageTemperatureWithHighHumidityInFile(parser, 80);
        if(!Double.isNaN(record)) {
			System.out.println("average temperature is " + record);
		} else {
			System.out.println("No Temperature was found");
		}
	}
    }
