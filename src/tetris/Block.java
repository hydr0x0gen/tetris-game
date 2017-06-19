/*
 * Block.java
 *
 * A block to create tetrads
 *
 * Created on 7 јпрель 2009 г., 10:13
 *
 */

package tetris;
import java.awt.*;


/**
 *
 * @author Hyd
 */
public class Block extends Rectangle
{
   protected final static int SIDE = 24;
   private final static int CHANGE = 25;
   private final int BLOCKSNUM = 4;
   //private Point pos;
   protected final Point[] pos;
   private Color blockColor;
   int[] x, y;
   /** Creates a new instance of Block */
   
   public Block(int[] width, int[] height, Color c)
   {
      blockColor = c;
      //creating an array of 4 Points:
      pos = new Point [BLOCKSNUM];
      for(int i = 0; i < 4; i++)
      {
         pos[i] = new Point();
      }
      //initialising X and Y points to the constructor arguments
      pos[0].x = width[0] + 2;
      pos[0].y = height[0] + 2;
      pos[1].x = width[1] + 2;
      pos[1].y = height[1] + 2;
      pos[2].x = width[2] + 2;
      pos[2].y = height[2] + 2;
      pos[3].x = width[3] + 2;
      pos[3].y = height[3] + 2;
   }
   
   public void paint(Graphics g)
   {
      g.setColor(Color.LIGHT_GRAY);
      for(int i = 0; i < 4; i++)
      {
         g.fillRect(pos[i].x, pos[i].y, SIDE + 2, SIDE + 2);
      }
      //drowing the block in color
      g.setColor(blockColor);
      for (int i = 0; i < 4; i++)
      {
         g.fillRect(pos[i].x + 1, pos[i].y + 1, SIDE, SIDE);
      }
      //inner lines
      Color brighterColor = blockColor.brighter();
      g.setColor(brighterColor);
      for (int i = 0; i < 4; i++)
      {
         g.fillRect(pos[i].x + 4, pos[i].y + 4, SIDE - 6, SIDE - 6);
      }
      /* shining
      g.setColor(Color.WHITE);
      for (int i = 0; i < 4; i++)
      {
         g.fillOval(pos[i].x + 1, pos[i].y + 1, 2, 2);
      }*/
      //inner rect
      Color darkerColor = blockColor.darker();
      g.setColor(darkerColor);
      for (int i = 0; i < 4; i++)
      {
         g.fillRect(pos[i].x + 6, pos[i].y + 6, SIDE - 10, SIDE - 10);
      }
   }
   
   //creating Rectangle for each block in tetrad
   /*public Rectangle[] area()
   {
      Rectangle[] rectBlocks = new Rectangle[4];
      rectBlocks[0] = getBounds();
      for (int i = 0; i < 4; i++)
      {
         rectBlocks[i] = new Rectangle(pos[i].x, pos[i].y, SIDE, SIDE);
      }
      return rectBlocks;
   }*/
   
   /*public boolean isContact(Block b)
   {
      if(area().contains(b.getLocation()))
      {
         return true;
      }
      else
      {
         return false;
      }
   }*/
   
   public Point[] getBlockPos()
   {
      Point[] pnt = new Point[4];
      for(int i = 0; i < 4; i++)
      {
         pnt[i] = pos[i].getLocation();
      }
      return pnt;
   }
   
   public void moveUp()
   {
      for (int i = 0; i < 4; i++)
      {
         pos[i].translate(0, -(CHANGE));
      }
   }
   
   public boolean moveDown()
   {
      boolean moved = true;
      for (int i = 0; i < 4; i++)
      {
         if(PlayField.HEIGHT - (SIDE+2) < pos[i].y)
         {
            moved = false;
         }
      }
      if(moved)
      {
         for (int j = 0; j < 4; j++)
         {
            pos[j].translate(0, CHANGE);
         }
      }
      return moved;
   }
   
   public boolean moveEast() //right
   {
      boolean moved = true;
      for (int i = 0; i < 4; i++)
      {
         if(pos[i].x >= PlayField.WIDTH - SIDE)
         {
            moved = false;
         }
      }
      if(moved)
      {
         for(int j = 0; j < 4; j++)
         {
            pos[j].translate(CHANGE, 0);
         }
      }
      return moved;
   }
   
   public boolean moveWest() //left
   {
      boolean moved = true;
      for (int i = 0; i < 4; i++)
      {
         if(pos[i].x < SIDE)
         {
            moved = false;
         }
      }
      if(moved)
      {
         for(int j = 0; j < 4; j++)
         {
            pos[j].translate(-(CHANGE), 0);
         }
      }
      return moved;
   }
}
