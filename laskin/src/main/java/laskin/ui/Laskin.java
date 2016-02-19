package laskin.laskin;

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
    public GUI graafinen;
    //public TUI teksti;
    
    public Laskin() {
        graafinen = new GUI();
        //teksti = new TUI();
    }    
    public void kayta() {
        
        luoUusiLaskin();
        graafinen.kaytto();
        //teksti.kaytto();
    }
    public void luoUusiLaskin() {
        
        reunat = new JFrame("Laskin");
        reunat.setSize(700, 400);
        reunat.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoTekstikentta();
        luoValikko();
        lisaaNumeroPaneli();
        reunat.setVisible(true);
        
    }
    
    public void luoTekstikentta() {
        
        tekstikentta = new JTextField("", 12);
        teksti = new JPanel(new GridBagLayout());
        teksti.setBounds(5, 60 , 700 , 50);
        teksti.setBackground(Color.WHITE);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        teksti.add(tekstikentta, c1);
        lisaaPaneliRaameihin(teksti);
    }
 
        
    public void luoValikko() { 
        valikko = new JPanel(new GridBagLayout());
        valikko.setBounds(5, 5 , 700 , 50);
        valikko.setBackground(Color.darkGray);
        GridBagConstraints c2 = new GridBagConstraints();
        teeValikkoNapit();
        
        graafinen.lisaaActionListenerHelp(valikkonapit.get(0)); //help
        graafinen.lisaaActionListenerVakio(valikkonapit.get(1)); //vakio
        graafinen.lisaaActionListenerLasku(valikkonapit.get(2), tekstikentta); //lasku
        graafinen.lisaaActionListenerListaa(valikkonapit.get(3)); //listaa
        
        c2.gridx = 40; 
        c2.gridy = 50;
        valikko.add(valikkonapit.get(0), c2);
        c2.gridx = 50;
        c2.gridy = 50;
        valikko.add(valikkonapit.get(1), c2);
        c2.gridx = 60;
        c2.gridy = 50;
        valikko.add(valikkonapit.get(2), c2);
        c2.gridx = 70;
        c2.gridy = 50;
        valikko.add(valikkonapit.get(3), c2);
        
        lisaaPaneliRaameihin(valikko);
    }
        
    public void lisaaNumeroPaneli() {
        
        numeropaneli = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        luoNumeronapit();
        lisaaNumeroNappulat(c, numeropaneli);
        lisaaOperaattoriNappulat(c, numeropaneli);
    }
    
    public void luoNumeronapit() {
        for (int i = 0; i < 10; i++) {  
            numeronapit.add(new JButton(Integer.toString(i)));
            graafinen.lisaaActionListenerNumeronapeille(numeronapit.get(i), i, tekstikentta);
        }
    }
    
    public void lisaaNumeroNappulat(GridBagConstraints c, JPanel numeropaneli) {       
        c.gridx = 0;
        c.gridy = 1;
        numeropaneli.add(numeronapit.get(1), c);
        c.gridx = 1;
        c.gridy = 1;
        numeropaneli.add(numeronapit.get(2), c);
        c.gridx = 2;
        c.gridy = 1;
        numeropaneli.add(numeronapit.get(3), c);        
        c.gridx = 0;
        c.gridy = 2;
        numeropaneli.add(numeronapit.get(4), c);
        c.gridx = 1;
        c.gridy = 2;
        numeropaneli.add(numeronapit.get(5), c);
        c.gridx = 2;
        c.gridy = 2;
        numeropaneli.add(numeronapit.get(6), c);
        c.gridx = 0;
        c.gridy = 3;
        numeropaneli.add(numeronapit.get(7), c);
        c.gridx = 1;
        c.gridy = 3;
        numeropaneli.add(numeronapit.get(8), c);
        c.gridx = 2;
        c.gridy = 3;
        numeropaneli.add(numeronapit.get(9), c);
        c.gridx = 1;
        c.gridy = 4;
        numeropaneli.add(numeronapit.get(0), c);
    }
    public void teeOperaattoriNappulat() {
        operaattorinapit.add(new JButton("="));
        operaattorinapit.add(new JButton("C"));
        operaattorinapit.add(new JButton("+"));
        operaattorinapit.add(new JButton("-"));
        operaattorinapit.add(new JButton("/"));
        operaattorinapit.add(new JButton("*"));
        operaattorinapit.add(new JButton("^"));
        operaattorinapit.add(new JButton("r"));
        operaattorinapit.add(new JButton(","));
        operaattoriNappulatLisaaToiminta();
        
    }
   
    public void operaattoriNappulatLisaaToiminta() {
        graafinen.lisaaActionListenerOperaattorinapeille(operaattorinapit, tekstikentta);
    }
    
    public void lisaaOperaattoriNappulat(GridBagConstraints c, JPanel numeropaneli) {
        teeOperaattoriNappulat(); 
        c.gridx = 0;
        c.gridy = 4;
        numeropaneli.add(operaattorinapit.get(1), c);
        c.gridx = 2;
        c.gridy = 4;
        numeropaneli.add(operaattorinapit.get(0), c);
        c.gridx = 4;
        c.gridy = 1;
        numeropaneli.add(operaattorinapit.get(2), c);
        c.gridx = 5;
        c.gridy = 1;
        numeropaneli.add(operaattorinapit.get(3), c);
        c.gridx = 4;
        c.gridy = 2;
        numeropaneli.add(operaattorinapit.get(4), c);
        c.gridx = 5;
        c.gridy = 2;
        numeropaneli.add(operaattorinapit.get(5), c);
        c.gridx = 4;
        c.gridy = 3;
        numeropaneli.add(operaattorinapit.get(6), c);
        c.gridx = 5;
        c.gridy = 3;
        numeropaneli.add(operaattorinapit.get(7), c);  
        c.gridx = 4;
        c.gridy = 4;
        numeropaneli.add(operaattorinapit.get(8), c);
        lisaaPaneliRaameihin(numeropaneli);
    }
    
    public void teeValikkoNapit() {
 
        valikkonapit.add(new JButton("help"));
        valikkonapit.add(new JButton("vakio"));
        valikkonapit.add(new JButton("lasku"));
        valikkonapit.add(new JButton("listaa"));
    }
        
    public void lisaaPaneliRaameihin(JPanel paneli) {
        reunat.add(paneli);
    }
}