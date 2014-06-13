/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

/**
 *
 * @author david.dvorkin
 */
import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class html extends JFrame
{
public static void main(String args[])
{ 
	new HtmlContent().start();
	
}

void start();
        String html;
{
	try
        {
        
	html="<html><head><title>Simple Page</title></head>";
	html+="<body><hr/><font size=50>Html content</font><hr/>";
	html+="</body></html>";
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
}
