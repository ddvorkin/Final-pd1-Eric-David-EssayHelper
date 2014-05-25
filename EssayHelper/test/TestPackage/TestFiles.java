/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestPackage;
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
public class TestFiles {
    public static void main(String[] args){
        String html = "<html><head><title>First parse</title></head>"
    + "<body><p>Parsed HTML into a doc.</p></body></html>";
         Document doc = Jsoup.parse(html);
        System.out.println(doc);
    }
}
