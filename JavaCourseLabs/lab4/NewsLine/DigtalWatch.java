import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 

public class DigtalWatch extends Applet implements Runnable{
	
		
	
	Thread th ;
	int x ; 
	public void init(){
		DigtalWatch d = this ;  
		th = new Thread(this);
		th.start();			 
	}
			
	public void paint(Graphics g){
			if(x < getWidth()){
			x+=4 ; 
			g.drawString("Hello Taj",x+30,50);
			}
			else{
				x = 0 ;  
			}
		}
	public void run (){
		while(true){
			try{
				Thread.sleep(100);
				repaint();
				//Thread.sleep(1000); 
			
			}
			catch(InterruptedException e){
				System.out.println("this is from Expetion");
			}
			
			}
		}

}
