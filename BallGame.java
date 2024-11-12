package awt;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BallGame extends Frame implements MouseMotionListener {
    int circleX = 200, circleY = 200, circleRadius = 15;

    BallGame() {
        setSize(800, 800);
        setLayout(null);
        setTitle("Ball Game");
        setVisible(true);
       
        //window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //mouse listener
        addMouseMotionListener(this);
    }

    //Already present graphic methdod to draw something
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(circleX, circleY, 2 * circleRadius, 2 * circleRadius);
    }

    public static void main(String[] args) {
        new BallGame();
    }

    @Override
  //if i want to play the game by pressing we can use this method
    public void mouseDragged(MouseEvent e) {
        // Not used in this example, but can be implemented if needed
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
       
        if (x < circleX + circleRadius) {
            circleX++;
        }
        if (x > circleX + circleRadius) {
            circleX--;
        }
        if(y< circleY + circleRadius)
        {
        	circleY++;
        }
        if(y> circleY + circleRadius)
        {
        	circleY--;
        }
        repaint(); //calling repaint method to fill the colour when i'm moving the mouse
    }
}
