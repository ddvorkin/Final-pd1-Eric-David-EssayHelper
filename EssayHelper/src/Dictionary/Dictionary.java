

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
            this.findInformationOxford(definitionDoc, toDefine);
            
    }
        catch(IOException e){
            System.out.println("eror");
        }
    }
    

    
    private ArrayList findInformationOxford(Document definitionDoc, String word){
    
        String definition = definitionDoc.toString();
        definition = definition.substring(definition.indexOf("class=\"senseGroup\""));
        ArrayList<DLinkedListNode> informationArray = new ArrayList();
        DLinkedListNode next = new DLinkedListNode("DUMMY", "DUMMY");
        DLinkedListNode prev = next;
        boolean whileBreaker = false;
                
        while(!whileBreaker){
            if (definition.contains("class=\"partOfSpeech\"")){
                definition = definition.substring(definition.indexOf("class=\"partOfSpeech\""));
                DLinkedListNode newData = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Word-partOfSpeech");
                definition = definition.substring(definition.indexOf("class=\"partOfSpeech\"") + 20);   
                prev.setNext(newData);
                newData.setPrev(prev);
                next = newData;
                
                
                if (definition.contains("class=\"definition\"")){
                    definition = definition.substring(definition.indexOf("class=\"definition\""));
                    DLinkedListNode newData1 = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Word-Definition");
                    newData.setNext(newData1);
                    newData1.setPrev(newData);
                    definition = definition.substring(definition.indexOf("class=\"definition\"") + 18);
                    
                    if (definition.contains("class=\"example\"")){
                        definition = definition.substring(definition.indexOf("class=\"example\""));
                        DLinkedListNode newData2 = new DLinkedListNode(definition.substring(definition.indexOf(">")+1, definition.indexOf("<")), "Word-Example");
                        newData1.setNext(newData2);
                        newData2.setPrev(newData1);
                        definition = definition.substring(definition.indexOf("class=\"example\"") + 15);
                }
                    else{
                        DLinkedListNode newData2 = new DLinkedListNode("EMPTY", "Word-Example");
                        newData1.setNext(newData2);
                        newData2.setPrev(newData1);
                    }   
            }
                else{
                    DLinkedListNode newData1 = new DLinkedListNode("EMPTY", "Word-Definition");
                    newData.setNext(newData1);
                    newData1.setPrev(newData);
                }
        }
            else{
                if (definition.contains("class=\"definition\"")){
                    definition = definition.substring(definition.indexOf("class=\"definition\""));
                    DLinkedListNode newData3 = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Phrase-Definition");
                    newData3.setNext(newData1);
                    newData1.setPrev(newData);
                    definition = definition.substring(definition.indexOf("class=\"definition\"")
                }
            }

        System.out.println(definition);
        return informationArray;
    }
    
    
    
 /*
 * 
 */
    public static void main(String[] args){
        Dictionary test = new Dictionary("Sensible");
    }
}