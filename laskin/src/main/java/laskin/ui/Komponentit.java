
package laskin.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * luokka luo osan laskin Luokan komponenteista.
 */


public class Komponentit {
/**
 * Konstruktori.
 */

    public Komponentit(){
    }
/**
 * Metodi luo uuden tekstikentän ja palauttaa sen.
 * 
 * @return tekstikenttä
 */
    public JTextField luoTekstikentta() {
        JTextField tekstikentta = new JTextField("", 12);
        return tekstikentta;
    }

    /**
     * Metodi luo uuden panelin.
     * 
     * @param x paikka x akselilla
     * @param y paikka y akselilla
     * @param leveys panelin leveys
     * @param korkeus panelin korkeus
     * 
     * @return paneli
     */

    public JPanel luoPaneli(int x, int y, int leveys, int korkeus) {
        JPanel paneli = new JPanel(new GridBagLayout());
        paneli.setBounds(x, y , leveys, korkeus);
        return paneli;
    }
     /**
     * Metodi vaihtaa koordinaattien paikkaa.
     * @param c koordinaatiosto.
     * @param x uusi paikka x-akselilla.
     * @param y uusi paikka y-akselilla.
     * 
     * @return koordinaatisto
     */


    public GridBagConstraints asettele(GridBagConstraints c, int x, int y) {    
        c.gridx = x;
        c.gridy = y;
        return c;
    
    }
     /**
     * Metodi luo numeronapita ja lisää samalla niille toiminnan.
     * @param numeronapit lista johon luodut napit lisätään.
     * @param toiminta toiminta joka nappeihin lisätään.
     * @param tekstikentta tarvitaan toiminnan lisäämiseen.
     * 
     */  

    public void luoNumeronapit(ArrayList<JButton> numeronapit, Toiminta toiminta, JTextField tekstikentta) {
        for (int i = 0; i < 10; i++) {  
            numeronapit.add(new JButton(Integer.toString(i)));
            toiminta.lisaaActionListenerNumeronapeille(numeronapit.get(i), i, tekstikentta);
        }
    }
}
