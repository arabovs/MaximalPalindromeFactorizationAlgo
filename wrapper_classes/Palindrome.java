package wrapper_classes;


/**
 * 
 * @author Simeon Arabov
 * simple class to represent a palindromic substring. It stores the value of the string, and center.
 * The constructor computes the start position in x and the ending position y.
 * Includes function for obtaining the values of the instance fields and get radius
 */
public class Palindrome {

	public String s;
	public int center;
	public int radius;
	public int x;
	public int y;
	public int l;
	
	public Palindrome() {}
	
	public Palindrome(String s, int center){		
		this.s = s;		
		this.center = center;		
		setXY();
	}

	public int getLength(){return s.length();}
	public int getRadius(){
		if(s.length() %2 == 0) {
			this.radius = s.length()/2;
			this.l = (s.length()/2) + 1;
			
		}else{ 
			this.radius = (s.length()/2) + 1;
			this.l = s.length()/2;
		}return radius;
	}

	public void setXY(){
		int temp = s.length()/2;
		if(s.length() %2 == 0){
			this.x = center - (temp-1);
			this.y = center + temp;
		}else{
			this.x = center - temp;
			this.y = center + temp;	
		}
		
	}

	public String toString(){
		return "("+x+","+y+")";
	}
	

	public static void main(String args[]){
		Palindrome x = new Palindrome("ababa",3);
		
				System.out.println(x);
		
	}
	

	
	
}
