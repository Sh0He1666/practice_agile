package practice_agile.sec6_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGame {

    private Game g;
    
    @BeforeEach
    void setUp()
    {
        g = new Game();
    }
    
    @Test
    void testOneThrow() {
        g.add(5);
        assertEquals(5, g.score());
        assertEquals(1, g.getCurrentFrame());
    }

    @Test
    void testTwoThrowsNoMark()
    {
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
    }
    
    @Test
    void testFourThrowsNoMarks()
    {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(2, g.getCurrentFrame());
    }
    
    @Test
    void testSimpleSpare()
    {
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.scoreForFrame(1));
    }
    
    @Test
    void testSimpleFrameAfterSpare()
    {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }
    
}
