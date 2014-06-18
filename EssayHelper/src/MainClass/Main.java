
package MainClass;

public class Main {

    public String mainDictionary(String[] args){
        //Expected: [Dictionary, Word to Define]
        Dictionary.Dictionary dictionary = new Dictionary.Dictionary(args[1]);
        return dictionary.getDefinition();
    }
    
    public static void main(String[] args) {
        Main mainClass = new Main();
        if (args[0].compareToIgnoreCase("dictionary") == 1){
            System.out.println(mainClass.mainDictionary(args));
        }
    }
    
}
