import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;


public class TestGameBord {
    @org.junit.jupiter.api.Test
    public void testOutOfGameBoard() {
        int maxValue = Main.findMax(new int[]{3, 5, 7, 1, 4, 2, 9, 6});
        assertEquals(9, maxValue);
    }
}
