
package laskin.laskin;
        
import java.util.Scanner;


public class Laskin {

 
    
    public static void main(String[] args) {
    
        Scanner lukija = new Scanner(System.in);
        double luku1;
        double luku2;
        String valinta = "";
        Vakiomuistio muistio = new Vakiomuistio("", 0);
        
        System.out.println("help listaa toiminnot.");
        
        while (!"loppu".equals(valinta)) {
            System.out.println("valitse toiminto");
            valinta = lukija.nextLine();
            
            if ("loppu".equals(valinta)) {
                System.out.println("Hei hei!");
            }
        
            if ("help".equals(valinta)) {
                System.out.println("lasku: suorita laskutoimitus");
                System.out.println("vakio: lisää vakio muistiin");
                System.out.println("loppu: lopettaa");
                System.out.println("listaa: listaa muistion vakiot");
            }

            if ("lasku".equals(valinta)) {
                
                String ekaluku = lukija.nextLine();

                if (onkoNumero(ekaluku) == true) {
                    luku1 = Double.parseDouble(ekaluku); 
                } else {
                    if (muistio.tutkiOnkoVakioMuistissa(ekaluku) == true) { 
                        luku1 = muistio.palautaVakionArvo(ekaluku);
                    } else {
                        System.out.println("Muistiossa ei ole ensimmäisen luvun symbolia.");
                        continue;
                    } 
                }
                
                String operaattori = lukija.nextLine();
                if (onkoOperaattoriValikossa(operaattori) == false) {
                    System.out.println("valitse + - / * ^ r");
                    continue;
                }
                    
                String tokaluku = lukija.nextLine();
                if (onkoNumero(tokaluku) == true) {
                    luku2 = Double.parseDouble(tokaluku); 
                } else {
                    if (muistio.tutkiOnkoVakioMuistissa(tokaluku) == true) {
                        luku2 = muistio.palautaVakionArvo(tokaluku);
                    } else {
                        System.out.println("Muistiossa ei ole toisen luvun symbolia.");
                        continue;
                    }
                }
                
                Laskutoimitus laskutoimitus = new Laskutoimitus(luku1, luku2, operaattori);
                laskutoimitus.laske();
        
                System.out.println(laskutoimitus.annaTulos()); 
            }
            if ("vakio".equals(valinta)) {
            
            
                System.out.println("Anna symboli.");
                String symboli = lukija.nextLine();
                if (muistio.tutkiOnkoVakioMuistissa(symboli) == true || onkoNumero(symboli) == true) {
                    System.out.println("Symboli on jo käytössä tai symboli oli numero");
                    continue;
                }
                
                System.out.println("Anna arvo");
                String vakionarvo = lukija.nextLine();
            
                if (onkoNumero(vakionarvo) == true) {
                    double arvo = Double.parseDouble(vakionarvo);
                    muistio.lisaaVakioMuistioon(symboli, arvo);
                    System.out.println("lisäys onnistui"); 
                } else { 
                    System.out.println("Arvo ei kelpaa"); 
                }
            }
            
            if ("listaa".equals(valinta)) {
                System.out.println(muistio.toString());
               
                
                
            }   
                
        }
      
    }

    
    public static boolean onkoNumero(String luku) {  
        try { 
            double k =  Double.parseDouble(luku); 
        } catch (NumberFormatException n) {  
            return false; 
        }  
        return true; 
    }  
    
    public static boolean onkoOperaattoriValikossa(String merkki) {
   
        if ("+-/*^r".contains(merkki)) {
            return true;
        } else {
            return false;   
        }
    }
    //huomioi +-tapaus
    
}