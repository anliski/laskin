
package laskin.laskin;

import java.util.HashMap;

public final class Vakiomuistio {
   
    HashMap<String, Double> muistio = new HashMap<>();
   

    public Vakiomuistio(String lisattava, double arvo) {
    
        lisaaVakioMuistioon(lisattava, arvo);
   
        lisaaValmiitVakiot();
    
    
    }

    public final void lisaaValmiitVakiot() {

        muistio.put("pii", 3.14159);
        muistio.put("R", 8.31446);
        muistio.put("e", 2.718281);

    }
    
    public double palautaVakionArvo(String symboli) {
    
        return muistio.get(symboli);
    }
    
    public boolean tutkiOnkoVakioMuistissa(String avain) {
       
        return muistio.containsKey(avain);
    } 


    public void lisaaVakioMuistioon(String avain, double arvo) {
       
        muistio.put(avain, arvo);
           
    }
    
    
    @Override
    public String toString() {
        
        String kaikki = "\n";
        for (String key: muistio.keySet()) {
            
            
            kaikki = kaikki + key + " = " + muistio.get(key) + "\n";
    
        }
        return kaikki;
    }
    

}
