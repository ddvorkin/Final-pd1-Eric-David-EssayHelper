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

public class Dictionary {
    
    
        
    public Dictionary(String toDefine){
        try{
            //System.setProperty("http.proxyHost", "149.89.1.30");
            //System.setProperty("http.proxyPort", "3128");
            Document definitionDoc = Jsoup.connect(
                    "http://www.macmillandictionary.com/us/dictionary/american/" + toDefine
            ).followRedirects(true).get();
            
            String definition = definitionDoc.toString();
            definition = definition.substring(definition.indexOf("<span class=\"DEFINITION\">"));
            definition = definition.substring(definition.indexOf("</span>"), definition.lastIndexOf("</span>") + 20);
            StringTokenizer tokenizer = new StringTokenizer(definition);
            definition = "";
            
            String tempToken = "";
            while (tokenizer.hasMoreTokens()){
                String curToken = tokenizer.nextToken();
                System.out.println(curToken);
                if (curToken.contains("title=")){
                    definition = definition + curToken.substring(curToken.indexOf(">"), curToken.lastIndexOf(">")) + " ";
                }
            }
            System.out.println(definition);
    }
        catch(IOException e){
            System.out.println("eror");
        }
    }
    

    public static void main(String[] args){
        Dictionary test = new Dictionary("dragoon");
    }
}