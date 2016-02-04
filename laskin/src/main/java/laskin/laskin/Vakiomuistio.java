
package laskin.laskin;

import java.util.HashMap;

public class Vakiomuistio {
   
    HashMap<String, Double> muistio = new HashMap<>();
    String avain;
    double arvo = 0;

 
    


    public Vakiomuistio(String lisattava, double arvo) {
    
        this.avain = lisattava;
        this.arvo = arvo;
   
        lisaaValmiitVakiot();
    
    
    }

    public final void lisaaValmiitVakiot() {

        muistio.put("pii", 3.14159);
        muistio.put("R", 8.31446);

    }
    
    public double palautaVakionArvo(String symboli) {
    
        return muistio.get(symboli);
    }
    
    public boolean tutkiOnkoVakioMuistissa(String avain) {
        if (muistio.containsKey(avain)) {
            return true;
        } else {
            return false;
        }
    } 


    public void lisaaVakioMuistioon(String avain, double arvo) {
        muistio.put(avain, arvo);
           
    }
    

    
    @Override
    public String toString() {
        
        String kaikki = "";
        for (String key: muistio.keySet()) {

            kaikki = kaikki + "\n" + key + " = " + muistio.get(key);
    
        }
        return kaikki;
    }
    

}
// lisää vakioita
// testit laskutoimitus
// testit laskin
// testit vakio