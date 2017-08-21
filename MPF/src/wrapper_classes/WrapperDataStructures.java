package wrapper_classes;

import java.util.HashSet;
import java.util.Iterator;
/**
 * 
 * @author Simoen Arabov
 * This class encapsulates all data structures needed in the computation of MPF
 *
 */

public class WrapperDataStructures {

	public int n;
	public HashSet<Integer> pp;
	public HashSet<Integer> sp;
	public WrapperPair[] mp;
	public WrapperSet [] mpl;
	public WrapperSet[] u;
	
	
	public WrapperDataStructures(int n){
		this.n=n;
		pp = new  HashSet<Integer>();
		sp = new  HashSet<Integer>();
		mp = new WrapperPair[n];
		mpl = new WrapperSet[n];
		u = new WrapperSet[n];
	
	
		for (int i =0;i<n;i++){
			mp[i] = new WrapperPair();
			mpl[i] = new WrapperSet();
			u[i] = new WrapperSet();
		}
	}
	
	public void toString1(){
		
		
		Iterator<Integer> temp ;
		
			 temp = pp.iterator();
			 System.out.println("List of PP");
			while(temp.hasNext()){
				System.out.println(temp.next().toString());
			}		
		
			System.out.println("List of SP");
			temp = sp.iterator();
			while(temp.hasNext()){
				System.out.println(temp.next().toString());
			}
			
			
			Iterator<Integer> temp2;
		for(int i=0;i<n;i++){
			System.out.print("MP["+i+"]:");
			System.out.print(mp[i].toString());
			System.out.println();
		}
		System.out.println("MPL:");
		for (int i=0;i<n;i++){
		temp2 = mpl[i].iterator();
		System.out.print("MPL["+i+"]: ");
		if (!temp2.hasNext())System.out.print("-");
		else{while(temp2.hasNext()){
			System.out.print(temp2.next().toString()+",");
		}}
		System.out.println();

		
	}
		System.out.println("U:");
		for(int i = 0;i<n;i++){
			System.out.print("U["+i+"]: ");
		temp2 = u[i].iterator();
		if (!temp2.hasNext())System.out.print("-");
		else{while(temp2.hasNext()){
			System.out.print(""+temp2.next().toString()+",");
		}}System.out.println();
	}
	
	}}
