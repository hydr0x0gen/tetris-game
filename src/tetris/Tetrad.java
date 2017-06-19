/*
 * Tetrad.java
 *
 * Created on 14 Май 2009 г., 0:46
 *
 */

package tetris;
import java.awt.*;



public class Tetrad
{
   private Block b;

   /** Creates a new instance of Tetrad */
   public Tetrad()
   {
   }
   
   public void iShape()
   {
      int[] width = {75, 100, 125, 150};
      int[] height = {0,0,0,0};
      b = new Block(width, height, new Color(255, 100, 100)); //color red
   }
   
   public void jShape()
   {
      int[] width = {75, 100, 125, 125};
      int[] height = {0,0,0,25};
      b = new Block(width, height, new Color(200, 200, 220)); // color grey
   }
   
   public void lShape()
   {
      int[] width = {75, 100, 125, 125};
      int[] height = {25,25,25,0};
      b = new Block(width, height, new Color(255, 145, 255)); // color mauve

   }
   
   public void oShape()
   {
      int[] width = {100, 125, 100, 125};
      int[] height = {0,0,25,25};
      b = new Block(width, height, new Color(100, 160, 255)); //color blue
   }
   
   public void sShape()
   {
      int[] width = {100, 100, 125, 125};
      int[] height = {0,25,25,50};
      b = new Block(width, height, new Color(140, 255, 140)); // color green
   }
   
   public void tShape()
   {
      int[] width = {75, 100, 125, 100};
      int[] height = {0,0,0,25};
      b = new Block(width, height, new Color(255, 255, 150));// color yellow
   }
   
   public void zShape()
   {
      int[] width = {125, 125, 100, 100};
      int[] height = {0,25,25,50};
      b = new Block(width, height, new Color(120, 255, 255)); //color cyan
   }
   
   public void paint(Graphics g)
   {
      b.paint(g);
   }
   
   public Point[] getTetradPos()
   {
      Point[] pnt = b.getBlockPos();
      return pnt;
   }
   
   // moves tetrad down
   public boolean move()
   {
      boolean moved;
      moved = b.moveDown();
      return moved;
   }
   
   //moves tetrad left (west)
   public boolean left()
   {
      boolean moved;
      moved = b.moveWest();
      return moved;
   }
   
   //moves tetrad right (east)
   public boolean right()
   {
      boolean moved;
      moved = b.moveEast();
      return moved;
   }
   
   //checks for contact with other tetrad
   /*public boolean isContact()
   {
      boolean contact = false;

      return contact;
   }*/
}//end of Tetrad class
