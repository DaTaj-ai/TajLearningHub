import java.awt.*;
import java.util.Vector;

public abstract class Shape {
    
    public int x1, y1, x2, y2;    
    Color shapeColor ; 
    Boolean isSolid = false; 
    
    
    public Shape(){
    System.out.println("this is from shape");
    }
    
    
    public abstract void draw(Graphics g  ,Shape myShape  );

    
}

class Line extends Shape {
 
        public Line(){
            System.out.println("i am a Line");
        }

        public void draw(Graphics g , Shape myShape ){
                        
                         g.drawLine(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
                 }
        

//                 if (dragging) {
//                     g.drawLine(x, y, x2, y2);
//                 }
             }
            



class Oval extends Shape {
 
        public Oval(){
            System.out.println("i am a Line");
        }
        

        public void draw(Graphics g , Shape myShape ){
                        
            if(isSolid){
                            g.fillOval(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
                        }
                        else{
                         g.drawOval(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
                 }
        }
//                 if (dragging) {
//                     g.drawLine(x, y, x2, y2);
//                 }
             }
class Rectangle extends Shape {
 
        public Rectangle(){
            System.out.println("i am a Rectangle");
        }

        public void draw(Graphics g , Shape myShape ){
            
                        if (isSolid){
                            g.fillRect(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
                        }
                        else{
                         g.drawRect(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
                        }
                 }
        
//                 if (dragging) {
//                     g.drawLine(x, y, x2, y2);
//                 }
             }
            