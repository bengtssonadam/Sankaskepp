public class Main {

    public static void main(String[] args) {
        Battle.inItGame();

        do {
            Battle.GameLoop();
            } while(Player.playerShips != 0 && Computer.computerShips != 0);
            Battle.gameOver();
    }
}

