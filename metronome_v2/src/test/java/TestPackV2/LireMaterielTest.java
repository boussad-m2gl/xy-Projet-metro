package TestPackV2;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import command.LireMateriel;
import adaptateur.Adaptateur;

@RunWith(MockitoJUnitRunner.class)
public class LireMaterielTest {

	  private Adaptateur mockedAdaptateurIhm;
	  private LireMateriel commandLireMat;
	  
	  public LireMaterielTest(){
		  
		  mockedAdaptateurIhm = mock(Adaptateur.class);  
		  commandLireMat = new LireMateriel(mockedAdaptateurIhm);
		  
	  }
	  
	  @Test
	  public void testInteractionCommand(){
           commandLireMat.executer();
           verify(mockedAdaptateurIhm).lireMateiel();
	  }
	
	
}
