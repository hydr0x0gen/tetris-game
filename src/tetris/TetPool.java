/*
 * TetPool.java
 *
 * Created on 17 Май 2009 г., 1:23
 *
 */

package tetris;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Hyd
 */
public class TetPool
{
   ArrayList <Tetrad> tetArList;
   Tetrad t;
   /** Creates a new instance of TetPool */
   public TetPool()
   {
      tetArList = new ArrayList();
   }
   
   // adds a Tetrad to the collection
   public void addToPool(Tetrad t)
   {
      tetArList.add(t);
   }

   //painting tetrads in the pool
   public void paint(Graphics g)
   {
      for(Iterator i= tetArList.iterator(); i.hasNext();)
      {
         Tetrad tToPaint = (Tetrad) i.next();
         tToPaint.paint(g);
      }
   }
}
