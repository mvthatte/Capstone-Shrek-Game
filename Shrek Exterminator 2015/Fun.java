import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Rectangle;
import javax.swing.JOptionPane;


public class Fun
{
    private GamePanel game;
    private Image funImage;
   

    public Fun(GamePanel game)
    {
        this.game= game;
    }

    public void paint(Graphics2D g) 
    {
        funImage = new ImageIcon("fun.png").getImage();
        g.drawImage(funImage,0,0,null);
        
        
    }
}