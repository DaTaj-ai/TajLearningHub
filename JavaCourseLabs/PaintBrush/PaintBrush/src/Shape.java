
import java.awt.*;
import java.util.Vector;

public abstract class Shape {

    public int x1, y1, x2, y2;
    Color shapeColor = Color.BLACK;
Boolean isSolid = false;

    public Shape() {

    }

    public abstract void draw(Graphics g, Shape myShape);
}

class Line extends Shape {

    public Line() {
    }

    public void draw(Graphics g, Shape myShape) {
        g.setColor(shapeColor);
        g.drawLine(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
    }

}

class Oval extends Shape {

    public Oval() {
    }

    public void draw(Graphics g, Shape myShape) {

        if (isSolid == true) {

            g.fillOval(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
        } else {
            g.drawOval(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
        }
    }

}

class Rectangle extends Shape {

    public Rectangle() {
    }

    public void draw(Graphics g, Shape myShape) {

        if (isSolid ==true) {
            g.setColor(shapeColor);
            g.fillRect(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
        } else {
            g.setColor(shapeColor);
            g.drawRect(myShape.x1, myShape.y1, myShape.x2, myShape.y2);
        }
    }

}
