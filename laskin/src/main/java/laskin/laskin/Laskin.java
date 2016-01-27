
package laskin.laskin;
        
import java.util.Scanner;


public class Laskin {

    public static void main(String[] args) {
    
        Scanner lukija = new Scanner(System.in);
        double luku1 = 0;
        double luku2 = 0;
        
        System.out.println("Haluatko suorittaa laskun vai kirjoittaa vakion muistiin? lasku/vakio");
        String valinta = lukija.nextLine();
        
        if ("lasku".equals(valinta)){
        
            String ekaluku = lukija.nextLine();
            String operaattori = lukija.nextLine();
            String tokaluku = lukija.nextLine();

            
            if (onkoNumero(ekaluku) == true){
                luku1 = Double.parseDouble(ekaluku);   
            }
            else {
            //hakee vakiomuistiosta kirjainta/sanaa vastaavan luvun ja asettaa sen luku1 arvoksi
            }
            
            if (onkoNumero(tokaluku) == true){
                luku2 = Double.parseDouble(tokaluku);    
            }
            else {
            //hakee vakiomuistiosta kirjainta/sanaa vastaavan luvun ja asettaa sen luku2 arvoksi.
           
            }
            
   
        Laskutoimitus laskutoimitus = new Laskutoimitus(luku1, luku2, operaattori);
        laskutoimitus.laske();
        
        System.out.println(laskutoimitus.annaTulos());
        }
        
        if ("vakio".equals(valinta)){
            
        System.out.println("Anna symboli.");
        String symboli = lukija.next();
        System.out.println("Anna arvo");
        double arvo = Double.parseDouble(lukija.next());
        
        //Tallentaa toiseen luokkaan. 
        
        }
    }
    
    public static boolean onkoNumero (String luku){  
            try{
            double numero = Double.parseDouble(luku);}  
            catch(NumberFormatException n)  
            {  
            return false;  
            }  
        return true;  
        
        }  
        
        
      
}