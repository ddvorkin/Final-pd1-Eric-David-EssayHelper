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
        definition = definition.substring(definition.indexOf("class=\"senseGroup\""));
        
        ArrayList<DLinkedListNode> informationArray = new ArrayList();
        
        if ()

        System.out.println(definition);
        return informationArray;
    }
    
    
    
 /*
 * Main method is temporary as fuck
 * Excuse my french please
 * 
 */
    public static void main(String[] args){
        Dictionary test = new Dictionary("Sensible");
    }
}
