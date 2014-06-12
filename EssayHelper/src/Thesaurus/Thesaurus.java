/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Thesaurus;
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
 * @author david.dvorkin
 */
public class Thesaurus {

 private String synonyms;

        public Thesaurus(String toDefine){
            toDefine = toDefine.toLowerCase();
            toDefine = toDefine.replace(" ", "-");
            try{
                //System.setProperty("http.proxyHost", "149.89.1.30");
                //System.setProperty("http.proxyPort", "3128");
                Document definitionDoc = Jsoup.connect(
                        "http://www.thesaurus.com" + toDefine
                ).followRedirects(true).get();

                synonyms = definitionDoc.toString();
                synonyms = synonyms.substring(synonyms.indexOf("<span class=\"synonyms\">"));
                synonyms = synonyms.substring(synonyms.indexOf("</span>"), synonyms.lastIndexOf("</span>") + 20);
                StringTokenizer tokenizer = new StringTokenizer(synonyms);
                synonyms = " ******** \n ";

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
                        synonyms = synonyms + curToken + " ";
                    }
                }
            }
            catch(Exception e){
                synonyms = "Definition not found.";
            }
        }

        public String getDefinition(){
            return synonyms;
        }
public static void main(String [ ] args){
        Thesaurus test = new Thesaurus("complex");
}
}