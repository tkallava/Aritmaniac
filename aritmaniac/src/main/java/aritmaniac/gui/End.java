package aritmaniac.gui;

import aritmaniac.graphics.EndGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import aritmaniac.listeners.EndListener;
import aritmaniac.logic.Game;

/**
 * Creates a frame for Endgraphics
 * @author Tomi
 */
public class End implements Runnable {

    private JFrame frame;
    private Game game;
    
    /**
     *
     * @param frame
     * @param game
     * @throws IOException
     */
    public End(JFrame frame, Game game) throws IOException {
        this.game = game;
        this.frame = frame;
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(820, 555));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            addComponents(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Adding endgraphics and replacing keylisteners
     * @param container
     * @throws IOException
     * @throws FontFormatException
     */
    public void addComponents(Container container) throws IOException, FontFormatException {
        EndGraphics end = new EndGraphics(this.game);
        container.add(end);
        
        for (KeyListener kl : frame.getKeyListeners()) {
            frame.removeKeyListener(kl);
        }
        frame.addKeyListener(new EndListener(frame, game));   
    }
}

