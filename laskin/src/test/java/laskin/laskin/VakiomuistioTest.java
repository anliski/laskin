
package laskin.laskin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VakiomuistioTest {
    
    public VakiomuistioTest() {
    }

    private Vakiomuistio muistio;

    
    @Before
    public void setUp() {
 
    muistio = new Vakiomuistio("aaa", 4);    
    }
    
    @After
    public void tearDown() {
    }

  //1.
    @Test
    public void  KonstruktoriAsettaaArvotOikein(){
    

        assertEquals(muistio.avain, "aaa");
        assertEquals(muistio.arvo, 4.0, 0.001);

    }
    
    @Test
    public void  EiAnnaListataSamannimistaVakiota(){
        
    }
    
    @Test
    public void  EiAsetaVakionSymboliksiNumeerisiaArvoja(){
        
    }
    
    
    
    @Test
    public void  lisaaVakionMuistiin(){
        
        
    }
    
    
}
