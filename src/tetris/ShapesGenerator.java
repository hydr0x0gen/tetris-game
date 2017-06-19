/*
 * ShapesGenerator.java
 *
 * Created on 14 Май 2009 г., 0:04
 *
 * Generates random shapes
 */

package tetris;

public class ShapesGenerator
{
   private Tetrad t;
   /** Creates a new instance of ShapesGenerator */
   public ShapesGenerator()
   {
      t = new Tetrad();
   }

   public Tetrad generate()
   {
      //generates random 0-6 numbers
      int rand = 7;
      while(rand > 6)
      {
         rand = (int) (Math.random()*10);
      }
      //generates shapes
      if(rand == 0)
      {t.iShape();}
      else
      {
         if(rand == 1)
         {t.jShape();}
         else
         {
            if(rand == 2)
            {t.lShape();}
            else
            {
               if(rand == 3)
               {t.oShape();}
               else
               {
                  if(rand == 4)
                  {t.sShape();}
                  else
                  {
                     if(rand == 5)
                     {t.tShape();}
                     else
                     {
                        if(rand == 6)
                        {t.zShape();}
                     }
                  }
               }
            }
         }
      }
      return t;
   }
   
}
