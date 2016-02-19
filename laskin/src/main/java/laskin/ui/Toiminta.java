
package laskin.ui;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import laskin.laskin.Laskutoimitus;
import laskin.laskin.Valinta;

/**
 * Luokka sisältää nappien toiminnallisudet ja käyttöliittymän.
 */

public class GUI {
    

    public Valinta valinta;
    public String teksti;

    
    public GUI() {
    }
    
    
    public void kaytto() {
        valinta = new Valinta();
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
            public void actionPerformed(ActionEvent la) {
                String ekaluku = "";
                String tokaluku = "";
                String operaattori = "";
                    
                if ((valinta.voikoLuvunMaarittaa(ekaluku) == true && valinta.voikoLuvunMaarittaa(ekaluku) == true) && valinta.onkoOperaattoriValikossa(operaattori) == true) {
                    double luku1 = valinta.maaritaLuku(ekaluku);
                    double luku2 = valinta.maaritaLuku(tokaluku);
                    Laskutoimitus laskutoimitus = new Laskutoimitus(luku1, luku2, operaattori);
                    laskutoimitus.laske();
                    tekstikentta.setText(Double.toString(laskutoimitus.annaTulos()));
                } else { 
                    JOptionPane.showMessageDialog(null, "Tää ei toimi");
                        
                }
            }
        });
        
    }    
    
    public void lisaaActionListenerVakio(JButton vakio) {
            
        vakio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "ei valmis vielä");
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
    
    public void lisaaActionListenerOperaattorinapeille(ArrayList<JButton> operaattorit, JTextField tekstikentta) {
        operaattorit.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("TULOS");
            }
        });
        operaattorit.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("");
            }
        });
        operaattorit.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("+");
            }
        });
        operaattorit.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("-");
            }
        });
        operaattorit.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("/");
            }
        });
        operaattorit.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("*");
            }
        });
        operaattorit.get(6).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("^");
            }
        });
        operaattorit.get(7).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                tekstikentta.setText("r");
            }
        });
        operaattorit.get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                teksti = tekstikentta.getText() + ",";
                tekstikentta.setText(teksti);
            }
        });  
        
    }



}



