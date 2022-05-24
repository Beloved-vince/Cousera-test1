
/**
 * Write a description of BabyBirth2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.File;
import edu.duke.*;
import org.apache.commons.csv.*;
public class BabyBirth2 {
public void totalBirths(CSVParser parser) {
        int totalboy = 0;
        int totalgirl = 0;
        int total = 0;
        int totaluniqueboy = 0;
        int totaluniquegirl = 0;
        int totalunique = 0;
        for (CSVRecord record: parser) {
            if (record.get(1).equals("F")) {
                totalgirl = totalgirl + Integer.parseInt(record.get(2));
                totaluniquegirl = totaluniquegirl + 1;
                totalunique = totalunique + 1;
            }
            if (record.get(1).equals("M")) {
                totalboy = totalboy + Integer.parseInt(record.get(2));
                totaluniqueboy = totaluniqueboy + 1;
                totalunique = totalunique + 1;
            }
            total = totalboy+totalgirl;
        }
        System.out.println("Total number boy: "+totalboy);
        System.out.println("Total number girl: "+totalgirl);
        System.out.println("Total number: "+total);
        System.out.println("Total unique number boy: "+totaluniqueboy);
        System.out.println("Total unique number girl: "+totaluniquegirl);
        System.out.println("Total unique number: "+totalunique);
    }
public void testtotalBirths() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        totalBirths(parser);
    }
 public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        int number = 0;
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                rank = rank + 1;
                if (record.get(0).equals(name)) {
                    number = 1;
                    break;
                }
            }
        }
        if (number == 1) return rank;
        else return -1;
    }
    
    public void testgetRank() {
        int rank = getRank(1971, "Frank", "M");
        System.out.println(rank);
      
    }
 
 public void whatisNameInYear(String name, int year, int newyear, String gender) {
        String nameyear = "yob" + year + "short.csv";
        FileResource fr = new FileResource();
        CSVParser parserold = fr.getCSVParser(false);
        
        String namenewyear = "yob" + newyear + "short.csv";
        FileResource fr1 = new FileResource();
        CSVParser parsernew = fr1.getCSVParser(false);
        
        int rank = 0;
        int find = 0;
        for (CSVRecord record: parserold) {
            if (record.get(1).equals(gender)) {
                rank += 1;
                if (record.get(0).equals(name)) {
                    find = 1;
                    break;
                }
            }
        }
        
        int ranknew = 0;
        int findnew = 0;
        if (find == 0) System.out.println("NO NAME!") ;
        else {
            for (CSVRecord record: parsernew) {
                if (record.get(1).equals(gender)) {
                    ranknew += 1;
                    if (ranknew == rank) {
                        findnew = 1;
                        System.out.println(name + " born in " + year + " would be " + record.get(0) + " if she/he was born in "+ newyear);
                    }
                    
                }
            }
            if (findnew == 0) System.out.println("No such rank in year "+newyear);
        }
    }
    
    public void testwhatisNameInYear() {
        whatisNameInYear("Susan", 1974, 2014, "F");
    }
  public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
       FileResource fr = new FileResource();
        int ranktonow = 0;
        int findall = 0;
       for( File f : dr.selectedFiles()){
            int rank = 0;
            int find = 0;
            String fname = f.getName();
            CSVParser parser = fr.getCSVParser(false);
            for (CSVRecord record: parser) {
                if (record.get(1).equals(gender)) {
                    rank += 1;
                    if (record.get(0).equals(name)) {
                        find = 1;
                        break;
                    }
                }
            }
            if (find == 1) {
                findall = 1;
                if (ranktonow == 0) ranktonow = rank;
                else if (ranktonow > rank) ranktonow = rank;
            }
             
        }
        
        if (findall == 0) return -1;
        else return ranktonow;
    }
    
    public void testyearOfHighestRank() {
        int ranktonow = yearOfHighestRank("Mason", "M");
        System.out.println("Highest rank is "+ranktonow);
    }
 public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double ranktonow = 0;
        int findall = 0;
        for (File f: dr.selectedFiles()) {
            int rank = 0;
            int find = 0;
            String fname = f.getName();
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser(false);
            for (CSVRecord record: parser) {
                if (record.get(1).equals(gender)) {
                    rank += 1;
                    if (record.get(0).equals(name)) {
                        find = 1;
                        break;
                    }
                }
            }
            if (find == 1) {
                findall += 1;
                ranktonow += rank;
            }
             
        }
        
        if (findall == 0) return -1;
        else return ranktonow/findall;
    }
    
    public void testgetAverageRank() {
        double average = getAverageRank("Jacob", "M");
        System.out.println("Average rank is "+average);
    }

 public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        String nameyear = "yob" + year + "short.csv";
        DirectoryResource dr =  new DirectoryResource();
        int find = 0;
        int sum = 0;
        int rank =0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record: parser) {
            if (record.get(1).equals(gender)) {
                rank = rank +1;
                if (record.get(0).equals(name)) {
                    find = 1;
                    break;
                }
                sum += Integer.parseInt(record.get(2));
            }
        }}
        if (find == 1) return sum;
        else return -1;
    }
    
    public void testgetTotalBirthsRankedHigher() {
        int sum = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        System.out.println("The total briths higher is "+sum);
    }}



