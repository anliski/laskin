
package laskin.laskin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValintaTest {
    
    public ValintaTest() {
    }
    
    Valinta valinta;
    
    @Before
    public void setUp() {
    valinta = new Valinta();
 
    }
    
    @After
    public void tearDown() {
    }

//1.
    @Test
    public void onkoNumeroToimii(){
        
        
        String luku = "45.982";
        String sana = "sana";
        
        assertEquals(valinta.onkoNumero(luku), true);
        assertEquals(valinta.onkoNumero(sana), false);
                
        
    }
//2.
    @Test
    public void onkoOperaattoriValikossaPalauttaaTrueJosOn(){
        
        String plus = "+";
        String root = "r";

        
        assertEquals(valinta.onkoOperaattoriValikossa(plus), true);
        assertEquals(valinta.onkoOperaattoriValikossa(root), true);
                
        
    }
//3.
    @Test
    public void onkoOperaattoriValikossaPalauttaaFalseJosEiOle(){
        String kirjain = "w";
        String merkit = "o9";
        String plusmiinus = "+-";
        
        assertFalse(valinta.onkoOperaattoriValikossa(kirjain));
        assertFalse(valinta.onkoOperaattoriValikossa(merkit));
        assertFalse(valinta.onkoOperaattoriValikossa(plusmiinus));
        
 
    }   
//3.
    @Test
    public void tutkiOnkoVakioMuistiossaPalauttaaOikein(){
        assertTrue(valinta.tutkiOnkoVakioMuistissa("R"));
        assertFalse(valinta.tutkiOnkoVakioMuistissa("???"));
        assertTrue(valinta.tutkiOnkoVakioMuistissa("atm"));
        
 
    }   
    @Test
    public void palauttaaMuistiostaOikeanVakionArvon(){
        
        assertEquals(valinta.palautaMuistiostaVakionArvo("pii"), 3.14159, 0.00001);
        assertEquals(valinta.palautaMuistiostaVakionArvo("R"), 8.31446, 0.00001);

    } 

    @Test
    public void VakionLisaaminenMuistioonOnnistuu(){
        
        valinta.lisaaVakioMuistioon("uusi", 5.7);
        valinta.lisaaVakioMuistioon("vakio", 80);
        
        assertTrue(valinta.tutkiOnkoVakioMuistissa("uusi"));
        assertTrue(valinta.tutkiOnkoVakioMuistissa("vakio"));        
          
        assertEquals(valinta.palautaMuistiostaVakionArvo("uusi"), 5.7, 0.00001);
        assertEquals(valinta.palautaMuistiostaVakionArvo("vakio"), 80, 0.00001);
    } 
    
    @Test
    public void VoikoLuvunMaarittaa(){
        
        assertTrue(valinta.voikoLuvunMaarittaa("R"));
        assertTrue(valinta.voikoLuvunMaarittaa("8.456"));
        assertFalse(valinta.tutkiOnkoVakioMuistissa("uusi"));         
        
        valinta.lisaaVakioMuistioon("uusi", 5.7);  
        
        assertTrue(valinta.tutkiOnkoVakioMuistissa("uusi")); 

    }
    @Test
    public void maarittaLukuMaarittaaOikein(){
        assertEquals(valinta.maaritaLuku("9.886"), 9.886, 0.00001);
        assertEquals(valinta.maaritaLuku("atm"), 101325, 0.00001);

        valinta.lisaaVakioMuistioon("uusi", 5.7); 

        assertEquals(valinta.maaritaLuku("uusi"), 5.7, 0.00001);
        
        
    }
    @Test
    public void listaaKaikkiListaaOikein(){
        assertEquals(valinta.listaaKaikki(),"\npii = 3.14159\nR = 8.31446\ne = 2.718281\natm = 101325.0\n");

    }
    
}


