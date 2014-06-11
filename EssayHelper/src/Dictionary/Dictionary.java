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
    
    private String definition;
        
    public Dictionary(String toDefine){
        toDefine = toDefine.toLowerCase();
        toDefine = toDefine.replace(" ", "-");
        try{
            System.setProperty("http.proxyHost", "149.89.1.30");
            System.setProperty("http.proxyPort", "3128");
            Document definitionDoc = Jsoup.connect(
                    "http://www.macmillandictionary.com/us/dictionary/american/" + toDefine
            ).followRedirects(true).get();
            
            definition = definitionDoc.toString();
            definition = definition.substring(definition.indexOf("<span class=\"DEFINITION\">"));
            definition = definition.substring(definition.indexOf("</span>"), definition.lastIndexOf("</span>") + 20);
            StringTokenizer tokenizer = new StringTokenizer(definition);
            definition = "";
            
            String tempToken = "";
            while (tokenizer.hasMoreTokens()){
                String curToken = tokenizer.nextToken();
                if (curToken.contains("title=") && curToken.contains(">")){
                    definition = definition + curToken.substring(curToken.indexOf(">"), curToken.lastIndexOf(">")) + "";
                    definition = definition.replaceAll("</a>", " ");
                    definition = definition.replaceAll(">", "");
                    definition = definition.replaceAll("</span", "");
                    definition = definition.replaceAll("</a.", " ");
                    definition = definition.trim();
                    definition = definition.substring(0,1).toUpperCase() + definition.substring(1) + ".";
                }
            }
        }
        catch(Exception e){
            definition = "Definition not found.";
            System.out.println(definition);
        }
    }
        
    public String getDefinition(){
        return definition;
    }
    

    public static void main(String[] args){
        Dictionary test = new Dictionary("home page");
        System.out.println(test.getDefinition());
    }
}
