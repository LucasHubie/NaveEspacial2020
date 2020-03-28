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
public class NaveEspacial1 extends Frame {

    /**
     * @param args the command line arguments
     */
    
    NaveEspacial1()
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
    g2d.scale(1.5, 1.5);

    //Start at the lower front of the car.
    gp.moveTo(60,240); // novo ponto
    
 
    //front underbody
    gp.lineTo(110,120);
    
    //gp.moveTo(25,240);
    
    gp.lineTo(150,240);
    
    gp.lineTo(105,200);
    
    gp.lineTo(60,240);
    
   
    
    //front wheel
 
    
    
    
  

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
  
  public static double[] convexCombination(double[] a, double[] b, double alpha){
        double[] result = new double[a.length];
        for (int i=0; i<result.length; i++)
    {
    result[i] = (1-alpha)*a[i] + alpha*b[i];
    }
    return(result);
    }
    
    public static void main(String[] args) {
    
    NaveEspacial1 f = new NaveEspacial1();
    f.setTitle("Nave Espacial ");
    f.setSize(500,400);
    f.setVisible(true);
  
    }
    
}
