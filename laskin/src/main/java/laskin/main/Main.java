package laskin.main;


import laskin.ui.Laskin;

/**
 * Main luo uuden laskimen ja avaa käyttöliittymän.
 */

public class Main {
/**
 * Luo uuden laskimen ja käynnistää sen.
 */
    public static void main(String[] args) {
        Laskin laskuri = new Laskin();
        laskuri.kayta();
    
    }
    
}
