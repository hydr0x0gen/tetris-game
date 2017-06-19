/*
 * Main.java
 *
 * Created on 6 јпрель 2009 г., 23:57
 *
 */

package tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Hyd
 */
public class Main
{
   
   /** Creates a new instance of Main */
   public Main()
   {

   }
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      GeneralFrame gf = new GeneralFrame();
      gf.setVisible(true);
      gf.move();
      
      //PlayField pf = new PlayField();
      //pf.setVisible(true);
      
   }
}
