public class Main {

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.inItGame(10,10);
       do {

           battle.GameLoop();
       }while (battle.player1.playerShipNumber != 0 && battle.player2.playerShipNumber!= 0);
        battle.gameOver();
    }
}

