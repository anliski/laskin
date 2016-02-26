package laskin.ui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import laskin.ui.*;

/**
 * luokka luo laskimen graafiset osat ja uuden käyttöliittymän.
 */

public class Laskin {
    
    public JFrame reunat;
    public JPanel numeropaneli;
    public JPanel teksti;
    public JPanel valikko;
    public JTextField tekstikentta;
    public ArrayList<JButton> numeronapit = new ArrayList<>();
    public ArrayList<JButton> valikkonapit = new ArrayList<>();
    public ArrayList<JButton> operaattorinapit = new ArrayList<>();
    public Toiminta toiminta;
    public Komponentit komponentit;
    
/**
 * Konstruktori luo uuden toiminnan.
 */
    
    public Laskin() {
        toiminta = new Toiminta(); 
        komponentit = new Komponentit();
    } 
    
/**
 * Metodi luo raamit laskimelle, asetta ne näkyväksi ja kutsuu muita luokan sisäisiä metodeja jotka lisäävät panelit.
 */
    
    public void kayta() {
        
        reunat = new JFrame("Laskin");
        reunat.setSize(700, 400);
        reunat.setLocationRelativeTo(null);
        reunat.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoTekstikentta();
        luoValikko();
        lisaaNumeroPaneli();
        reunat.setVisible(true);
        
    }
/**
 * Metodi asettaa raameihin uuden tekstikentän ja panelin.
 *
 */
    public void luoTekstikentta() {
        
        tekstikentta = komponentit.luoTekstikentta();
        teksti = komponentit.luoPaneli(5, 60, 700, 50);
        teksti.setBackground(Color.WHITE);
        GridBagConstraints c1 = new GridBagConstraints();
        teksti.add(tekstikentta, komponentit.asettele(c1, 0, 0));
        lisaaPaneliRaameihin(teksti);
    }
 /**
 * Metodi asettaa raameihin valinkkopanelin ja lisää sille napit.
 * 
 */
        
    public void luoValikko() { 
        valikko = komponentit.luoPaneli(5, 5, 700, 50); 
        valikko.setBackground(Color.darkGray);
        GridBagConstraints c2 = new GridBagConstraints();
        teeValikkoNapit();
        
        toiminta.lisaaActionListenerHelp(valikkonapit.get(0)); //help
        toiminta.lisaaActionListenerVakio(valikkonapit.get(1), tekstikentta, operaattorinapit); //vakio
        toiminta.lisaaActionListenerLasku(valikkonapit.get(2), tekstikentta); //lasku
        toiminta.lisaaActionListenerListaa(valikkonapit.get(3)); //listaa

        valikko.add(valikkonapit.get(0), komponentit.asettele(c2, 40, 50));
        valikko.add(valikkonapit.get(1), komponentit.asettele(c2, 50, 50));
        valikko.add(valikkonapit.get(2), komponentit.asettele(c2, 60, 50));
        valikko.add(valikkonapit.get(3), komponentit.asettele(c2, 70, 50));
        
        lisaaPaneliRaameihin(valikko);
    }
/**
 * Metodi tekee numeropanelin ja lisää siihen numeronapit ja operaattorinapit.
 *
 */    

    public void lisaaNumeroPaneli() {
        
        numeropaneli = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        komponentit.luoNumeronapit(numeronapit, toiminta, tekstikentta);
        lisaaNumeroNappulat(c, numeropaneli);
        lisaaOperaattoriNappulat(c, numeropaneli);
    }
    
/**
 * Metodi lisää numeronapit paneliin.
 * @param c koordinaatiosto
 * @param numeropaneli paneli johoon tulee numeronapit.
 * 
 */       
    
    public void lisaaNumeroNappulat(GridBagConstraints c, JPanel numeropaneli) {       
        
        numeropaneli.add(numeronapit.get(1), komponentit.asettele(c, 0, 1));
        numeropaneli.add(numeronapit.get(2), komponentit.asettele(c, 1, 1));
        numeropaneli.add(numeronapit.get(3), komponentit.asettele(c, 2, 1));        
        numeropaneli.add(numeronapit.get(4), komponentit.asettele(c, 0, 2));
        numeropaneli.add(numeronapit.get(5), komponentit.asettele(c, 1, 2));
        numeropaneli.add(numeronapit.get(6), komponentit.asettele(c, 2, 2));
        numeropaneli.add(numeronapit.get(7), komponentit.asettele(c, 0, 3));
        numeropaneli.add(numeronapit.get(8), komponentit.asettele(c, 1, 3));
        numeropaneli.add(numeronapit.get(9), komponentit.asettele(c, 2, 3));
        numeropaneli.add(numeronapit.get(0), komponentit.asettele(c, 1, 4));
    }
 /**
 * Metodi tekee operaattoreille napit.
 * 
 */    
    
    public void teeOperaattoriNappulat() {
        komponentit.luoOperaattoriNappulat(operaattorinapit);
        operaattorinapitLisaaToiminta();   
    }
 /**
 * Metodi lisää toiminnallisuuden operaattorinappeihin.
 */    

    public void operaattorinapitLisaaToiminta() {
        
        toiminta.lisaaActionListenerTulos(operaattorinapit.get(0), tekstikentta);
        toiminta.lisaaActionListenerTyhjennys(operaattorinapit.get(1), tekstikentta);
        toiminta.lisaaActionListenerlaskutoimitusnapeille(operaattorinapit, tekstikentta);
        toiminta.lisaaActionListenerPilkulle(operaattorinapit.get(8), tekstikentta);
        toiminta.lisaaActionListenerMuista(operaattorinapit.get(9), tekstikentta);
    
    }
 /**
 * Metodi asettelee operaattorinapit parametrina saatuun paneliin.
 * @param c koordinaatisto 
 * @param numeropaneli paneli johon operaattorinapit lisätään.
 */        
 
    public void lisaaOperaattoriNappulat(GridBagConstraints c, JPanel numeropaneli) {
        
        teeOperaattoriNappulat(); 
        numeropaneli.add(operaattorinapit.get(1), komponentit.asettele(c, 0, 4));
        numeropaneli.add(operaattorinapit.get(0), komponentit.asettele(c, 2, 4));
        numeropaneli.add(operaattorinapit.get(2), komponentit.asettele(c, 4, 1));
        numeropaneli.add(operaattorinapit.get(3), komponentit.asettele(c, 5, 1));
        numeropaneli.add(operaattorinapit.get(4), komponentit.asettele(c, 4, 2));
        numeropaneli.add(operaattorinapit.get(5), komponentit.asettele(c, 5, 2));
        numeropaneli.add(operaattorinapit.get(6), komponentit.asettele(c, 4, 3));
        numeropaneli.add(operaattorinapit.get(7), komponentit.asettele(c, 5, 3));  
        numeropaneli.add(operaattorinapit.get(8), komponentit.asettele(c, 4, 4));
        numeropaneli.add(operaattorinapit.get(9), komponentit.asettele(c, 5, 4));
        lisaaPaneliRaameihin(numeropaneli);
    }
 /**
 * Metodi tekee valikkonapit.
 * 
 */    
    public void teeValikkoNapit() {
 
        valikkonapit.add(new JButton("help"));
        valikkonapit.add(new JButton("vakio"));
        valikkonapit.add(new JButton("lasku"));
        valikkonapit.add(new JButton("listaa"));
    }
/**
 * Metodi lisää parametrina annetun panelin raameihin.
 *@param paneli raameihin lisättävä paneli.
 */       
     
    public void lisaaPaneliRaameihin(JPanel paneli) {
        reunat.add(paneli);
    }
}