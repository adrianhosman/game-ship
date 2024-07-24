import java.util.ArrayList;
import java.util.List;

public class Player {
    private Grid grid;
    private List<Ship> ships;
    private List<int[]> missileTargets;

    public Player(int gridSize) {
        this.grid = new Grid(gridSize);
        this.ships = new ArrayList<>();
        this.missileTargets = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
        grid.shipPos(ship.getX(), ship.getY());
    }

    public void addMissileTarget(int x, int y) {
        missileTargets.add(new int[]{x, y});
    }

    public void attack(Player otherPlayer) {
        for (int[] target : missileTargets) {
            otherPlayer.getGrid().updateGrid(target[0], target[1]);
        }
    }
    public Grid getGrid() {
        return grid;
    }

    public int getTotalHits() {
        return grid.getTotalHits();
    }
}
