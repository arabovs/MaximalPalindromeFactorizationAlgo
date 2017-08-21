import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import wrapper_classes.Palindrome;
import wrapper_classes.WrapperDataStructures;
import wrapper_classes.WrapperPair;
import wrapper_classes.MyGraph;
/**
 * 
 * @author Simeon Arabov KCL 2017
 * This class executes sequentially the following computations:
 * 1. Prompt for input
 * 2. Validate input
 * 3. preprocess Manacher's Alogrithm char[]
 * 4. get elements of MP
 * 5. get elements of PP and SP
 * 6. get elements of MPL
 * 7. get elements of U
 * 8. construct graph G
 * 9. perform Shortest Path Algorithm
 *
 */
public class Algo {

	private static   int[] p;
	private static    String s;
	private  char[] t;
	private static  int n;
	private static WrapperDataStructures dataStructs;
	private static final Pattern pattern = Pattern.compile("^[a-zA-z0-9]*$");
	//test functions for memory footprint
	 private static final long MEGABYTE = 1024L * 1024L;
	 public static long bytesToMegabytes(long bytes) {
	    return bytes / MEGABYTE;
	  }
	
	 //main function
	public static void main(String[] args) {

		final long startTime = System.nanoTime();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		Algo algo = null;
		boolean promptUser = true;
		
		do{
			System.out.println("Enter a string: ");
	    	s = reader.nextLine();
	    	if(s.isEmpty()||!pattern.matcher( s ).matches())promptUser=true;
	    	else {algo = new Algo(s);
	    	printConsole();
	    	promptUser = false;
	    	}
		}
		while(promptUser);
		
	    
		
      
        algo.longestPalindromicSubstring();
        final long duration = System.nanoTime() - startTime;
        printConsole();
         dataStructs.toString1();
       //  MyGraph.printer();
        System.out.println("Run-time duration in seconds: "+(double)duration/1000000000);
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
            + bytesToMegabytes(memory));
        System.out.println("S Length : " +s.length());
       // System.out.println("S bytes : " + sz.getBytes());
        final byte[] utf16Bytes= s.getBytes();
        System.out.println("String in bytes: " + utf16Bytes.length);
	}
	
	public Algo(String s){

		//Initialise Stuff		
		Algo.s = s;
		Algo.n = s.length();
		dataStructs = new WrapperDataStructures(n);
	

		
        

		preprocess(); //O(n)
		p = new int[t.length];

		
		int center = 0, right = 0;
		for (int i = 1; i< t.length -1;i++){ 
			int mirror = 2*center - i;
			
			if(right > i)
				p[i] = Math.min(right - i, p[mirror]);
			
			
			while (t[i+ (1+p[i])] == t[i-(1+p[i])])
				p[i]++;
				
			
			if(i + p[i] > right){
				center = i;
				right = i + p[i];
			}			
		}	
		//GET SETS  and build graph
		getMPandMPL();
		getU();
		createGraph();
		//printConsole();
	
	}
	
	//preprocess stirng for Manacher's algorithm
	private void preprocess(){
		
		t = new char[s.length()*2 + 3];
		t[0] = '$'; 
		t[s.length()*2 +2]= '@'; 
		for (int i = 0; i<s.length();i++){  
			t[2*i + 1] = '#';
			t[2*i + 2] = s.charAt(i);
		}
		t[s.length()*2 + 1] = '#';
	} 
	
	
	//get longest palindromic substring of the input
	
	public String longestPalindromicSubstring(){
		int length = 0;
		int center = 0;
		for (int i = 1; i<p.length-1; i++){
			if(p[i]>length){
				length = p[i];
				center = i;
			}
		}
		return s.substring((center -1 - length)/2, (center - 1 + length)/2);
	}
	
	//get longest palindromic substring at position i
	public static String longestPalindromicSubstring(int i){
        int length = p[i + 2];       
        int center = i + 2;       
        String temp = s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
        return temp;
	}
	
	//print data to console
	public static void printConsole(){
		
        for (int i =0;i<2*n;i++){ 
        //	FileReadWrite.writeFile(i +" :" + Algo.longestPalindromicSubstring(i));
        	System.out.println(i +" :" + Algo.longestPalindromicSubstring(i));
        }	
        
        
	}
	
	//get sets MP and MPL
	public void getMPandMPL(){
		int center =0 ;
		
		Palindrome temp1;
		Palindrome temp2;
		WrapperPair p;
		for (int i =0;i<(2*n)-1;i++){
			temp1 = new Palindrome(longestPalindromicSubstring(i),center+1);
			temp2 = new Palindrome(longestPalindromicSubstring(i+1),center+1);
			p = new WrapperPair();
			isPPandisSP(temp1);
			isPPandisSP(temp2);
			
			if( (i==0 ||i%2==0)){

				if(temp1.getLength() >temp2.getLength()){
					if(temp2.getLength() == 2){p.addPal(temp2);}//THIS IS THE PART WHERE IT CAPTURE PALS OF LENGTH AT CENTER I
					if(temp1.getLength() >= 1){p.addPal(temp1);}
				}
				
				if((temp2.getLength()%2==0)&&(temp1.getLength() < temp2.getLength())){
					p.addPal(temp2);
				}
				
				if(temp1 !=null || temp2 != null){
				if(temp1!=null) {
					if(i!=0 && i!=n-1){
						if(temp1.getLength()>1)dataStructs.mpl[temp1.y-1].add(temp1.getLength());
					}else{dataStructs.mpl[temp1.y-1].add(temp1.getLength());}
				}
				
				if(temp2!=null) {
					if(i!=0 && i!=n-1){
						if(temp2.getLength()>1)dataStructs.mpl[temp2.y-1].add(temp2.getLength());
						}//else{mpl[temp2.y-1].add(temp2.n);} // for further analysis 
				}

				dataStructs.mp[center] = p;
				center++;
				}
			}
		}
		dataStructs.mpl[n-1].add(1);
	}
	
	//get set U
	public void getU(){
		
		for(int i=0;i<n;i++){
			Iterator<Integer> temp = dataStructs.mpl[i].iterator();
			while(temp.hasNext()){
				dataStructs.u[i].add((i+1)-temp.next());
			}
		}}
	
	//get sets PP and SP
	private void isPPandisSP(Palindrome palindrome){
		if(palindrome.x==1&&palindrome.getLength()!=0)	dataStructs.pp.add(palindrome.getLength());
		if(palindrome.y==n&&palindrome.getLength()!=0)	dataStructs.sp.add(palindrome.getLength());
	}
	
	//construct graph
public void createGraph(){
	
		if(s.equals(new StringBuilder(s).reverse().toString()))System.out.println("MPF: "+n +">>" + 1);
		else{MyGraph graph = new MyGraph(n);

				
			for (int i = n-1;i>=0;i--){			
				
				Iterator<Integer> iter = dataStructs.u[i].iterator();	
			
					while(iter.hasNext()){
						graph.addEdge(i,iter.next());
					} 					
				}
			HashSet<Integer> hash = new HashSet<Integer>();
	
			ArrayList<Integer> mpfset = new ArrayList<Integer>();
			System.out.println("SET MPF");
				int temp=0;
				for(int i =n-1;i>=0;i--){
				hash = graph.BFS(i);
				temp = Collections.min(hash);
				if(!hash.isEmpty())mpfset.add(temp);
				else {mpfset.add(i);
				i = temp;}
				}
			//	if(!hash.isEmpty())temp = Collections.min(hash)+1;
				//else temp = i-1;
				
			//	if(!mpfset.contains(temp))mpfset.add(temp);
				

			
		}
		

}
}