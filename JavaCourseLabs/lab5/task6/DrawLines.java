import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class DrawLines extends Applet {
	
    int pointIndex = 0;    
    Point[] points = new Point[6];
    boolean dragging = false;             
    int x, y, x2, y2;                     

    public void init() {
        MyMouseListener mL = new MyMouseListener();
        addMouseListener(mL);             
        addMouseMotionListener(mL);      
    }

    class MyMouseListener implements MouseListener, MouseMotionListener {

        
        public void mousePressed(MouseEvent e) {
           if (pointIndex >= points.length) {
                System.out.println("max");
            }
            else {
            x = e.getX();
            y = e.getY();
            dragging = true;              
        }
	}
        
        public void mouseReleased(MouseEvent e) {
            if (dragging) {
                x2 = e.getX();
                y2 = e.getY();

                 points[pointIndex] = new Point(x, y);
                 points[pointIndex + 1] = new Point(x2, y2);
                 pointIndex += 2;
                 
                dragging = false;         
                repaint();                
                
            }
        }

        
        public void mouseDragged(MouseEvent e) {
            if (dragging) {
                
                x2 = e.getX();
                y2 = e.getY();
                repaint();                
            }
        }

        
        public void mouseMoved(MouseEvent e) {
        
        }

     
        public void mouseClicked(MouseEvent e) {
        }

     
        public void mouseEntered(MouseEvent e) {
        }

     
        public void mouseExited(MouseEvent e) {
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i <  6- 1; i += 2) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            if (p1 != null && p2 != null) {
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        if (dragging) {
            g.drawLine(x, y, x2, y2);
        }
    }
}





/*import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DrawLines extends Applet {

    Point[] points = new Point[6];
 
    int pointIndex = 0;           
    boolean dragging = false;     
    int x, y, x2, y2;             

    public void init() {
        MyMouseListener mL = new MyMouseListener();
        addMouseListener(mL);
        addMouseMotionListener(mL); 
        
    }

    class MyMouseListener implements MouseListener, MouseMotionListener  {

        
        public void mousePressed(MouseEvent e) {
            dragging = true;  
            if (pointIndex >= points.length) {
                System.out.println("max");
            }
            else {
            	x = e.getX();
            	y = e.getY();
            	
             }

 
        }

        
        public void mouseReleased(MouseEvent e) {
            if (dragging) {
                x2 = e.getX();
                y2 = e.getY();


                if (pointIndex < points.length - 1) {
                    points[pointIndex] = new Point(x, y);
                    points[pointIndex + 1] = new Point(x2, y2);
                    pointIndex += 2;
                }

                dragging = false;
                repaint(); 
                
            }
        }

			          
        public void mouseDragged(MouseEvent e) {
            
                dragging = true;     
                x2 = e.getX();
                y2 = e.getY();
                repaint(); 
            
        }

        
        public void mouseMoved(MouseEvent e) {
         
        }

        
        public void mouseClicked(MouseEvent e) {
            
        }

        
        public void mouseEntered(MouseEvent e) {
            
        }
        
        public void mouseExited(MouseEvent e) {
            
        }
    }

    public void paint(Graphics g) {
        
        for (int i = 0; i < pointIndex - 1; i += 2) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            if (p1 != null && p2 != null) {
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        
        //if (dragging) {
         //   g.drawLine(x, y, x2, y2);
        //}
    }
}



/*
import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Button ; 
import java.awt.event.ActionEvent ; 
import java.awt.event.* ; 
import java.awt.* ; 
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;



public class DrawLines extends Applet {
	  
	
	Point [] points = new Point[10]; 
	int x;
	int pointIndex = 0  ; 
	int y;
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
			
			if(!getedFirstPoint){
				x = e.getX();
                		y = e.getY();
				getedFirstPoint = true ;
				
				if (pointIndex < points.length) {
                    		points[pointIndex] = new Point(x, y);
                    		pointIndex++;
                			}
                			
				System.out.println("this is the first x "+x);
				System.out.println("this is the first y "+y);
				  if (pointIndex < points.length) {
		              	points[pointIndex] = new Point(x2, y2);
		              	pointIndex++;
		          		}	
				
			}
			else{
				x2 = e.getX();
                		y2 = e.getY();
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
			for (int i = 0; i < pointIndex - 1; i++) {
            		Point p1 = points[i];
            		Point p2 = points[i + 1];
            	if (p1 != null && p2 != null) {
                		g.drawLine(p1.x, p1.y, p2.x, p2.y);
            	}
	
	
	
			//g.drawLine(x , y , Math.abs(x2) , Math.abs(y2)-65);	
	
		}
	}


}
*/
