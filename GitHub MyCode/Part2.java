package StringsSecondAssignments;


public class Part2 {
public int howMany(String a ,String b) {
		//set counter to 0
//		boolean counter;
		// find the index of a in the longer string of b
	int counter = 0;
		int first = b.indexOf(a);
		// As long  as there is String b and a that means  first not equal to -1
	while (first != -1) {
		counter++;
		b =  b.substring(first +1); 
			first = b.indexOf(a);	
		}
		return counter;	
	}
	public void testHowMany() {
	    String a ="GAA";
	    String b ="“ATGAACGAATTGAATC";
	    System.out.println(howMany(a,b));
	    a= "What the fuck";
	    b="What the fuck is the question you are askin me";
	    int c = howMany(a,b);
	    System.out.println(c);
   	    System.out.println("Test Succeded moving to the next Assignment");
	}
	public int countGene(String dna) {
		int count = 0;
		int startIndex = dna.indexOf("ATG");
		while (startIndex != -1) {
			// find the multiple of the startIndex if multiple of three
		//	count++;
		//		int currIndex =countGene("TAA");
		///		currIndex =countGene("TAG");
		///		currIndex =countGene("TAC");
		////		int temp = Math.min("TAA", "TAG");
		///		dna = dna.substring(currIndex ,startIndex +3);
		//		startIndex = dna.indexOf("ATG" , currIndex);
	//		int codon = startIndex - currIndex;
		//	if(codon % 3 == 0) {
				//return count;
		//	}
		//}
	//	return 0;
			dna = dna.substring(startIndex +1);
			startIndex = dna.indexOf("ATG");
		
		}
	//public void testCountGene() {
		return count;
		
	}
	
}