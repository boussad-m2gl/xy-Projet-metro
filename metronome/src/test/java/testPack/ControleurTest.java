package testPack;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import model.MMImpl;
import observer.Observer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import presentation.Config;
import presentation.IHM;
import presentation.IIHM;
import controleur.Controleur;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControleurTest {

	 
    private  Controleur c;
	
	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public ControleurTest() {
		c = new Controleur(new IHM());
	}
	

	/* 
	 * Test   la method getNextTempParMesure 
	 * */
	@Test
	public void testgetNextTParM(){
		
	     int maxTParM = Config.MaxTempParMesure; // 2
		 int minTParM = Config.MinTempParMesure; // 7
		 
		 int INC = 1;
	     int DEC = 2;
         
	  
		 //test with INC
         assertEquals(minTParM +1,c.getNextTParM(minTParM , INC));
         assertEquals(minTParM,c.getNextTParM(maxTParM , INC)); 
         
         //test with DEC
         
         assertEquals(minTParM, c.getNextTParM(minTParM, DEC));
         assertEquals(maxTParM -1, c.getNextTParM(maxTParM,DEC));
	}
   
	/*
	 * Test la liste des observateurs
	 * */
	@Test 
	public void testobsControlleur(){
		
		assertEquals(c.getObsControlleur().size(), 3);  // moteur + horloge + ihm
		
		
		Observer  o = new Obs();
		c.register(o);
		assertEquals(c.getObsControlleur().size(),4);
		c.unregister(o);
		assertEquals(c.getObsControlleur().size(),3);
	}
	
	/*
	 * Test la method de notification des observateurs
	 * */
	@Test
	public void testNotifierObservers(){
		
		Obs mockedObs = mock(Obs.class);
		Collection<Observer> listObs  = new ArrayList<Observer>();
		listObs.add(mockedObs);
		c.setObsControlleur(listObs);
		c.notifyObservers();
		verify(mockedObs).update();
	}
	
   /*
    * Test que la notification des observateurs 
    *  
    * */	
   public void testIncDecCallToObservers(){
	   // IIHM  ihmInterface, MMImpl mot
	   IIHM mockedihm = mock(IIHM.class);
	   MMImpl mockedmoteur = mock(MMImpl.class);
	   Controleur c = new Controleur(mockedihm, mockedmoteur);
	   when(mockedmoteur.getEnMarche()).thenReturn(true);
       	   
	   // set les observateurs :
	   
		Obs mockedObs = mock(Obs.class);
		Collection<Observer> listObs  = new ArrayList<Observer>();
		listObs.add(mockedObs);
		c.setObsControlleur(listObs);
		
		c.inc(); // c.dec();
		
	    verify(mockedObs).update();
   }
	
	
	// Inner class for testing
	
	class Obs implements Observer {
		public void update() {			
		}
	}
	
}
