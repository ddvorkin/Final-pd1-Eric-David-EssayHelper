/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
/**
 *
 * @author Hobo
 */
public class Dictionary {
        

    public Dictionary(String toDefine){
        try{
            Document definitionDoc = Jsoup.connect(
                    "http://www.oxforddictionaries.com/us/definition/american_english/" + toDefine
            ).followRedirects(true).get();
            this.findInformationOxford(definitionDoc);
            
    }
        catch(IOException e){
            System.out.println("eror");
        }
    }
    

    
    private ArrayList findInformationOxford(Document definitionDoc){
    
        String definition = definitionDoc.toString();
        
        int wordIndexCounter = 0;
        int definitionIndexCounter = 0;
        int SentenceIndexCounter = 0;
        
        ArrayList<String> informationArray = new ArrayList();

        
        definition = definition.substring(definition.indexOf("class=\"senseGroup\""));
        while (definition.contains("class=\"iteration\"")){
                            
            if (definition.contains("class=\"partOfSpeech\"")){
                definition = definition.substring(definition.indexOf("class=\"partOfSpeech\""));
                informationArray.add(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")));
            }
            else{
                definition = definition.substring(definition.indexOf("<h4>"));
                informationArray.add(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")));
            }
            definition = definition.substring(definition.indexOf("class=\"definition\""));
            informationArray.add(definition.substring(definition.indexOf(">") + 1,definition.indexOf(":")));
            definition = definition.substring(definition.indexOf("class=\"example\""));
            informationArray.add(definition.substring(definition.indexOf(">") + 1,definition.indexOf("<")));
            
            System.out.println("++++++++++++++++++++++++");
            System.out.println(definition);
            System.out.println(informationArray);
            System.out.println("________________________");
        }

        //System.out.println(returnVariable[0]);
        //System.out.println(returnVariable[1]);
        
        return informationArray;
    }
    
    
    
 /*
 * Main method is temporary as fuck
 * Excuse my french please
 * 
 */
    public static void main(String[] args){
        Dictionary test = new Dictionary("what");
    }
}
