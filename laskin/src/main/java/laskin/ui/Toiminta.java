
package laskin.ui;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import laskin.logiikka.Laskutoimitus;
import laskin.logiikka.Valinta;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Luokka sisältää nappien toiminnallisudet.
 */

public class Toiminta {
    

    public Valinta valinta = new Valinta();
    public String teksti;
    public int tila;
    public String symboli;
    public String arvo;
    public String luku1;
    public String operaattori;
    public String luku2;       
    public Laskutoimitus lasku;
    public ActionListener toiminta;
    
    public Toiminta() {
    }

    public void kaytto() {
        valinta = new Valinta();
    }
    
    public void lisaaActionListenerOperaattorinapeille(ArrayList<JButton> operaattorit, JTextField tekstikentta) {
        operaattorit.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (tila == 0){
                    luku2 = tekstikentta.getText();
                    if ((valinta.voikoLuvunMaarittaa(luku2)== true)){
                        lasku = new Laskutoimitus(valinta.maaritaLuku(luku1), valinta.maaritaLuku(luku2), operaattori);
                        lasku.laske();
                        tekstikentta.setText(Double.toString(lasku.annaTulos()));
                    }
            }
                if (tila == 1){
                    
                    if (valinta.tutkiOnkoVakioMuistissa(tekstikentta.getText()) == false & valinta.onkoNumero(tekstikentta.getText()) == false){
                        symboli = tekstikentta.getText();
                        tekstikentta.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Valitsemasi symboli on jo muistiossa ta se oli numero");
                    }
                }  
            }
        });
        operaattorit.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("");
            }
        });
        for (int i = 2; i <= 7; i++){
          actionOperaattorit(tekstikentta, operaattorit.get(i)); 
        }
        operaattorit.get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                teksti = tekstikentta.getText() + ",";
                tekstikentta.setText(teksti);
//tässä pitää tarkistaa että käyttäjä ei laita kahta pilkkua.
            }
        });  
        operaattorit.get(9).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (tila == 1){
                    if(valinta.onkoNumero(tekstikentta.getText()) == true){
                        arvo = tekstikentta.getText();
                        valinta.lisaaVakioMuistioon(symboli, valinta.maaritaLuku(arvo));
                        JOptionPane.showMessageDialog(null, "Lisääminen onnistui");
                    }
                    else{
                        tekstikentta.setText("");
                        JOptionPane.showMessageDialog(null, "Ei tainnut olla numero se... yritäppä uudelleen");
                    }
                }  
            }
        });         
    }
    public void actionOperaattorit(JTextField tekstikentta, JButton nappi){
        toiminta = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent a) {
            if (tila == 0){
                if ((valinta.voikoLuvunMaarittaa(tekstikentta.getText())== true)){
                    luku1 = tekstikentta.getText();
                    operaattori = nappi.getText();
                    tekstikentta.setText("");
                }
            }
        }
        };
        nappi.addActionListener(toiminta);    
    }
    
    public void lisaaActionListenerHelp(JButton help) {
            
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, valinta.help());
            }
        });
    }
    
    public void lisaaActionListenerListaa(JButton listaa) {
            
        listaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, valinta.listaaKaikki());
            }
        });
    }
        
    public void lisaaActionListenerLasku(JButton lasku, JTextField tekstikentta) {
            
        lasku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tila = 0;
            }
        });
    }    
    
    public void lisaaActionListenerVakio(JButton vakio, JTextField tekstikentta, ArrayList<JButton> operaattorit) {
        
        vakio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tila = 1;
                tekstikentta.setText("");
                }
        });
    }
                
public void lisaaActionListenerNumeronapeille(JButton nappi, int i, JTextField tekstikentta) {
        nappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                teksti = tekstikentta.getText() + Integer.toString(i);
                tekstikentta.setText(teksti);  
            }
        });   
    }
}


