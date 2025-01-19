import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Button ; 
import java.awt.event.ActionEvent ; 
import java.awt.event.* ; 
import java.awt.* ; 



public class DrawLine extends Applet {
	  
	int x ;
	int y ;
	int x2 ; 
	int y2 ;  
	Point p ;
	boolean getedFirstPoint = false ;  
	public void init(){		
	
		
		MyMouseMotionListener mL = new MyMouseMotionListener();
		addMouseMotionListener(mL);	
		
	}
		
		
	
	
	class MyMouseMotionListener implements MouseMotionListener {
			
		public void mouseDragged(MouseEvent e){
			
			if(getedFirstPoint == false ){
				x = e.getX();
            		y = e.getY();
            	
				getedFirstPoint = true ;
				System.out.println("this is the first x "+x);
				System.out.println("this is the first y "+y);
			}
			else{
				x = e.getX();
            		y = e.getY();
            		
				System.out.println("this is the final x "+x2);
				System.out.println("this is the final y "+y2);
				
			}
			
			repaint(); 
			//getedFirstPoint = false ; 
		}
		public void  mouseMoved(MouseEvent e){
		}		

	}
	
			
	public void paint(Graphics g){ 
			g.drawLine(x , y , Math.abs(x2) , Math.abs(y2));	
		}
	}


