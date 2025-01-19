
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class PaintBrush extends Applet {

    Vector<Shape> shapes = new Vector<>();
    boolean dragging = false;
    int x, y, x2, y2;
    Boolean val;
    int colorVal;
    int SHAPE_STATE;

    Shape myShape = new Line();

    Color globalColor;
    Boolean globalIsSolidVal;

    MyMouseListener mL;
    Button lineBtn;
    Button rectangleBtn;
    Button ovelBtn;
    Button pencelBtn;
    Button eraserBtn;
    Button clearBtn;
    Button undoBtn;
    Button blackBtn;
    Button redBtn;
    Button BlueBtn;
    Checkbox isSolid;
    Checkbox isDotted;
    Button greenBtn;
    
    public void init() {
        MyMouseListener mL = new MyMouseListener();
        addMouseListener(mL);
        addMouseMotionListener(mL);

        Button lineBtn = new Button("line");
        Button rectangleBtn = new Button("Rectangle");
        Button ovelBtn = new Button("Ovel");
        Button pencelBtn = new Button("Pencel");
        Button eraserBtn = new Button("Eraser");
        Button clearBtn = new Button("clear");
        Button undoBtn = new Button("undo");
        Button blackBtn = new Button();
        Button redBtn = new Button();
        Button BlueBtn = new Button();
        Checkbox isSolid = new Checkbox("Solid", true);
        Checkbox isDotted = new Checkbox("Dotted");
        Button greenBtn = new Button();

        blackBtn.setBackground(new Color(0, 0, 0));
        //blackBtn.setSize(222 , 122);
        redBtn.setBackground(Color.RED);
        BlueBtn.setBackground(Color.BLUE);
        greenBtn.setBackground(Color.GREEN);

        add(clearBtn);
        add(undoBtn);
        add(lineBtn);
        add(rectangleBtn);
        add(ovelBtn);
        add(pencelBtn);
        add(eraserBtn);
        add(isSolid);
        add(isDotted);
        add(blackBtn);
        add(greenBtn);
        add(redBtn);
        add(BlueBtn);

        isSolid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                val = isSolid.getState();
                myShape.isSolid = val;
                globalIsSolidVal = val;
                System.out.println("Checkbox state " + val);
            }
        });

        lineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("i am line button"); 
                SHAPE_STATE = 10;
                repaint();
            }
        });

        redBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                globalColor = Color.RED;
                repaint();
            }
        });
        BlueBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                globalColor = Color.BLUE;
                repaint();
            }
        });
        greenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                globalColor = Color.GREEN;
                repaint();
            }
        });
        blackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                globalColor = Color.BLACK;
                repaint();
            }
        });

        rectangleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("i am line button");
                SHAPE_STATE = 30;

                repaint();
            }
        });
        ovelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("i am line button");
                SHAPE_STATE = 20;
                repaint();
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                repaint();
            }
        });

        undoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shapes.remove(shapes.size() - 1);
                repaint();
            }
        });
    }

    class MyMouseListener implements MouseListener, MouseMotionListener {

        public void mousePressed(MouseEvent e) {
            if (SHAPE_STATE == 10) {
                myShape = new Line();
                myShape.x1 = e.getX();
                myShape.y1 = e.getY();
            } else if (SHAPE_STATE == 20) {
                myShape = new Oval();
                myShape.x1 = e.getX();
                myShape.y1 = e.getY();
            } else if (SHAPE_STATE == 30) {
                myShape = new Rectangle();
                myShape.x1 = e.getX();
                myShape.y1 = e.getY();
            }
            myShape.shapeColor = globalColor;
            myShape.isSolid = globalIsSolidVal;
            dragging = true;
        }

        public void mouseReleased(MouseEvent e) {
            if (dragging) {
                
                myShape.x2 = e.getX();
                myShape.y2 = e.getY();
                shapes.add(myShape);
                dragging = false;
                repaint();
                
            }
        }

        public void mouseDragged(MouseEvent e) {
            if (dragging) {
                System.out.println("now Dragging");
                myShape.x2 = e.getX();
                myShape.y2 = e.getY();
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

        for (int i = 0; i < shapes.size() - 1; i += 1) {
          
            Shape s = shapes.get(i);
//                       System.out.println(isSolid.isState());

            s.draw(g, s);

//                       System.out.println(s.x1);
//                       System.out.println(s.x2);
//                       System.out.println(s.y1);
//                       System.out.println(s.y2);
            if (s != null) {
                s.draw(g, s);
            }
        }

//        if(SHAPE_STATE == 10 ){
//            Shape sh = new Line();
//            sh.draw(g , myShape);
//        }
//        else if(SHAPE_STATE == 20 ){
//            for (int i = 0; i < points.size() - 1; i += 2) {
//                     Point p1 = points.get(i);
//                     Point p2 = points.get(i + 1);
//                     if (p1 != null && p2 != null) {
//                         
//                         g.fillOval(p1.x , p1.y , p2.x,p2.y);	
//                     }
//                 }
//
//                 if (dragging) {
//                               
//                  
//                        Point p1 = points.get(points.size()-1);
//                        Point p2 = points.get(points.size()-2);       
//                        g.fillOval(p1.x , p1.y , p2.x,p2.y);	
//                 
//                 }
        //   setBackground(Color.WHITE);
    }
}

//        for (int i = 0; i <  6- 1; i += 2) {
//            Point p1 = points[i];
//            Point p2 = points[i + 1];
//            if (p1 != null && p2 != null) {
//                g.drawLine(p1.x, p1.y, p2.x, p2.y);
//            }
//        }
//
//        if (dragging) {
//            g.drawLine(x, y, x2, y2);
//        }

