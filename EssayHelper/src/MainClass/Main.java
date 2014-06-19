package MainClass;
import java.util.*;
import Dictionary.Dictionary;
import Thesaurus.Thesaurus;


public class Main {

    static ArrayList<String> outArgs = new ArrayList();
    
    public String mainDictionary(ArrayList<String> args){
        //Expected: [Dictionary, Word to Define]
        Dictionary dictionary = new Dictionary(args.get(1));
        return dictionary.getDefinition();
    }
    
    public String mainThesuarus(ArrayList<String> args){
        Thesaurus thesaurus = new Thesaurus(args.get(1));
        return thesaurus.getSynonyms();
    }
    
    public static void main(String[] args) {
       System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
       System.out.println("You are using EssayHelper");
       System.out.println("_________________________");
       System.out.println("Created by Eric Cheang and David Dvorkin");
       System.out.println("_________________________");
       System.out.println("Please choose your desired application by trping what you want in this syntax");
       System.out.println("APPLICATION ARGUMENTS");
       
       
       Scanner scan = new Scanner(System.in);
       String storedArgs = scan.nextLine();
       StringTokenizer tokenizer = new StringTokenizer(storedArgs);
       Main mainClass = new Main();
       
       while (tokenizer.hasMoreTokens()){
           outArgs.add(tokenizer.nextToken());
       }
       if (outArgs.get(0).equalsIgnoreCase("dictionary")){
           System.out.println(mainClass.mainDictionary(outArgs));
           try{
               Thread.sleep(3000);
           }
           catch(InterruptedException e){
               
           }
       }
       if (outArgs.get(0).equalsIgnoreCase("thesaurus")){
           System.out.println(mainClass.mainThesuarus(outArgs));
           try{
               Thread.sleep(3000);
           }
           catch(InterruptedException e){
               
           }
       }
    }
}
