/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naveespacial;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author Lucas Ferreira Hubie
 */
public class NaveEspacial extends Frame {

    /**
     * @param args the command line arguments
     */
    
    NaveEspacial()
  {
    //Enables the closing of the window.
    addWindowListener(new MyFinishWindow());
  }
    
    public void paint(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;

    //Use of antialiasing to have nicer lines.
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    //The lines should have a thickness of 3.0 instead of 1.0.
    BasicStroke bs = new BasicStroke(3.0f);
    g2d.setStroke(bs);

    //The GeneralPath to decribe the car.
    GeneralPath gp = new GeneralPath();
    
    g2d.translate(600, 10);
    g2d.rotate(Math.toRadians(90));
    g2d.scale(0.7, 0.7);

    //Start at the lower front of the car.
    gp.moveTo(60,240); // novo ponto
    
    //front underbody
    gp.lineTo(80,120);
    
    //front wheel
    gp.quadTo(90,140,100,120);
    //middle underbody
    gp.lineTo(130,240);
    ;
    //rear wheel
    //gp.quadTo(170,140,180,120);
    //rear underbody
    gp.lineTo(130,350);
    
    
    gp.lineTo(60,350); //lateral
    
    
    gp.lineTo(60,240);
    
    gp.moveTo(130,350); //novo ponto
    
    gp.lineTo(140,400);
    
    gp.lineTo(140,550);
    
    gp.lineTo(50,550); // lateral
    
    
    gp.moveTo(60,350); //novo ponto
    
    gp.lineTo(50,400);
    
    gp.lineTo(50,550);
    
    gp.lineTo(25,550);
    
    gp.lineTo(25,610);
    
    gp.lineTo(50,610);
    
    gp.lineTo(50,550);
    
    
    gp.moveTo(140,550); //novo ponto
    
    gp.lineTo(165,550);
    
    gp.lineTo(165,610);
    
    gp.lineTo(140,610);
    
    gp.lineTo(140,550);
    
    
    gp.moveTo(82,550); //novo ponto
    
    gp.lineTo(82,610);
    
    gp.lineTo(107,610);
    
    gp.lineTo(107,550);
    
    
    
  

    //Draw the car.
    g2d.draw(gp);


    g2d.setStroke(new BasicStroke(1.0f));
    //Draw a coordinate system.
    drawSimpleCoordinateSystem(400,500,g2d);

  }



  /**
  * Draws a coordinate system (according to the window coordinates).
  *
  * @param xmax     x-coordinate to which the x-axis should extend.
  * @param ymax     y-coordinate to which the y-axis should extend.
  * @param g2d      Graphics2D object for drawing.
  */
  public static void drawSimpleCoordinateSystem(int xmax, int ymax,
                                                Graphics2D g2d)
  {
    int xOffset = 30;
    int yOffset = 50;
    int step = 20;
    String s;
    //Remember the actual font.
    Font fo = g2d.getFont();
    //Use a small font.
    g2d.setFont(new Font("sansserif",Font.PLAIN,9));
    //x-axis.
    g2d.drawLine(xOffset,yOffset,xmax,yOffset);
    //Marks and labels for the x-axis.
    for (int i=xOffset+step; i<=xmax; i=i+step)
    {
      g2d.drawLine(i,yOffset-2,i,yOffset+2);
      g2d.drawString(String.valueOf(i),i-7,yOffset-7);
    }

    //y-axis.
    g2d.drawLine(xOffset,yOffset,xOffset,ymax);

    //Marks and labels for the y-axis.
    s="  "; //for indention of numbers < 100
    for (int i=yOffset+step; i<=ymax; i=i+step)
    {
      g2d.drawLine(xOffset-2,i,xOffset+2,i);
      if (i>99){s="";}
      g2d.drawString(s+String.valueOf(i),xOffset-25,i+5);
    }

    //Reset to the original font.
    g2d.setFont(fo);
  }
    
    public static void main(String[] args) {
    
    NaveEspacial f = new NaveEspacial();
    f.setTitle("Nave Espacial ");
    f.setSize(250,200);
    f.setVisible(true);
  
    }
    
}
