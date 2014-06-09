

package Dictionary;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.examples.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.safety.*;
import org.jsoup.select.*;
import java.io.*;
import java.util.*;

public class Dictionary2 {
        
    public Dictionary2(String toDefine){
        try{
            //System.setProperty("http.proxyHost", "149.89.1.30");
            //System.setProperty("http.proxyPort", "3128");
            Document definitionDoc = Jsoup.connect(
                    "http://www.oxforddictionaries.com/us/definition/american_english/" + toDefine
            ).followRedirects(true).get(); 
            System.out.println("Works");
            this.findInformationOxford(definitionDoc, toDefine);
    }
        catch(IOException e){
            System.out.println("eror");
        }
    }
    

    
    private void findInformationOxford(Document definitionDoc, String word){
           

        String definition = definitionDoc.toString();
        System.out.println(definition);
        
    }
        
 /*
 * 
 */
    public static void main(String[] args){
        Dictionary2 test = new Dictionary2("What");
    }
}