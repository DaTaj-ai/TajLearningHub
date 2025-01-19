import java.awt.Graphics ;
import java.applet.Applet;
import java.awt.Toolkit ;
import java.awt.Font;
import java.awt.Color;


public class ModifyDisplayFonts extends Applet{
	
	public void paint(Graphics g){	 
			
			g.setColor(Color.BLUE);
			
			g.drawOval(200 , 100 , 300 , 50);
			g.fillOval(200 , 100 , 300 , 50);
			
						
			g.drawLine(200 , 125 , 150 , 450);
			
			g.drawLine(500 , 125 , 550 , 450);
			
			g.drawOval(200 , 250 , 50 , 150);
			
				
			
			g.drawOval(320 , 200 , 75 , 200 );
			g.fillOval(320 , 200 , 75 , 200);
		
		
		
		
			g.drawOval(450 , 250 , 50 , 150);
			
				
			g.drawArc(150 , 400 , 400 , 100, -180, 180);
			
			g.drawLine( 320 , 500 ,	280 , 700);
			g.drawLine( 370 , 500 , 410 , 700);
			
			g.drawRect(200 , 700 ,300 ,50 );
			int counter = 0 ; 
			while(counter<5){
			counter++ ; 
			System.out.println("hello");
			try {
				g.setColor(Color.BLACK);
				g.fillOval(200 , 250 , 50 , 150);
				g.fillOval(200 , 100 , 300 , 50);
				g.fillOval(320 , 200 , 75 , 200);
				g.fillOval(450 , 250 , 50 , 150);
				Thread.sleep(1000);
				//g.setColor(Color.WHITE);
				g.setColor(Color.BLUE);
				g.fillOval(200 , 250 , 50 , 150);
				g.fillOval(320 , 200 , 75 , 200);
				g.fillOval(200 , 100 , 300 , 50);
				g.fillOval(450 , 250 , 50 , 150);
				Thread.sleep(1000);
				}
				
				
			catch(Exception e) {
  				System.out.println("this is inside catch");
			}
			
			}
				
						
		
		}
	}
	
	
	
	
	
	

