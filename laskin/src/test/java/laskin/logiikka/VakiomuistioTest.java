
package laskin.logiikka;

import laskin.logiikka.Vakiomuistio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VakiomuistioTest {
    
    public VakiomuistioTest() {
    }

    private Vakiomuistio muistio;
    
    
    @Before
    public void setUp() {
 
    muistio = new Vakiomuistio();    
    muistio.lisaaVakioMuistioon("uusi", 32.5);
    }
    
    @After
    public void tearDown() {
    }

//1.    
    @Test
    public void  TutkiiOnkoVakiotMuistissaOikein(){
        
        
        assertTrue(muistio.tutkiOnkoVakioMuistissa("symboli"));
        assertTrue(muistio.tutkiOnkoVakioMuistissa("uusi"));
        assertTrue(muistio.tutkiOnkoVakioMuistissa("pii"));
        assertFalse(muistio.tutkiOnkoVakioMuistissa("puuttuva"));        

    }
//2.    
    @Test
    public void  palauttaOikeanVakionArvon(){
    
        assertEquals(muistio.palautaVakionArvo("symboli"), 4.0, 0.00001);
        assertEquals(muistio.palautaVakionArvo("uusi"), 32.5, 0.00001);
        assertEquals(muistio.palautaVakionArvo("pii"), 3.14159, 0.000001);
        
   
    }
    
    
//3. 
    @Test
    public void lisaaVakionMuistiin(){
        
        muistio.lisaaVakioMuistioon("x", 5.39);
        muistio.lisaaVakioMuistioon("y", 7.311);
        
        assertEquals(muistio.palautaVakionArvo("x"), 5.39, 0.00001);
        assertEquals(muistio.palautaVakionArvo("y"), 7.311, 0.00001);

    }
  
  
//4. 
    @Test
    public void toStringPalauttaaOikeassaMuodossa(){
        
        Vakiomuistio muistio1 = new Vakiomuistio(); 
        assertEquals(muistio1.toString(), "\na = 4.0\npii = 3.14159\nR = 8.31446\ne = 2.718281\n");
 
    }
    
    
}
