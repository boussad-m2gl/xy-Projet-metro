package TestPackV2;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.ClavierImpl;

/**
 * Test du Clavier 
 * */
public class ClavierTest {
	
  public ClavierTest(){};
	
  @Test
  public void testTouchPressed(){
	
	  
	  ClavierImpl cl = new ClavierImpl();
	  
	  // Button start
	  
	  cl.setTouche(ClavierImpl.BTNSTART);
	  assertTrue(cl.touchePresse(ClavierImpl.BTNSTART));
	  cl.resetTouche(ClavierImpl.BTNSTART);
	  assertFalse(cl.touchePresse(ClavierImpl.BTNSTART));
	  
	  //  Button stop
	  
	  cl.setTouche(ClavierImpl.BTNSTOP);
	  assertTrue(cl.touchePresse(ClavierImpl.BTNSTOP));
	  cl.resetTouche(ClavierImpl.BTNSTOP);
	  assertFalse(cl.touchePresse(ClavierImpl.BTNSTOP));
	  
  }
  
  
}
