import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private Player player1;
    private Player player2;
    private Integer gridSize;


    public Game (String inputFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        gridSize = Integer.parseInt(reader.readLine().trim());
        int totalShips = Integer.parseInt(reader.readLine().trim());

        player1 = new Player(gridSize);
        player2 = new Player(gridSize);

        String[] player1Pos = reader.readLine().trim().split(":");
        if(player1Pos.length >totalShips){
            System.out.printf("The Coordinate for Ship Pos is more then :%d",totalShips);
            return;
        }

        for (String pos : player1Pos) {
            String[] coor = pos.split(",");
            player1.addShip(new Ship(Integer.parseInt(coor[0]),Integer.parseInt(coor[1])));
        }

        String[] player2Pos = reader.readLine().trim().split(":");
        if(player2Pos.length >totalShips){
            System.out.printf("The Coordinate for Ship Pos is more then :%d",totalShips);
            return;
        }

        for (String pos : player2Pos) {
            String[] coor = pos.split(",");
            player2.addShip(new Ship(Integer.parseInt(coor[0]),Integer.parseInt(coor[1])));
        }
        int totalMissiles = Integer.parseInt(reader.readLine().trim());

        String[] player1AttPos = reader.readLine().trim().split(":");
        if(player1AttPos.length >totalMissiles){
            System.out.printf("The Coordinate for missle is more then :%d",totalShips);
            return;
        }

        for (String pos : player1AttPos) {
            String[] coor = pos.split(",");
            player1.addMissileTarget(Integer.parseInt(coor[0]),Integer.parseInt(coor[1]));
        }

        String[] player2AttPos = reader.readLine().trim().split(":");
        if(player2AttPos.length >totalMissiles){
            System.out.printf("The Coordinate for missle is more then :%d",totalShips);
            return;
        }

        for (String pos : player2AttPos) {
            String[] coor = pos.split(",");
            player2.addMissileTarget(Integer.parseInt(coor[0]),Integer.parseInt(coor[1]));
        }

        reader.close();
    }


    public void startGame() {
        player1.attack(player2);
        player2.attack(player1);

        System.out.println("Player 1 Grid:");
        player1.getGrid().displayGrid();
        System.out.println("Player 2 Grid:");
        player2.getGrid().displayGrid();

        int player1Hits = player2.getTotalHits();
        int player2Hits = player1.getTotalHits();

        System.out.println("P1:" + player1Hits);
        System.out.println("P2:" + player2Hits);

        if (player1Hits > player2Hits) {
            System.out.println("Player 1 wins");
        } else if (player2Hits > player1Hits) {
            System.out.println("Player 2 wins");
        } else {
            System.out.println("It is a draw");
        }
    }
}
