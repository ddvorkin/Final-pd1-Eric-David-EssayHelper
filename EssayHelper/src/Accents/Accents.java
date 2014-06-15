package Accents;

public class Accents{
        
    public String accents;
    
    public Accents(){
        accents = "\u00E1\u00E9\u00ED\u00F3\u00FA\u00C1\u00C9\u00CD\u00D3\u00DA\u00A1\u00BF";
    }
    
    public String getAccents(){
        return accents;
    }

    public static void main(String [] args){
        Accents newAccent = new Accents();
        System.out.println(newAccent.getAccents());
    }
}
