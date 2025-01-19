import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Button ; 
import java.awt.event.ActionEvent ; 
import java.awt.event.* ; 
import java.awt.* ; 


public class MoveText extends Applet {
	
	int x = 50  ; 
	int y = 50 ;  
		
	public void init(){		
		
		MyKeyListener myKeyListener = new MyKeyListener() ; 
		
		addKeyListener(myKeyListener);
		
		}
		
	class MyKeyListener implements KeyListener {
			 public void keyPressed(KeyEvent e){
		 		int val = e.getKeyCode(); 
		 		
		 		
		 		System.out.println(val);
		 		
		 		
		 		
		 		if( val == e.VK_UP){
		 			y-=5;
		 			System.out.println("UP"); 	
		 			}
		 		else if ( val  == e.VK_DOWN){
		 			y+=5 ; 
		 			}
		 		else if ( val == e.VK_LEFT){
					x-=5;		 		
		 			}
		 		else if ( val == e.VK_RIGHT){
		 			x+=5 ; 
		 		}
		 		
		 		
		 		repaint();  
		 			}
		 	public void keyReleased(KeyEvent e){
		 		
		 		}
		 	
		 	public void keyTyped(KeyEvent e){
		 		
		 	}
		 
		 }
		
	
	

	
			
	public void paint(Graphics g){
			g.drawString("Move me"  ,x,y);
		}
	}


