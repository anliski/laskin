
package laskin.ui;

import java.util.Scanner;
import laskin.logiikka.Laskutoimitus;
import laskin.logiikka.Valinta;

/**
 * TUI luokka sisältää tekstikäyttöliittymän.
 */

public class TUI {

    public TUI(){
    
    }
    public void kaytto() {
    
        Scanner lukija = new Scanner(System.in);
        double luku1;
        double luku2;
        String toiminta = "";
        
        Valinta valinta = new Valinta();
        
        System.out.println("help listaa toiminnot.");
        
        while (!"loppu".equals(toiminta)) {
            System.out.println("valitse toiminto");
            toiminta = lukija.nextLine();
                    
        
            if ("help".equals(toiminta)) {
                System.out.println(valinta.help());
            }

            if ("lasku".equals(toiminta)) {
                
                System.out.println("Anna järjestyksessä: ekaluku, operaattori, tokaluku");
                String ekaluku = lukija.nextLine();
                
                if (valinta.voikoLuvunMaarittaa(ekaluku) == true) {
                    luku1 = valinta.maaritaLuku(ekaluku);
                } else {
                    System.out.println("Muistiossa ei ole ensimmäisen luvun symbolia");
                    continue;
                    
                }

                String operaattori = lukija.nextLine();
                    
                if (valinta.onkoOperaattoriValikossa(operaattori) == false) {
                    System.out.println("valitse + - / * ^ r");
                    continue;
                }
                    
                String tokaluku = lukija.nextLine();

                if (valinta.voikoLuvunMaarittaa(tokaluku) == true) {
                    luku2 = valinta.maaritaLuku(tokaluku);
                } else {
                    System.out.println("Muistiossa ei ole toisen luvun symbolia");
                    continue;
                    
                }                

                Laskutoimitus laskutoimitus = new Laskutoimitus(luku1, luku2, operaattori);
                laskutoimitus.laske();
        
                System.out.println(laskutoimitus.annaTulos()); 
            }
            if ("vakio".equals(toiminta)) {
            
            
                System.out.println("Anna symboli.");
                String symboli = lukija.nextLine();

                
                if (valinta.tutkiOnkoVakioMuistissa(symboli) == true || valinta.onkoNumero(symboli) == true) {
                    System.out.println("Symboli on jo käytössä tai symboli oli numero");
                    continue;
                } 
                
                System.out.println("Anna arvo");
                String vakionarvo = lukija.nextLine();
                
                
                if (valinta.onkoNumero(vakionarvo) == true) {
                    valinta.lisaaVakioMuistioon(symboli, Double.parseDouble(vakionarvo));
                    System.out.println("lisäys onnistui"); 
                } else { 
                    System.out.println("Arvo ei kelpaa"); 
                }
            }
            
            if ("listaa".equals(toiminta)) {
                System.out.println(valinta.listaaKaikki());

            }   
                
        }
      
    }

  
}

