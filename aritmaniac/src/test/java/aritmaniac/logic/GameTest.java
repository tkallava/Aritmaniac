/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tomi
 */
public class GameTest {
    
    private Game game;
    
    /**
     *
     */
    public GameTest() {
        this.game = new Game("Matt");
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void setPointsTest() {

        game.setPoints();
        assertEquals("1", game.getPoints());
        assertEquals(1, game.getLevel());
        
        game.setPoints();
        assertEquals("2", game.getPoints());
        assertEquals(1, game.getLevel());
        
        game.setPoints();
        game.setPoints();
        game.setPoints();
        assertEquals("5", game.getPoints());
        assertEquals(2, game.getLevel());
    }
    
    /**
     *
     */
    @Test
    public void decPointsTest() {
        
        game.setPoints();
        game.setPoints();
        game.setPoints();
        
        game.decPoints();
        
        assertEquals("0", game.getPoints());
         
        game.setPoints();
        game.setPoints();
        game.setPoints();
        game.setPoints();
        game.setPoints();

        game.decPoints();

        assertEquals("5", game.getPoints());
    }
    
}
