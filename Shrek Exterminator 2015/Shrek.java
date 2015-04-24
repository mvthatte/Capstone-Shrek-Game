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


public class Shrek
{
    private static final int WIDTH = 180;
    private static final int HEIGHT = 161;
    boolean funcheck = false;
    
    int x = 0;
    int y = 0;
    int x2 = 1;
    int y2 = 1;
    private GamePanel game;
    private Image shrekImage;
   

    public Shrek(GamePanel game)
    {
        this.game= game;
    }

    void move()
    {
        if (x + x2 < 0)
            x2 = 1;
        if (x + x2 > game.getWidth() - 30)
            x2 = -1;
        if (y +     y2 < 0)
            y2 = 1;
        if (y + y2 > game.getHeight() - 30)
            y2 = -1;
        if (collision()){
            funcheck = true;
            game.gameOver();
        }
        
        x = x + x2;
        y = y + y2;

        shrekImage = new ImageIcon("gameshrek.png").getImage();
    }
    
    public boolean getFun()
    {
        return funcheck;
    }
    
    public Rectangle getBounds() 
    {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    
    private boolean collision() {
        return game.wazowski.getBounds().intersects(getBounds());
    }
    
    public void paint(Graphics2D g) 
    {
        g.drawImage(shrekImage,x,y,null);
        
        
    }
}