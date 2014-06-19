package Thesaurus;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.util.*;


public class Thesaurus {

 private String synonyms;

        public Thesaurus(String toDefine){
            toDefine = toDefine.toLowerCase();
            toDefine = toDefine.replace(" ", "-");
            try{
                //System.setProperty("http.proxyHost", "149.89.1.30");
                //System.setProperty("http.proxyPort", "3128");
                Document synonymDoc = Jsoup.connect(
                        "http://www.macmillandictionary.com/thesaurus/american/" + toDefine
                ).followRedirects(true).get();

                synonyms = synonymDoc.toString();
                synonyms = synonyms.substring(synonyms.indexOf("<span class=\"synonyms\">"));
                synonyms = synonyms.substring(synonyms.indexOf("title="));
                StringTokenizer tokenizer = new StringTokenizer(synonyms);
                synonyms = "";

                while (tokenizer.hasMoreTokens()){
                    String curToken = tokenizer.nextToken();
                    if (curToken.contains("title=") && curToken.contains(">")){
                            curToken = curToken.substring(curToken.indexOf(">") + 1);
                            curToken = curToken.substring(0,curToken.indexOf("<"));
                        }
                        synonyms = synonyms + curToken + " ";
                    }
                }
            
            catch(IOException e){
                synonyms = "Unknown Word.";
            }
        }

        public String getSynonyms(){
            return synonyms;
        }
}