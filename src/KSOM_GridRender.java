
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class KSOM_GridRender extends JPanel {
   
   // Grid
   KSOM_Grid grid;
   // Buffer - Imagem
   private BufferedImage image;
   // Fonte - Meyrio
   Font font;
   
   public KSOM_GridRender() {
      grid  = null;
      image = null;
      font  = new Font("Meyrio", Font.PLAIN, 14);
      
      addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
         @Override
         public void mouseMoved(java.awt.event.MouseEvent evt) {
            panelMouseMoved(evt);
         }
      });
   }

   public void setGrid(KSOM_Grid grid) {
      this.grid = grid;
      if (image == null) {
         image = (BufferedImage) createImage(getWidth(), getHeight());
         System.out.println(" > [KSOM_GridRender] Image Created: " + getWidth() + ", " + getHeight());
      }
   }

   public BufferedImage getImage() {
      return image;
   }

   public void setImage(BufferedImage image) {
      this.image = image;
   }

   @Override
   public void paint(Graphics g) {
      if (image == null)
         super.paint(g);
      else
         g.drawImage(image, 0, 0, this);
   }

   /**
    * Renderiza o grid.
    */
   public void render() {
      float cellW = (float) getWidth()  / (float) grid.getWidth();
      float cellH = (float) getHeight() / (float) grid.getHeight();

      int imageW = image.getWidth();
      int imageH = image.getHeight();

      Graphics2D g2 = image.createGraphics();
      g2.setBackground(Color.black);
      g2.clearRect(0, 0, imageW, imageH);
      for (int x = 0; x < grid.getWidth(); x++) {
         for (int y = 0; y < grid.getHeight(); y++) {
            KSOM_Color color = grid.getNode(x, y).getColor();
            g2.setColor(new Color((float) color.getR(), (float) color.getG(), (float) color.getB()));
            g2.fillRect((int) (x * cellW), (int) (y * cellH), (int) cellW, (int) cellH);
         }
      }
      
      repaint();
   }

   private void panelMouseMoved(java.awt.event.MouseEvent evt) {
      int x = evt.getX();
      int y = evt.getY();
      
      float cellW = (float) getWidth()  / (float) grid.getWidth();
      float cellH = (float) getHeight() / (float) grid.getHeight();

      int cellX = (int) ((float) x / cellW);
      int cellY = (int) ((float) y / cellH);

      KSOM_Color color = grid.getNode(cellX, cellY).getColor();
      float r = (float) color.getR();
      float g = (float) color.getG();
      float b = (float) color.getB();

      System.out.println(" > [MouseEvent] x: " + cellX + " - y: " + cellY);
   }
}
