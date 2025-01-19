import java.applet.Applet ; 
import java.awt.Graphics ;
import java.util.Date ; 
import java.awt.Button ; 
import java.awt.event.ActionEvent ; 
import java.awt.event.* ; 



public class BallGame extends Applet implements Runnable{
	
		
	
	Thread th ;
	int x ; 
	int y = 30 ; 
	boolean isSart = false ; 
	Button btu1 ; 
      Button btn2 ; 

	
	boolean xFlag = true ;
	boolean yFlag = true ; 
	
	
	
	public void init(){
		BallGame d = this ;  
		th = new Thread(this);
		
		Button btu1 = new Button("Start"); 
            Button btu2 = new Button("Pause");         
		
		btu2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
            
                        th.suspend();
                }
        	});
        	
        	btu1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                        if (isSart == false){ 
                        	th.start();
                        	isSart = true; 	}
                        else{
                        	th.resume();
                        	}
                }
        	});

		
		
		add(btu1);
		add(btu2); 
		
		
	}
			
	public void paint(Graphics g){
		
		
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
	public void run (){
		while(true){
			try{
				Thread.sleep(10);
				repaint();
				 
			
			}
			catch(InterruptedException e){
				System.out.println("this is from Expetion");
			}
			
			}
		}

}
