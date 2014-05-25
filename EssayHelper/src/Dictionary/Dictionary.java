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
        
    private final String TITLECAP ="" +
                               "<!DOCTYPE html>"+
                               "<!-- saved from url=(0052)http://foundation.zurb.com/templates/workspace.html# -->"+
                               "<html class=\" js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths\" lang=\"en\" data-useragent=\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
                               "<meta charset=\"utf-8\">"+
                               "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\"\"";


    
 /*
 * Dictionary()
 * Creates a Dictionary Class, with all final variables
 * Established
 */
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
    
    //Parses through all of the HTML code of the website of the dictionary
    //Will find the first instance of a information, parse it further to give just text.
    //Returns an array of String
    //[DEFINITION,REFUSE]
    //Refuse will be the rest of the string after the included definition.
    private String[] findInformationOxford(Document definitionDoc){
        String[] returnVariable = new String[2];
        String definition = definitionDoc.toString();
        definition = definition.substring(definition.indexOf("class=\"definition\""));
        returnVariable[1] = definition.substring(definition.indexOf("</span>"));
        definition = definition.substring(definition.indexOf("class=\"definition\""),definition.indexOf("</span>"));
        
        //System.out.println(returnVariable[0]);
        //System.out.println(returnVariable[1]);
        
        return returnVariable;
    }
    
    
    
 /*
 * Main method is temporary as fuck
 * Excuse my french please
 * 
 */
    public static void main(String[] args){
        Dictionary test = new Dictionary("Dragoon");
    }
}
