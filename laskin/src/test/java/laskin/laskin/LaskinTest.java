
package laskin.laskin;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;




public class LaskinTest{
    
    private Laskin laskuri;
    
    public LaskinTest() {
    }
    
    @Before
    public void setUp() {
        laskuri = new Laskin();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void numeronapitListanKokoOnOikea(){
       laskuri.kayta();
        assertEquals(laskuri.numeronapit.size(), 10);
    }
    
    @Test
    public void valikkoListanKokoOnOikea(){
        laskuri.kayta();
        assertEquals(laskuri.operaattorinapit.size(), 9);
    }
    
    @Test
    public void operaattorinapitListanKokoOnOikea(){
        laskuri.kayta();
        assertEquals(laskuri.valikkonapit.size(), 4);
    }
    
    @Test
    public void tekstikenttaAlussaTyhja(){
        laskuri.kayta();
        assertEquals(laskuri.tekstikentta.getText(), "");
    }
    
    @Test
    public void numerotLisataanPaneliin(){
        laskuri.kayta();
        JPanel paneli = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        laskuri.lisaaNumeroNappulat(c, paneli);
        
        assertEquals(paneli.getComponentCount(), 10);
    }
    
    @Test
    public void valikkonappejaOikeaMaara(){
        
        laskuri.teeValikkoNapit();
        
        assertEquals(laskuri.valikkonapit.size(), 4);
        
    }
    
    @Test
    public void OperaattoriNappejaOikeaMaara(){
       
        laskuri.teeOperaattoriNappulat();
        
        assertEquals(laskuri.operaattorinapit.size(), 9);
        
    }
    @Test
    public void laskurinKaytaMetodiLuoOperaattoriNapit(){
       
        laskuri.kayta();
        
        assertEquals(laskuri.operaattorinapit.size(), 9);
        
    }

    @Test
    public void operaattoriNappulatLisataanPaneliin(){
        laskuri.kayta();
  
        JPanel paneli = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
       
        laskuri.lisaaOperaattoriNappulat(c, paneli);
       
       
         assertEquals(paneli.getComponentCount(), 9);
        
    }
    
    @Test
    public void numeropaneliinLisataanNumeroJaOperaattoriNapitKunLaskintaKaytetaan(){
        laskuri.kayta();
        assertEquals(laskuri.numeropaneli.getComponentCount(), 19);
        
 
    }
    @Test
    public void raamitOikeanKokoisia(){
        laskuri.kayta();
        assertEquals(laskuri.reunat.getHeight(), 400);
        assertEquals(laskuri.reunat.getWidth(), 700);
 
    }

    @Test
    public void tesktiPaneliinLisataanTekstiKantta(){
        laskuri.kayta();
        assertEquals(laskuri.teksti.getComponent(0), laskuri.tekstikentta);
 
    }
    
    @Test
    public void raamitOnNakyvissa(){
        laskuri.kayta();
        assertEquals(laskuri.reunat.isVisible(), true);
 
    }
    @Test
    public void valikkoPaneliinLisataanOikeaMaaraNappeja(){
        laskuri.kayta();
        assertEquals(laskuri.valikko.getComponentCount(), 4);
 
    }

}
    
    
    
    

    
    
