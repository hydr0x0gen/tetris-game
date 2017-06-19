/*
 * PlayField.java
 *
 * Created on 7 јпрель 2009 г., 10:11
 *
 */

package tetris;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Hyd
 */
public class PlayField extends JPanel
{
   private Tetrad tetrad, tempTetrad;
   private ShapesGenerator sg;
   private TetPool tp;
   private static final int SQ = 25;
   public static final int WIDTH = 250;
   public static final int HEIGHT = 450;
   boolean moved;
   
   /** Creates a new instance of PlayField */
   public PlayField()
   {
      setSize(WIDTH + 6, HEIGHT + 6);
      setBorder(new EtchedBorder());
      tp = new TetPool();
      tetrad = new Tetrad();
      moved = false;
   }
   
   public void paint(Graphics g)
   {
      super.paint(g);
      
      //setting background
      g.setColor(Color.GRAY);
      g.fillRect(0, 0, WIDTH + 5, HEIGHT + 4);
      
      g.setColor(new Color(40,40,40)); // main color
      g.fillRect(2, 0, WIDTH + 1, HEIGHT + 3);
      
      g.setColor(Color.DARK_GRAY);
      for(int i = 1; i < 18; i++)
      {
         g.drawLine(2, i*SQ + 2, WIDTH + 2, i*SQ + 2);
      }
      for(int i = 1; i < 10; i++)
      {
         g.drawLine(i*SQ + 2, 0, i*SQ + 2, HEIGHT + 2);
      }
      //painting a tetrad
      tetrad.paint(g);
      tp.paint(g);
   }
   
   public void move()
   {
      while(true)
      {
         //generating a random tetrad
         sg = new ShapesGenerator();
         tempTetrad = sg.generate();
         tetrad = tempTetrad;
         //moving it down
         boolean movingDown = true;
         while(movingDown)
         {
            try
            {Thread.sleep(500);}
            catch(InterruptedException e)
            {System.exit(0);}
            
            movingDown = tempTetrad.move();
            repaint();
         }
         tp.addToPool(tetrad);
      }
      
   }
   
   public boolean left()
   {
      moved = true;
      //boolean movingLeft = false;
      moved = tetrad.left();
      repaint();
      return moved;
   }
   
   public boolean right()
   {
      moved = true;
      //boolean movingRight = false;
      moved = tetrad.right();
      repaint();
      return moved;
   }
}
