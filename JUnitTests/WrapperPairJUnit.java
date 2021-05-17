package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import wrapper_classes.Palindrome;
import wrapper_classes.WrapperPair;

public class WrapperPairJUnit extends WrapperPair {

	protected Palindrome x;
	protected Palindrome y;
	protected WrapperPair pair;
	
	protected void setUp(){
		x = new Palindrome("aba",4);
		y = new Palindrome("abba",8);
		
	}
	
	public void testPair(){
		pair = new WrapperPair();
		pair.addPal(x);
		pair.addPal(y);
		assertEquals(x.s,pair.getPal1().s);
		assertEquals(y.s,pair.getPal2().s);
	}
}
