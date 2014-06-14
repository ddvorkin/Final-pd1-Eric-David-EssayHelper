public class Accents{
    public String accents;
    
    public Accents(){
	accents = "ÈÉÊËÛÙÏÎÀÂÔÖÇèéêëûùïîàâôöç";
    }

    public String accentlist(){
	accents = "ÈÉÊËÛÙÏÎÀÂÔÖÇèéêëûùïîàâôöç";
	return accents;
    }

    public static void main(String [] args){
	Accents t = new Accents();
	return Accents.accentlist();
    }
}
