package watch.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WatchDisplay extends JPanel implements View{
    private Point[] points;

    public WatchDisplay()  {
        this.points = new Point[0];
    }
    
    @Override
    public void paint(Point[] points) {
        this.points = points;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        Image background= new ImageIcon("images\\backgroundMini.jpg").getImage();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        int width = 1;
        for (int i = 0; i < points.length; i++) {
            g.setColor(Color.black);
            if (i == 0) g.setColor(Color.red);
            g2(g).setStroke(new BasicStroke(width));
            g2(g).drawLine(ox(), oy(), ox() + points[i].x, oy() - points[i].y);
            width++;
        }
    }
    
    private Graphics2D g2(Graphics g) {
        return (Graphics2D) g;
    }
    
    private int ox() {
        return this.getWidth() / 2;
    }
    
    private int oy() {
        return this.getHeight() / 2;
    }

    
    
}
