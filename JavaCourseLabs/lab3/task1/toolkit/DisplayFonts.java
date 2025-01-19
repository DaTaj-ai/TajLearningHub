import java.awt.Graphics ;
import java.applet.Applet;
import java.awt.Toolkit ;
import java.awt.Font;

public class DisplayFonts extends Applet{
	Toolkit t ; 
	String[] s ; 
	
	public void init(){
		t= Toolkit.getDefaultToolkit();
		s = t.getFontList();
		System.out.println("this is the initialization "); 
			}
			
	public void paint(Graphics g){	 
	
		for(int i = 0 ; i <s.length ; i++){	
			Font font = new Font(s[i],Font.BOLD,30);
			g.setFont(font);
			g.drawString(s[i],50,50+(i*30));}
		}
	}
