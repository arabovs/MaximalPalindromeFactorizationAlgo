package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import wrapper_classes.WrapperSet;

public class WrapperSetJUnit extends WrapperSet {

	protected int x;
	protected int z;
	protected int i;
	protected int n;
	
	protected void setUp(){
		x = 2;
		z = 20;
		i = 0;
		n = 215;
	}
	
	
	@Test
	public void checkWrapperSet2(){
		setUp();
		WrapperSet set = new WrapperSet();
		assertTrue(set.isEmpty());
		set.add(0);
		set.add(0);
		assertEquals(1,set.size());
	}
	
	@Test
	public void checkWrapperSet(){
		setUp();
		WrapperSet set = new WrapperSet();
		assertTrue(set.isEmpty());
		set.add(20);
		set.add(0);
		set.add(215);
		
		assertTrue(set.contains(20));
		assertTrue(set.contains(0));
		assertTrue(set.contains(215));
		assertFalse(set.isEmpty());
	}
}
