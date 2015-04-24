import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class GamePanel extends JPanel
{
    Shrek shrek = new Shrek(this);
    Wazowski wazowski = new Wazowski(this);
    Background background = new Background(this);
    Fun fun = new Fun(this);
    
    public GamePanel() {
        addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                wazowski.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                wazowski.keyPressed(e);
            }
        });
        setFocusable(true);
        Sound.BACKGROUNDNOISE.loop();
    }
    
     
    
    public void gameOver() 
    {
        Sound.GAMEOVER.play();
        JOptionPane.showMessageDialog(this, "MISSION SUCCESSFUL: THE FILTHY SHREK HAS BEEN DISPOSED OF","YOU CAUGHT SHREK", JOptionPane.YES_NO_OPTION);  
        System.exit(ABORT);
    }
    
    private void move()
    {
        shrek.move();
        wazowski.move();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (shrek.getFun() == true)        
        {
            fun.paint(g2);
        }
        background.paint(g2);
        shrek.paint(g2);
        wazowski.paint(g2);
    }

    public static void main(String[]args) throws InterruptedException
    {
        JFrame frame = new JFrame("Shrek Simulator 2015");
        GamePanel game = new GamePanel();

        frame.add(game);
        frame.setSize(1675,1004);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true)
        {
            game.move();            
            game.repaint();
            Thread.sleep(10);
        }
    }
}
