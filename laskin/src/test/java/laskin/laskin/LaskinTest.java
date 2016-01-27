
package laskin.laskin;


import static laskin.laskin.Laskin.onkoNumero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaskinTest {
    
    public LaskinTest() {
    }
    
 
    @Before
    public void setUp() {

        
    
    }
    
    @After
    public void tearDown() {
    }

//1.
    @Test
    public void onkoNumeroToimii(){
        String luku = "45.982";
        String sana = "sana";
        
        assertEquals(onkoNumero(luku), true);
        assertEquals(onkoNumero(sana), false);
                
        
    }
}
