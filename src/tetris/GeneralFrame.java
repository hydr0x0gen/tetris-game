/*
 * Box.java
 *
 * Created on 6 Àïðåëü 2009 ã., 23:58
 *
 */

package tetris;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Hyd
 */
public class GeneralFrame extends JFrame
{
   private JPanel midPanel, controlsPanel, scorePanel, lSidePanel, rSidePanel, nextShapePanel, mainPanel;
   private JPanel bottomLeft, bottomRight, buttonsPanel, rotateBtnPnl, leftRightBtnPnl, dropBtnPnl;
   private JButton rotateButton, leftButton, rightButton, dropButton, newGameButton, pauseButton;
   private JLabel scoreLabel;
   private PlayField pf;
   /** Creates a new instance of Box */
   public GeneralFrame()
   {
      setTitle("TETßIS");
      setSize(433, 625);
      setLocation(200, 100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //setLayout(null);
      
      JMenuBar mb = new JMenuBar();
      JMenu m = new JMenu("Game");
      JMenuItem mi1 = new JMenuItem("New game");
      m.add(mi1);
      mb.add(m);
      setJMenuBar(mb);
      
      pf = new PlayField();
      
      midPanel = new JPanel();
      midPanel.setBorder(new EtchedBorder());
      midPanel.setLayout(null);
      //adding PlayField panel to the midPanel
      midPanel.add(pf);
      pf.setBounds(0, 0, pf.WIDTH + 6, pf.HEIGHT + 6);
      
      controlsPanel = new JPanel();
      controlsPanel.setBorder(new EtchedBorder());
      
      scorePanel = new JPanel();
      scorePanel.setBorder(new EtchedBorder());
      //Graphics scorePanelGraphics = scorePanel.getGraphics();
      //scorePanelGraphics.setColor(Color.GRAY);
      //scorePanelGraphics.drawString("SCORE", 10, 10);
      //scorePanel.paint(scorePanelGraphics);
      scoreLabel =new JLabel("SCORE");
      scorePanel.add(scoreLabel);
      lSidePanel = new JPanel();
      lSidePanel.setBorder(new EtchedBorder());
      //lSidePanel.setLayout(null);
      lSidePanel.add(scorePanel);
      //scorePanel.setBounds(10, 10, 30, 30);
      
      nextShapePanel = new JPanel();
      nextShapePanel.setBorder(new EtchedBorder());
      nextShapePanel.add(new JLabel("NEXT SHAPE"));
      rSidePanel = new JPanel();
      rSidePanel.setBorder(new EtchedBorder());
      rSidePanel.add(nextShapePanel);
      
      //adding bottom panels
      controlsPanel.setLayout(new GridLayout(1, 3));
      buttonsPanel = new JPanel();
      //buttonsPanel.setBorder(new EtchedBorder());
      buttonsPanel.setLayout(new GridLayout(3, 1));
      bottomLeft = new JPanel();
      //bottomLeft.setBorder(new EtchedBorder());
      bottomRight = new JPanel();
      //bottomRight.setBorder(new EtchedBorder());
      controlsPanel.add(bottomLeft);
      controlsPanel.add(buttonsPanel);
      controlsPanel.add(bottomRight);
      //adding buttons panels
      rotateBtnPnl = new JPanel();
      //rotateBtnPnl.setBorder(new EtchedBorder());
      buttonsPanel.add(rotateBtnPnl);
      leftRightBtnPnl = new JPanel();
      leftRightBtnPnl.setLayout(new GridLayout(1, 2));
      //leftRightBtnPnl.setBorder(new EtchedBorder());
      buttonsPanel.add(leftRightBtnPnl);
      dropBtnPnl = new JPanel();
      //dropBtnPnl.setBorder(new EtchedBorder());
      buttonsPanel.add(dropBtnPnl);
      //creating and adding buttons
      rotateButton = new JButton("ROTATE");
      leftButton = new JButton("<<<");
      rightButton = new JButton(">>>");
      dropButton = new JButton("DROP");
      rotateBtnPnl.add(rotateButton);
      leftRightBtnPnl.add(leftButton);
      leftRightBtnPnl.add(rightButton);
      dropBtnPnl.add(dropButton);
      
      
      //registering buttons & keys listeners
      leftButton.addActionListener(new ButtonsListener());
      rightButton.addActionListener(new ButtonsListener());
      addKeyListener(new MoveRightLeftRotateDrop());
      
      
      add(midPanel, BorderLayout.CENTER);
      add(controlsPanel, BorderLayout.SOUTH);
      add(lSidePanel, BorderLayout.WEST);
      add(rSidePanel, BorderLayout.EAST);
      
   }
   public void move()
   {
      pf.move();
   }
   
   //inner buttons listening class 
   public class ButtonsListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ae)
      {
         Object btnPressed = ae.getSource();
         if(btnPressed.equals(leftButton))
         {
            pf.left();
         }
         if(btnPressed.equals(rightButton))
         {
            pf.right();
         }
      }
   }
   
   //inner keys class
   private class MoveRightLeftRotateDrop extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            System.out.println("Right pressed");
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            pf.left();
            System.out.println("Left pressed");
         }
         if(e.getKeyCode() == KeyEvent.VK_UP)
         {
            System.out.println("Up pressed");
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            System.out.println("Down pressed");
         }
      }
   }//end of inner class
}
