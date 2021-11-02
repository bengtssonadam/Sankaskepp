public class Battle {

    protected static void inItGame() {
        Player player
        GameBoard.createGameBoard();
        Player.placePlayerShips();
        Computer.placeComputerShips();
    }
    protected static void GameLoop() {

        Player.playerTurn();
        Computer.computerTurn();
        GameBoard.printGameBoard();

        System.out.println();
        System.out.println("Your ships: " + Player.playerShips + " | Computer ships: " + Computer.computerShips);
        System.out.println();
    }
    public static void gameOver(){
        System.out.println("Your ships: " + Player.playerShips + " | Computer ships: " + Computer.computerShips);
        if(Player.playerShips > 0 && Computer.computerShips <= 0)
            System.out.println("Good figth Captain!!! You won the battle!!!");
        else
            System.out.println("Sorry Captain, You lost all your ships");
        System.out.println();
    }

}
