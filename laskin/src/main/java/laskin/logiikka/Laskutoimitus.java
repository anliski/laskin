
package laskin.logiikka;

/**
 * Laskutoimitus luokka tarjoaa metodit laskutoimitusten suorittamista varten, sekä metodin tuloksen palauttamiseen.
 */

public class Laskutoimitus {

    double luku1;
    double luku2;
    String operaattori;
    double tulos;

/**
 * Konstruktori asettaa määritetyt luvut ja operaattorin luokan käyttöön.
 * 
 * @param luku1 käyttäjän antama luku
 * @param luku2 käyttäjän antama luku
 * @param operaattori käyttäjän valitsema operaattori.
 * 
 */

    public Laskutoimitus(double luku1, double luku2, String operaattori) {    
    
        this.luku1 = luku1;
        this.luku2 = luku2;
        this.operaattori = operaattori; 
        this.tulos = 0;
    }

/**
 * Metodi käynnistää toisen metodin joka vastaa käyttäjän antamaa laskutoimistusoperaattoria.
 * 
 */
    public void laske() {
    
        if ("+".equals(this.operaattori)) {
            pluslasku();
        }
        if ("-".equals(this.operaattori)) {
            miinuslasku();
        }
        if ("*".equals(this.operaattori)) {
            kertolasku();
        }   
        if ("/".equals(this.operaattori)) {
            jakolasku();
        }
        if ("^".equals(this.operaattori)) {
            potenssi();    
        }
        if ("r".equals(this.operaattori)) {
            juuri();    
        }
    }
    
    
 /**
 * Metodi laskee summan ja asettaa sen laskutoimituksen tuloksen arvoksi.
 * 
 */
    public void pluslasku() {
    
        this.tulos = this.luku1 + this.luku2;
    }
 /**
 * Metodi laskee lukujen erotuksen ja asettaa sen laskutoimituksen tuloksen arvoksi.
 * 
 */            
    public void miinuslasku() {
    
        this.tulos = this.luku1 - this.luku2;
             
    }
 /**
 * Metodi laskee lukujen tulon ja asettaa sen laskutoimituksen tuloksen arvoksi.
 * 
 */
    public void kertolasku() {
    
        this.tulos = this.luku1 * this.luku2;   
    }
 /**
 * Metodi laskee lukujen osamäärän ja asettaa sen laskutoimituksen tuloksen arvoksi.
 * 
 */ 
    public void jakolasku() {
    
        if (this.luku2 != 0) {
            this.tulos = this.luku1 / this.luku2;
        } else {
            throw new IndexOutOfBoundsException("Nollalla ei voi jakaa.");
        }
    }
 /**
 * Metodi laskee ensimmäisen käyttäjän antaman luvun toisen luvun potenssiin asettaa sen laskutoimituksen tuloksen arvoksi.
 * 
 */
    public void potenssi() {
        if (this.luku1 >= 0) { 
            this.tulos = Math.pow(this.luku1, this.luku2);
        } else {
            this.tulos = -Math.pow(-this.luku1, this.luku2);
        }
    }
 /**
 * Metodi ottaa toisen luvun juuren ensimmäisestä luvusta ja asettaa sen laskutoimituksen tuloksen arvoksi.
 * 
 */
    public void juuri() {

        if (this.luku1 > 0) { 
            this.tulos = Math.pow(this.luku1 , (1 / this.luku2));
        } else {
            throw new IndexOutOfBoundsException("Ei ole reaalista juurta");
        }
            
    }
 /**
 * Metodi palauttaa tuloksen laskutomituksen suorittamisen jälkeen.
 * 
 * 
 * @return laskutoimituksen tulos
 */
 
    public double annaTulos() {
  
        return this.tulos;
    }
    

        
   

}
