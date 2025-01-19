import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 

public class DigtalWatch extends Applet implements Runnable{
	
		
	
	Thread th ;
	 	
	public void init(){
		DigtalWatch d = this ;  
		th = new Thread(this);
		th.start();			 
	}
			
	public void paint(Graphics g){
			Date D = new Date() ; 
			g.drawString(D.toString(),50,50);
		}
	public void run (){
		while(true){
			try{
				Thread.sleep(100);
				repaint();
				Thread.sleep(100); 
			
			}
			catch(InterruptedException e){
				System.out.println("this is from Expetion");
			}
			
			}
		}

}
