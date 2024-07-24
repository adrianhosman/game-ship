import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void GetGrid() {
        Player player = new Player (5);

        Grid playerGrid = player.getGrid();
        Grid expect = new Grid(5);
        assertEquals(expect,playerGrid);
    }
}
