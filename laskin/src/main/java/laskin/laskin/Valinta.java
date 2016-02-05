
package laskin.laskin;

public class Valinta {

    Vakiomuistio muistio = new Vakiomuistio("atm", 101325);
    
    public Valinta(){
    
    }

    public String loppu(){
        return "hei hei!";
    }

    public String help(){
        return "\nlasku: suorita laskutoimitus\nvakio: lisää vakio muistiin\nloppu: lopettaa\nlistaa: listaa muistion vakiot\n";
    }        
    
    public boolean tutkiOnkoVakioMuistissa(String symboli){
        return muistio.tutkiOnkoVakioMuistissa(symboli);
        
    }
    
    public double palautaMuistiostaVakionArvo(String symboli) {
        
        return muistio.palautaVakionArvo(symboli);
        
    }
    
    public void lisaaVakioMuistioon(String symboli, double arvo) {
        muistio.lisaaVakioMuistioon(symboli, arvo);
        
        
    }
    
    public boolean voikoLuvunMaarittaa(String luku){
        return tutkiOnkoVakioMuistissa(luku)== true || onkoNumero(luku)== true;
    }
    
    public double maaritaLuku(String luku){
        double numero;
        if (onkoNumero(luku) == true) {
            numero = Double.parseDouble(luku); 
            } else {
                numero = palautaMuistiostaVakionArvo(luku);
        }
        return numero;
    }
    
    public boolean onkoNumero(String luku){
        try { 
            double k =  Double.parseDouble(luku); 
        } catch (NumberFormatException n) {  
            return false; 
        }  
        return true; 
    }  
    
    public boolean onkoOperaattoriValikossa(String merkki) {
   
        return "+".equals(merkki)||"-".equals(merkki)||"*".equals(merkki)||"/".equals(merkki)||"^".equals(merkki)||"r".equals(merkki);
    }
    
    public String listaaKaikki(){
        
        return muistio.toString();
    }
    
}