
package laskin.logiikka;
import laskin.logiikka.Laskutoimitus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaskutoimitusTest {

    private Laskutoimitus laskutoimitus1;
    private Laskutoimitus laskutoimitus2;
    
    @Before
    public void setUp() {
   

    }
    
    @After
    public void tearDown() {
    }
    
//1.
    @Test
    public void  KonstruktoriAsettaaArvotOikein(){
    
        laskutoimitus1 = new Laskutoimitus(4.0 , 1.0, "+");
        
        assertEquals(4.00 , laskutoimitus1.luku1, 0.00001);
        assertEquals(1.00 , laskutoimitus1.luku2, 0.00001);
        assertEquals("+" , laskutoimitus1.operaattori);
    
    }
//2.
    @Test
    public void tulosAlussaNolla(){
        
        laskutoimitus1 = new Laskutoimitus(0.78, 5.60 , "+");
        laskutoimitus2 = new Laskutoimitus(5.90, 8.0 , "/");
        
        assertEquals(0 , laskutoimitus1.tulos, 0.00001);
        assertEquals(0 , laskutoimitus2.tulos, 0.00001);
 
    }
    
//3.
    @Test
    public void pluslaskuToimii(){
        
        laskutoimitus1 = new Laskutoimitus(0.7801, 5.60 , "+");
        laskutoimitus2 = new Laskutoimitus(-0.78, 5.60 , "+");
        
        laskutoimitus1.laske();
        laskutoimitus2.laske();
        
        assertEquals(6.3801 , laskutoimitus1.tulos, 0.00001);
        assertEquals(4.82 , laskutoimitus2.tulos, 0.00001);
    
    }  
//4.
    @Test
    public void miinuslaskuToimii(){
        
        laskutoimitus1 = new Laskutoimitus(3.5, 82 , "-");
        laskutoimitus2 = new Laskutoimitus(9.92, -0.08 , "-");
        
        laskutoimitus1.laske();
        laskutoimitus2.laske();
        
        assertEquals( -78.5 , laskutoimitus1.tulos, 0.00001);
        assertEquals( 10 , laskutoimitus2.tulos, 0.00001);
    
    }  
    
//5.
    @Test
    public void kertolaskuToimii(){
        
        laskutoimitus1 = new Laskutoimitus(8, 2, "*");
        laskutoimitus2 = new Laskutoimitus(8.51, -0.98 , "*");
        
        laskutoimitus1.laske();
        laskutoimitus2.laske();
        
        assertEquals( 16 , laskutoimitus1.tulos, 0.00001);
        assertEquals( -8.3398 , laskutoimitus2.tulos, 0.00001);
    
    }  
    
//6.
    @Test
    public void jakolaskuToimii(){
        
        laskutoimitus1 = new Laskutoimitus(3.5, 82 , "/");
        laskutoimitus2 = new Laskutoimitus(9.92, -0.08 , "/");
        
        laskutoimitus1.laske();
        laskutoimitus2.laske();
        
        assertEquals( 0.0426829 , laskutoimitus1.tulos, 0.00001);
        assertEquals( -124 , laskutoimitus2.tulos, 0.00001);
    
    }  
    
//7.
    
    @Test
    public void nollallaJakaminenAiheuttaaExceptionin(){
        boolean thrown = false;
        laskutoimitus1 = new Laskutoimitus(8, 0 , "/");
        

        try{
            laskutoimitus1.laske();
        }
        catch(IndexOutOfBoundsException e){
            thrown = true;}
        
        assertTrue(thrown);
 
    }

 
//8.
    @Test
    public void potenssilaskuToimii(){
        laskutoimitus1 = new Laskutoimitus(4, 4 , "^");
        laskutoimitus2 = new Laskutoimitus(-5.594, 8.5 , "^");
        
        laskutoimitus1.laske();
        laskutoimitus2.laske();

        
        assertEquals(256, laskutoimitus1.tulos, 0.00001);
        assertEquals(-2267988.913585, laskutoimitus2.tulos, 0.00001);
        
    }
//9.    
    @Test
    public void juuriToimii(){
        
        laskutoimitus1 = new Laskutoimitus(1, 2 , "r");
        laskutoimitus2 = new Laskutoimitus(90, 5.8 , "r");
        
        laskutoimitus1.laske();
        laskutoimitus2.laske();
        
        assertEquals(1 , laskutoimitus1.tulos, 0.0001);
        assertEquals(2.1724 , laskutoimitus2.tulos, 0.0001);
    
    }
    
//10.    
    @Test
    public void negatiivisestaArvostaJuurenOttaminenAiheuttaaExceptionin(){
        boolean thrown = false;
        laskutoimitus1 = new Laskutoimitus(-8, 2 , "r");
   
        try{
        laskutoimitus1.laske();
        }
        catch(IndexOutOfBoundsException e){
        thrown = true;}
        
        assertTrue(thrown);
 
    }
        


    
}