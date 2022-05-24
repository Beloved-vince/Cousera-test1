/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import java.io.File;
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
	public void printNames () {
		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}

	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
	}
	public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int ranktonow = 0;
        int findall = 0;
       for(File f : dr.selectedFiles()){
            int rank = 0;
            int find = 0;
            String fname = f.getName();
            FileResource fr = new FileResource(fname);
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
    }}

