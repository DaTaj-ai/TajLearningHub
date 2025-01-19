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
		
		//  
		btu1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			counter++ ; 
			repaint();
		}
	});
	
	
		
		MyActionListenerDecrements myActionListenerDecrements = new MyActionListenerDecrements(); 
		btu2.addActionListener(myActionListenerDecrements);
		
		add(btu1);
		add(btu2);
		}
		
	
	
	class MyActionListenerDecrements implements ActionListener {

		public void actionPerformed(ActionEvent e){
			counter-- ; 
			repaint();
		}
	}
	
			
	public void paint(Graphics g){
			g.drawString("this is the Counter " + counter ,50,50);
		}
	}


