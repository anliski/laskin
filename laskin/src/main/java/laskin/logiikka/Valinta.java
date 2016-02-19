
package laskin.logiikka;

/**
 * Valinta luokka tarjoaa metodit käyttäjän antamien valintojen käsittelyyn, 
 * mahdollisuuden tallentaa vakioita ja niiden arvoja vakiomuistioon, ja käyttäjän antamien syötteiden oikeellisuuden tarkistamissen.
 * 
 */

public class Valinta {

    Vakiomuistio muistio = new Vakiomuistio();
    
    public Valinta() {    
    }

/**
 * Metodi palauttaa tekstin joka luettelee lyhyesti laskimen toiminnot.
 * 
 * @return Ohjeet laskimen toiminnoille
 */
    public String help() {
        return "\nlasku: suorita laskutoimitus\nvakio: lisää vakio muistiin\nlistaa: listaa muistion vakiot\n";
    }        
/**
 * Metodi tutkii löytyykö vakiota muistiosta.
 * HUOM: Käyttää vakiomuistion metodia.
 * 
 * @param  symboli Käyttäjän antama symboli.
 * 
 * @return true jos symboli löytyy muistiosta/false jos symbolia ei löydy.
 */
    
    public boolean tutkiOnkoVakioMuistissa(String symboli) {
        return muistio.tutkiOnkoVakioMuistissa(symboli);
        
    }
/**
 * Metodi etsii symbolia vastaavan vakion arvon ja palauttaa sen .
 * HUOM: Käyttää vakiomuistion metodia.
 * 
 * @param  symboli Käyttäjän antama symboli.
 * 
 * @return vakion numeroarvo.
 */    
    public double palautaMuistiostaVakionArvo(String symboli) {
        
        return muistio.palautaVakionArvo(symboli);
        
    }
/**
 * Metodi lisää vakiomuistioon symbolin ja sitävastaavan numeroarvon.
 * HUOM: Käyttää vakiomuistion metodia.
 * 
 * @param  symboli Käyttäjän antama symboli.
 * @param  arvo Käyttäjän antama arvo symbolille.
 * 
 */    
    
    public void lisaaVakioMuistioon(String symboli, double arvo) {
        muistio.lisaaVakioMuistioon(symboli, arvo);
        
        
    }
/**
 * Metodi tutkii onko parametrina annettu kirjainjono muunnettavissa luvuksi.
 *
 * @param  luku käyttäjän antama kirjainjono. 
 *
 * @return true jos kirjainjono on luku tai sitä vastaava luku löytyy vakiomuistiosta. Muuten false.
 */  
    
    
    public boolean voikoLuvunMaarittaa(String luku) {
        return tutkiOnkoVakioMuistissa(luku) == true || onkoNumero(luku) == true;
    }
/**
 * Metodi muuntaa annetun kirjainjonon numeroksi.
 * 
 * @param  luku käyttäjän antama kirjainjono. 
 *
 * @return kirjainjonoa vastaava luku.
 */    

    public double maaritaLuku(String luku) {
        double numero;
        if (onkoNumero(luku) == true) {
            numero = Double.parseDouble(luku); 
        } else {
            numero = palautaMuistiostaVakionArvo(luku);
        }
        return numero;
    }
/**
 * Metodi tutkii onko kirjainjono numero.
 * 
 * @param  luku käyttäjän antama kirjainjono. 
 *
 * @return true jos on/ false jos ei ole.
 */      

    public boolean onkoNumero(String luku) {
        try { 
            double k = Double.parseDouble(luku); 
        } catch (NumberFormatException n) {  
            return false; 
        }  
        return true; 
    }  
 /**
 * Metodi vertailee käyttäjän antamaa operaattorin-merkkiä valintamahdollisuuksiin.
 * 
 * @param  merkki käyttäjän operaattori. 
 *
 * @return true jos merkki vastaa jotakin valinnoista, muuten false.
 */     
    
    public boolean onkoOperaattoriValikossa(String merkki) {
   
        return "+".equals(merkki) || "-".equals(merkki) || "*".equals(merkki) || "/".equals(merkki) || "^".equals(merkki) || "r".equals(merkki);
    }
 /**
 * Listaa kaikki muistiossa olevat symbolit ja niitä vastaavat luvut.
 * HUOM! Käyttyyä Vakiomuistion metodia
 * 
 * @param  merkki käyttäjän operaattori. 
 *
 * @return true jos merkki vastaa jotakin valinnoista, muuten false.
 */     
    
    public String listaaKaikki() {
        
        return muistio.toString();
    }
    
}