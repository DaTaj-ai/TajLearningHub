import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Button ; 
import java.awt.event.ActionEvent ; 
import java.awt.event.* ; 


public class Counter extends Applet {
	
	int counter ;  
	Button btu1 ; 
	Button btn2 ; 
	
	
	public void init(){		
		Button btu1 = new Button("Increments"); 
		Button btu2 = new Button("Decrements"); 	
		
		MyActionListener myActionListener = new MyActionListener(); 
		btu1.addActionListener(myActionListener);
		
		add(btu1);
		add(btu2);
		}
		
		
	class MyActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e){
		counter++ ; 
		repaint();
		}
	}
			
	public void paint(Graphics g){
			g.drawString("hello",50,50);
		}
	}


