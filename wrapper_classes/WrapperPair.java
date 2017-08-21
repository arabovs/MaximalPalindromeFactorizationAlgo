package wrapper_classes;


/**
 * 
 * @author Simeon Arabov
 * A simple implementation of a Pair class of type Palindrome
 *
 */
public class WrapperPair {

	Palindrome pal1 ;
	Palindrome pal2 ;
	
	public WrapperPair(){
		pal1 = null;
		pal2 = null;
	}
	
	public void addPal(Palindrome x){
		if(pal1==null) pal1 = x;
		else pal2 = x;			
	}
	
	public Palindrome getPal1(){
		return pal1;
	}
	
	public Palindrome getPal2(){
		return pal2;
	}
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("("+ pal1.center + " , " + pal1.getLength() + ")  ");
		if(pal2 != null){
			sb.append("("+ pal2.center + " , " + pal2.getLength() + ")");
		}
		return sb.toString();
	}
}
