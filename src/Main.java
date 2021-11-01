public class Main {

    public static void main(String[] args) {
        Battle.createGameBoard();
        Battle.placePlayersShips();
        Battle.placeComputerShips();


            do {
                Battle.GameLoop();
            } while(Battle.playerShips != 0 && Battle.computerShips != 0);
            Battle.gameOver();
    }
}

