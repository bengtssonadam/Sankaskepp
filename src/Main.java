public class Main {

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.inItGame();

        do {
            battle.GameLoop();
            } while(Player.playerShips != 0 && Computer.computerShips != 0);
            battle.gameOver();
    }
}

