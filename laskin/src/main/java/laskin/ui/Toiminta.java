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
    public ActionListener toiminta;
/**
 * Konstruktori.
 */ 
    public Toiminta() {
    }
/**
 * Metodi lisää tulos operaattorinapille sen toiminnon.
 * @param tulos nappi
 * @param tekstikentta 
 */    
    public void lisaaActionListenerTulos(JButton tulos, JTextField tekstikentta) {
        tulos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (tila == 0) {
                    luku2 = tekstikentta.getText();
                    if ((valinta.voikoLuvunMaarittaa(luku2) == true)) {
                        Laskutoimitus lasku = new Laskutoimitus(valinta.maaritaLuku(luku1), valinta.maaritaLuku(luku2), operaattori);
                        lasku.laske();
                        tekstikentta.setText(Double.toString(lasku.annaTulos()));
                    }
                }
                if (tila == 1) {                
                    if (valinta.tutkiOnkoVakioMuistissa(tekstikentta.getText()) == false & valinta.onkoNumero(tekstikentta.getText()) == false) {
                        symboli = tekstikentta.getText();
                        tekstikentta.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valitsemasi symboli on jo muistiossa tai se oli numero");
                    }
                }  
            }
        });
    }
 /**
 * Metodi lisää tyhjennysnapille sen toiminnon.
 * @param tyhjennys nappi
 * @param tekstikentta 
 */ 
    public void lisaaActionListenerTyhjennys(JButton tyhjennys, JTextField tekstikentta) {
        tyhjennys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("");
            }
        });
    }
 /** Metodi lisää kullekkin laskutoimitusnapille sen toiminnon.
 * @param operaattorit lista operaattorinapeista.
 * @param tekstikentta 
 */ 
    public void lisaaActionListenerlaskutoimitusnapeille(ArrayList<JButton> operaattorit, JTextField tekstikentta) {    
        for (int i = 2; i <= 7; i++) {
            actionOperaattorit(tekstikentta, operaattorit.get(i)); 
        }
    }
 /** Metodi lisää kullekkin pilkkunapille sen toiminnon.
 * @param piste nappi.
 * @param tekstikentta 
 */ 
    public void lisaaActionListenerPilkulle(JButton piste, JTextField tekstikentta) {
        piste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) { 
                if (tekstikentta.getText().contains(".") == false) {
                    teksti = tekstikentta.getText() + ".";
                    tekstikentta.setText(teksti); 
                }
            }
        });  
    }    
/**Metodi lisää muistinapille sen toiminnon.
 * @param muista nappi
 * @param tekstikentta 
 */ 
    public void lisaaActionListenerMuista(JButton muista, JTextField tekstikentta) {    
        muista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (tila == 1) {
                    if (valinta.onkoNumero(tekstikentta.getText()) == true) {
                        arvo = tekstikentta.getText();
                        valinta.lisaaVakioMuistioon(symboli, valinta.maaritaLuku(arvo));
                        JOptionPane.showMessageDialog(null, "Lisääminen onnistui");
                    } else {
                        tekstikentta.setText("");
                        JOptionPane.showMessageDialog(null, "Ei ollut numero");
                    }
                }  
            }
        });         
    }
/** Metodi lisää määrittelee toiminta actionListenerin napille.
 * @param tekstikentta tekstikenttä
 * @param nappi 
 */ 
    public void actionOperaattorit(JTextField tekstikentta, JButton nappi) {
        toiminta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (tila == 0) {
                    if ((valinta.voikoLuvunMaarittaa(tekstikentta.getText()) == true)) {
                        luku1 = tekstikentta.getText();
                        operaattori = nappi.getText();
                        tekstikentta.setText("");
                    }
                }
            }
        };
        nappi.addActionListener(toiminta);    
    }
 /** Metodi lisää help-valikkonapille sen toiminnan. 
 * @param help help-nappi
 */     
    public void lisaaActionListenerHelp(JButton help) {    
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, valinta.help());
            }
        });
    }
 /** Metodi lisää listaa-valikkonapille sen toiminnan.
 * @param listaa listaa-nappi
 */   
    public void lisaaActionListenerListaa(JButton listaa) {    
        listaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, valinta.listaaKaikki());
            }
        });
    }
 /** Metodi lisää lasku-valikkonapille sen toiminnan.
 * @param lasku lasku-nappi
 * @param tekstikentta tekstikenttä
 */      
    public void lisaaActionListenerLasku(JButton lasku, JTextField tekstikentta) {   
        lasku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("");
                tila = 0;
            }
        });
    }    
 /** Metodi lisää vakio-valikkonapille sen toiminnan.
 * @param vakio vakio-nappi
 * @param tekstikentta tekstikenttä
 * @param operaattorit lista operaattoirnapeista
 */    
    public void lisaaActionListenerVakio(JButton vakio, JTextField tekstikentta, ArrayList<JButton> operaattorit) {
        vakio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tekstikentta.setText("");  
                tila = 1;
            }
        });
    }
/**Metodi lisää numeronapeille niiden toiminnan.
 * @param nappi numeronappi
 * @param i napin numero
 * @param tekstikentta tekstikenttä johon asetetaan teksti kun nappia painetaan
 */     
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