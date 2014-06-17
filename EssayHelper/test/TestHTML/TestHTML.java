package TestHTML;
import java.io.*;
import java.util.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

    
public class TestHTML extends JFrame {
        void start()
{       
	try
	{
            String html = "";
            File HTML = new File("C:\\Users\\Hobo\\Documents\\GitHub\\Final-pd1-Eric-David-EssayHelper\\EssayHelper\\test\\TestHTML\\index.html");
            
            Scanner scan = new Scanner(HTML);
            while (scan.hasNext()){
                html+=scan.nextLine();
            }
	JEditorPane ed1=new JEditorPane("text/html",html);
	add(ed1);
	setVisible(true);
	setSize(600,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Some problem has occured"+e.getMessage());
	}
}
        public static void main(String args[])
{
	new TestHTML().start();
	
}
}
    
    
