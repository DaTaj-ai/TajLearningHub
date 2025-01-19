import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Color;

public class Game extends Applet {
	
		
	
	Thread th ;
	int x ; 
	int y = 30 ; 
	int x2 = 90 ; 
	int y2 = 30 ;
	boolean xFlag = true ;
	boolean yFlag = true ; 
	 
	boolean x2Flag = true ;
	boolean y2Flag = true ; 
	 
	 
	public void init(){
		//DigtalWatch d = this ;
		
		th = new Thread(()->{
			while(true){
			try{
				Thread.sleep(100);
				repaint();
			
			}
			catch(InterruptedException e){
				System.out.println("this is from Expetion");
			}
			
			}
			
		});
		th.start();	
				 
	}
			

		public void paint(Graphics g){
		
		g.drawOval(x , y , 50 , 50);
		g.fillOval(x , y , 50 , 50);	
		
			if(xFlag){
				x+=10; 				
				if(x > getWidth()-50){
					xFlag = false ; 		
					}
				}
			else{
				x -=10 ; 				
				if(x < 0){
					xFlag = true ; 		
				} 
			}
			
			if(yFlag){
				y+=10; 
				if(y > getHeight()-50){
					yFlag = false ; 		
					}
				}
			else{
				y-=10 ;

				  				
				if(y < 0){
					yFlag = true ; 		
				} 
			}

			
		
		}
		
		
		}


/*		
		
	public void run (){
		while(true){
			try{
				Thread.sleep(100);
				repaint();
			
			}
			catch(InterruptedException e){
				System.out.println("this is from Expetion");
			}
			
			}
		}

}
*/