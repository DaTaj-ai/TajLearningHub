import java.awt.Graphics ;
import java.applet.Applet;

public class HelloApplet extends Applet{
      public void paint(Graphics g){
	 String s = getParameter("name");
	 g.drawString("Hello Java"+s ,50,50);
	System.out.println(s);
				}
	}
