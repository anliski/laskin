
package laskin.laskin;


public class Laskutoimitus {

double luku1;
double luku2;
String operaattori;
double tulos;

public Laskutoimitus(double luku1, double luku2, String operaattori){    
    
    this.luku1 = luku1;
    this.luku2 = luku2;
    this.operaattori = operaattori; 
    this.tulos = 0;
}


public void laske(){
    
    if ("+".equals(this.operaattori)){
        pluslasku();
    }
    if ("-".equals(this.operaattori)){
        miinuslasku();
    }
    if ("*".equals(this.operaattori)){
        kertolasku();
    }   
    if ("/".equals(this.operaattori)){
        jakolasku();
    }
    if ("^".equals(this.operaattori)){
        potenssi();    
    }
    if ("r".equals(this.operaattori)){
        juuri();    
    }


}
public void pluslasku(){
    
    this.tulos = this.luku1 + this.luku2;
}
            
 public void miinuslasku(){
    
    this.tulos = this.luku1 - this.luku2;
             
}

 public void kertolasku(){
    
     this.tulos = this.luku1*this.luku2;   
}
 
  public void jakolasku(){
    
      if (this.luku2 != 0){
      this.tulos = this.luku1/this.luku2;
      }
      else {
      throw new IndexOutOfBoundsException("Nollalla ei voi jakaa.");
      }
}
    public void potenssi(){
        if (this.luku1 >= 0){ 
        this.tulos = Math.pow(this.luku1, this.luku2);
        }
        else{
        this.tulos = -Math.pow(-this.luku1, this.luku2);
        }
}
      public void juuri(){

        if (this.luku1 >= 0){ 
        this.tulos = Math.pow(this.luku1 , (1/this.luku2));
        }
        else{
        throw new IndexOutOfBoundsException("Ei ole reaalista juurta");
      }
            
}

 
  public double annaTulos(){
  
      return this.tulos;
  }


 
}
