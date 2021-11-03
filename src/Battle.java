public class Battle {

    Player player1 = new Player("Player 1");
    Computer player2 = new Computer("Computer");

    protected void inItGame() {
        player1.createGameBoard(player1);
        player2.createGameBoard(player2);
        player1.getGameBoard();
        player2.getGameBoard();
        player1.printGameBoard(player1);

        player1.placePlayerShips(player2);
        player1.printGameBoard(player2);
        player2.placeComputerShips();
        player2.printGameBoard(player1);




    }
    protected void GameLoop() {

        player1.playerTurn();
        player1.printGameBoard(player2);
        player2.computerTurn();
        player2.printGameBoard(player1);

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
