

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
                    "http://www.oxforddictionaries.com/us/definition/american_english/" + toDefine
            ).followRedirects(true).get();
            DLinkedListNode hullo = this.findInformationOxford(definitionDoc, toDefine);
            System.out.println( "HULLO HULLO HULLO \n" + hullo);
            System.out.println(hullo.getNext());
            System.out.println(hullo.getNext().getNext());
    }
        catch(IOException e){
            System.out.println("eror");
        }
    }
    

    
    private DLinkedListNode findInformationOxford(Document definitionDoc, String word){
           

        String definition = definitionDoc.toString();
        definition = definition.substring(definition.indexOf("class=\"senseGroup\""));
        DLinkedListNode prev = new DLinkedListNode("DUMMY", "DUMMY");
        DLinkedListNode first = new DLinkedListNode("DUMMY","DUMMY");
        boolean whileBreaker1 = false;
        boolean whileBreaker2 = false;
        
        System.out.println(definition);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                
        while(!whileBreaker1 && !whileBreaker2){
            if (definition.contains("class=\"partOfSpeech\"")){
                definition = definition.substring(definition.indexOf("class=\"partOfSpeech\""));
                DLinkedListNode newData = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Word-partOfSpeech");
                definition = definition.substring(definition.indexOf("class=\"partOfSpeech\"") + 20);   
                prev.setNext(newData);
                newData.setPrev(prev);
                prev = newData;
                first = newData;
                
                
                
                if (definition.contains("class=\"definition\"")){
                    definition = definition.substring(definition.indexOf("class=\"definition\""));
                    DLinkedListNode newData1 = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Word-Definition");
                    prev.setNext(newData1);
                    newData1.setPrev(prev);
                    prev = newData1;
                    definition = definition.substring(definition.indexOf("class=\"definition\"") + 18);

                    
                    if (definition.contains("class=\"example\"") || definition.contains("class=\"sentence\"")){
                        if (definition.indexOf("class=\"example\"") < definition.indexOf("class=\"sentence\"")){
                            definition = definition.substring(definition.indexOf("class=\"example\""));
                            DLinkedListNode newData2 = new DLinkedListNode(definition.substring(definition.indexOf(">")+1, definition.indexOf("<")), "Word-Example");
                            prev.setNext(newData2);
                            newData2.setPrev(prev);
                            prev = newData1;
                            definition = definition.substring(definition.indexOf("class=\"example\"") + 15);                           
                        }
                        else{
                            definition = definition.substring(definition.indexOf("class=\"sentence\""));
                            DLinkedListNode newData2 = new DLinkedListNode(definition.substring(definition.indexOf(">")+1, definition.indexOf("<")), "Word-Example");
                            prev.setNext(newData2);
                            newData2.setPrev(prev);
                            prev = newData1;
                            definition = definition.substring(definition.indexOf("class=\"sentence\"") + 16); 
                        }
                        
                }
                    else{
                        DLinkedListNode newData2 = new DLinkedListNode("EMPTY", "Word-Example");
                        prev.setNext(newData2);
                        newData2.setPrev(prev);
                        prev = newData1;
                    }   
            }
                else{
                    DLinkedListNode newData1 = new DLinkedListNode("EMPTY", "Word-Definition");
                    prev.setNext(newData1);
                    newData1.setPrev(prev);
                    prev = newData1;
                }
        }
            else{
                whileBreaker1 = true;
                if (definition.contains("class=\"definition\"")){
                    definition = definition.substring(definition.indexOf("class=\"definition\""));
                    DLinkedListNode newData3 = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Phrase-Definition");
                    prev.setNext(newData3);
                    newData3.setPrev(prev);
                    prev = newData3;
                    definition = definition.substring(definition.indexOf("class=\"definition\"") + 18);
                    first = newData3;
                    
                    if (definition.contains("class=\"sentence\"")){
                        definition = definition.substring(definition.indexOf("class=\"sentence\""));
                        DLinkedListNode newData4 = new DLinkedListNode(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")), "Phrase-Sentence");
                        prev.setNext(newData4);
                        newData4.setPrev(prev);
                        prev = newData4;
                        definition = definition.substring(definition.indexOf("class=\"sentence\""));
                    }
                    else{
                        DLinkedListNode newData4 = new DLinkedListNode("EMPTY", "Phrase-Sentence");
                        prev.setNext(newData4);
                        newData4.setPrev(prev);
                        prev = newData4;
                    }
                }
                else{
                    whileBreaker2 = false;
                    
                }                      
            }
        }

        System.out.println(definition);
        return first;
    }
    
    
    
 /*
 * 
 */
    public static void main(String[] args){
        Dictionary test = new Dictionary("dragoon");
    }
}