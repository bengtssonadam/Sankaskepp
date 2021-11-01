public class Main {

    public static void main(String[] args) {
        Battle.placePlayersShips();
        Battle.placeComputerShips();
        Battle.createGameBoard();

            do {
                Battle.GameLoop();
            } while(Battle.playerShips != 0 && Battle.computerShips != 0);
            Battle.gameOver();
    }
}

