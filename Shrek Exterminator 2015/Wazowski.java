import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Wazowski {
    private static final int Y = 720;
	private static final int WIDTH = 189;
	private static final int HEIGHT = 267;
    int x = 0;
    int x2 = 0;
    private GamePanel game;
    private Image mikeImage;

    public Wazowski(GamePanel game) {
        this.game= game;
    }

    public void move() {
        if (x + x2 > 0 && x + x2 < game.getWidth()-60)
            x = x + x2;
            
        mikeImage = new ImageIcon("mikewazowskipic.png").getImage();
    }

    public void paint(Graphics2D g) {
        g.drawImage(mikeImage,x,Y,null);
    }

    public void keyReleased(KeyEvent e) {
        x2 = 0;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }
    
    public int getTopY()
    {
        return Y;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            x2 = -3;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            x2 = 3;
    }
}