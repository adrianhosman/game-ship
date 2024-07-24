import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GridTest {

    @Test
    public void GetTotalHits_success_there_ship() {
        Grid grid = new Grid(5);
        grid.shipPos(0,0);
        grid.updateGrid(0,0);

        int hits = grid.getTotalHits();
        assertEquals(1,hits);
    }

    @Test
    public void GetTotalHits_success_miss_missleTarget() {
        Grid grid = new Grid(5);
        grid.shipPos(0,0);
        grid.updateGrid(1,0);

        int hits = grid.getTotalHits();
        assertEquals(0,hits);
    }
}
