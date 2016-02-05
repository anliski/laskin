
package laskin.laskin;

import laskin.ui.TUI;


public class Laskin {

    TUI teksti;
    
    public Laskin() {
        teksti = new TUI();
        
    }
    
    public void kauta() {
        teksti.kautto();
    }
}