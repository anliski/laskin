
package laskin.laskin;

import java.util.HashMap;
/**
 * Vakiomuistio luokka sisältää muistion johon voi tallentaa jo josta voi hakea vakioita.
 */

public final class Vakiomuistio {
   
    HashMap<String, Double> muistio = new HashMap<>();
   

    public Vakiomuistio(String lisattava, double arvo) {
    
        lisaaVakioMuistioon(lisattava, arvo);
   
        lisaaValmiitVakiot();
    
    
    }
/**
 * Metodi lisää valimiit vakiot muistioon.
 * 
 */
    public final void lisaaValmiitVakiot() {

        muistio.put("pii", 3.14159);
        muistio.put("R", 8.31446);
        muistio.put("e", 2.718281);

    }
/**
 * Metodi palauttaa annetua symbolia vastaavan vakion arvon.
 * 
 * @param symboli Käyttäjän antama symboli.
 * 
 * @return symbolia vastaava luku.
 */
    
    public double palautaVakionArvo(String symboli) {
    
        return muistio.get(symboli);
    }
    
 /**
 * Metodi tutkii löytyykö käyttäjän antamaa symbolia muistiosta.
 * 
 * @param avain Käyttäjän antama symboli.
 * 
 * @return true jos symboli löytyy/false jos symbolia ei löydy.
 */
    
    public boolean tutkiOnkoVakioMuistissa(String avain) {
       
        return muistio.containsKey(avain);
    } 

/**
 * Metodi lisää muistioon uuden symbolin ja sitä vastaavan arvon.
 * 
 * @param avain Käyttäjän antama symboli.
 * @param arvo Käyttäjän antama arvo symbolille.
 * 
 */
    
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
