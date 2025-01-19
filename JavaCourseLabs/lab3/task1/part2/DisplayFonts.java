import java.awt.Graphics ;
import java.applet.Applet;
import java.awt.Toolkit ;
import java.awt.Font;
import java.awt.GraphicsEnvironment;



public class DisplayFonts extends Applet{
	GraphicsEnvironment G ; 	
	String[] s ; 
	
	public void init(){
		
		G = GraphicsEnvironment.getLocalGraphicsEnvironment();
		s = G.getAvailableFontFamilyNames();
		System.out.println("this is the initialization "); 
			}
			
	public void paint(Graphics g){	 
	
		for(int i = 0 ; i <s.length ; i++){	
			//System.out.println(s[i]);
			Font font = new Font(s[i],Font.BOLD,30);
			g.setFont(font);
			g.drawString(s[i],50,50+(i*30));}
		}
	}
	
