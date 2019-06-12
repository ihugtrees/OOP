import Gameplay.Gameplay;
import Gameplay.Level;
import Units.ActiveGameUnit;
import Utils.RandomGeneratorImpl;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ActiveGameUnitTest {
    private Gameplay gameplay;
    private List<Level> lvl = new LinkedList<>();
    private String s;

    @Before
    public void setUp() throws Exception {
        RandomGeneratorImpl.getInstance().setTest();
        Path currentRelativePath = Paths.get("");
        s = currentRelativePath.toAbsolutePath().toString();
    }

    @Test
    public void defend() {
        lvl.add( new Level(s+"/Tests/mini1.txt"));
        gameplay = new Gameplay(lvl);
        gameplay.startGame(1);
        try {
            gameplay.turn('d');
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(gameplay.isGameOver());
    }

    @Test
    public void noMonsterTest() {
        lvl.add( new Level(s+"/Tests/mini2.txt"));
        gameplay = new Gameplay(lvl);
        gameplay.startGame(1);
        try {
            gameplay.turn('d');
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(gameplay.isGameOver());
    }
}