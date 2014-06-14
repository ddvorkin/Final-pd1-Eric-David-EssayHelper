package Dictionary;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.util.*;

public class Dictionary {
    
    private String definition;
        
    public Dictionary(String toDefine){
        toDefine = toDefine.toLowerCase();
        toDefine = toDefine.replace(" ", "-");
        try{
            //System.setProperty("http.proxyHost", "149.89.1.30");
            //System.setProperty("http.proxyPort", "3128");
            Document definitionDoc = Jsoup.connect(
                    "http://www.macmillandictionary.com/us/dictionary/american/" + toDefine
            ).followRedirects(true).get();
            
            definition = definitionDoc.toString();
            definition = definition.substring(definition.indexOf("<span class=\"DEFINITION\">"));
            definition = definition.substring(definition.indexOf("</span>"), definition.lastIndexOf("</span>") + 20);
            StringTokenizer tokenizer = new StringTokenizer(definition);
            definition = " ******** \n ";
            
            while (tokenizer.hasMoreTokens()){
                String curToken = tokenizer.nextToken();
                if (curToken.contains("title=") && curToken.contains(">")){
                    if (curToken.contains("</span>")){
                        curToken = curToken.substring(curToken.indexOf(">") + 1);
                        curToken = curToken.substring(0,curToken.indexOf("<"));
                        curToken = curToken + ". \n ******** \n";
                    }
                    else{
                        curToken = curToken.substring(curToken.indexOf(">") + 1);
                        curToken = curToken.substring(0,curToken.indexOf("<"));
                    }
                    definition = definition + curToken + " ";
                }
            }
        }
        catch(Exception e){
            definition = "Definition not found.";
        }
    }
        
    public String getDefinition(){
        return definition;
    }
}
