package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import wrapper_classes.Palindrome;

public class PalindromeJUnit extends Palindrome{

	protected String string;
	protected int center;
	
	
	protected void setUp(){
		string = "abbabba";
		center = 12;
	}
	
	@Test
	public void testPalindromeCenter(){
		
		setUp();
		Palindrome x = new Palindrome(string,center);
		assertEquals(12,x.center);
		assertEquals("abbabba",x.s);
		assertEquals(4,x.getRadius());
	//	x.setXY();
	//	assertEquals(9,x.x);
	//	assertEquals(15,x.y);
		
	}

	
	

}
