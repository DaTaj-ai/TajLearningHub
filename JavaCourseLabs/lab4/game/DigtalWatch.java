import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Color;

public class DigtalWatch extends Applet implements Runnable{
	
		
	
	Thread th ;
	int x ; 
	int y = 30 ; 
	int x2 = 90 ; 
	int y2 = 30
	boolean xFlag = true ;
	boolean yFlag = true ; 
	 
	boolean x2Flag = true ;
	boolean y2Flag = true ; 
	 
	 
	public void init(){
		DigtalWatch d = this ;  
		th = new Thread(this);
		th.start();	
				 
	}
			
	public void paint(Graphics g){
	
	g.setColor(Color.BLUE);
		
		g.fillOval(x , y , 50 , 50);	
		
			if(xFlag){
				x+=1; 				
				if(x > getWidth()-50 || x < (x2-50) ){
					
					xFlag = false ; 		
					}
				}
			else{
				x -=1 ; 				
				if(x < 0 || x > x2+50 ){
					xFlag = true ; 		
				} 
			}
			
		/*	if(yFlag){
				y+=1; 
				if(y > getHeight()-50 || y==y2+50 ){
					yFlag = false ; 		
					}
				}
			else{
				y-=1 ;

				  				
				if(y < 0){
					yFlag = true ; 		
				} 
			} */
		
		g.setColor(Color.RED);
		g.fillOval(x2 , y2 , 50 , 50);	
		
			if(x2Flag){
				x2+=4; 				
				if(x2 > getWidth()-50 || x2 < (x+50)){
					x2Flag = false ; 		
					}
				}
			else{
				x2 -=4 ; 				
				if(x2 < 0 || x2 < x-50  ){
					x2Flag = true ; 	
				} 
			}
			
			/*
			if(y2Flag){
				y2+=4; 
				if(y2 > getHeight()-50 || y==y2+25 ){
					y2Flag = false ; 		
					}
				}
			else{
				y2-=4 ;

				  				
				if(y2 < 0){
					y2Flag = true ; 		
				} 
			}
		
		
			
		System.out.println("x ="+x);
		System.out.println("y ="+y);
		System.out.println("x2 ="+x2);
		System.out.println("x2 ="+y2);
		
	*/		
		
		
		}
		
		
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
