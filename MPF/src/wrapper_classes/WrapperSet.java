package wrapper_classes;

import java.util.HashSet;
import java.util.Iterator;

public class WrapperSet  {

	public HashSet<Integer> set;
	
	public WrapperSet(){
		set = new HashSet<Integer>();
	}
	
	public void add(int i){set.add(i);}
	public void clear(){set.clear();}
	public boolean contains(int i){return set.contains(i);}
	public boolean isEmpty(){return set.isEmpty();}
	public Iterator<Integer> iterator(){return set.iterator();}
	public int size(){return set.size();}
	public void remove(int i){set.remove(i);}
	public String toString(){
		return "Yeah baby";
	}
	
	
	public static void main(String args[]){
		
		WrapperSet set = new WrapperSet();
		set.add(2);
		set.add(4);
		
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()){
			System.out.println("Value:" + iterator.next() +" ");
		}
		
		HashSet<WrapperSet> set2 = new HashSet<WrapperSet>();
		set2.add(new WrapperSet());
		set2.add(new WrapperSet());
		
		Iterator<WrapperSet> iterator2 = set2.iterator();
		while(iterator2.hasNext()){
			System.out.println("Accessed??" + iterator2.next());
		}
		
	}
}
