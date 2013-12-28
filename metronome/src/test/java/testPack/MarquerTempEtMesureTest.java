package testPack;



import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.runners.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import command.MarquerMesure;
import command.MarquerTemps;

import controleur.Controleur;


/**
 * Verifier l'interaction entre les commandes marquer temps et marquer mesure
 *  Avec le controleur
 * */
@RunWith(MockitoJUnitRunner.class)
public class MarquerTempEtMesureTest {
	
	
	// On creer les deux command et on verifie leur interaction avec le gestionnaire d'evenement
	@Mock
	private Controleur c1;
	
	
	
	private MarquerTemps marquertemps;
	private MarquerMesure marquermesures;
	
	
	public MarquerTempEtMesureTest(){
	}
    @Before
	public void setUp(){
    	marquertemps = new MarquerTemps(c1);
    	marquermesures= new MarquerMesure(c1);
    	
	}
    
    @Test
    public void testIntractionCommandesControleur(){

    	marquertemps.executer();
    	verify(c1).marquerTemps();
    	
    	marquermesures.executer();
    	verify(c1).marquerMesure();
    	
    }
	
}
