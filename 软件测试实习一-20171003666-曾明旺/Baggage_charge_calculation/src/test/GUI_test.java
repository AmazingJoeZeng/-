package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GUI.HomePage;

public class GUI_test {
	
	private HomePage homepage;

	@Before
	public void setUp() throws Exception {
		homepage=new HomePage();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testget_free_domestic() {
		int[] result=homepage.get_free_domestic();
		int[] expect= {40,30};
		assertEquals(expect, result);
	}
	
	@Test
	public void testget_free_abroad() {
		int[] result=homepage.get_free_abroad();
		int[] expect= {32,32};
		assertEquals(expect,result);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
