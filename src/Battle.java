import java.util.Scanner;

public class Battle {
    final int SHIPS = 3;
    Player player1;
    Player player2;
    boolean running;

    protected void inItGame(int rows, int cols) {
        player1 = new Player("Player 1",SHIPS, rows, cols);
        player2 = new Player("Player 2",SHIPS, rows, cols);
        running = true;
        placeShip(player1);
        placeShip(player2);
    }

    protected void placeShip(Player player){
        player.getBoard().printGameBoard(false);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome " + player.name + ", place your ships");

        for(int i = 1; i <= SHIPS; i++){
            System.out.print("Enter Y coordinate for your " + i + " of "+ SHIPS +" ships: ");
            int y = input.nextInt();
            System.out.print("Enter X coordinate for your " + i + " of "+ SHIPS +" ships: ");
            int x = input.nextInt();
            player.getBoard().getGameBoard()[y][x] = Cell.SHIP;
        }
    }

    public void playerTurn(Player player, Player opponent) {


        System.out.println("\n" + player.name +" it's your time to shot!!!");
        System.out.println("\n" +player.name + " you have: " + player.playerShipNumber + " ship left and " + opponent.name + " have: " + opponent.playerShipNumber + " ship left" );
        int x ;
        int y ;

            Scanner input = new Scanner(System.in);
            System.out.print("Set Y coordinat for strik: ");
            y = input.nextInt();
            System.out.print("Set X coordinat for strik: ");
            x = input.nextInt();

            // Check so coordinats is valid
            if ((x >= 0 && x <= opponent.getBoard().numRows) && (y >= 0 && y <= opponent.getBoard().numCols)) {
                //Check for computer ship
                if (opponent.getBoard().getGameBoard()[y][x]==(Cell.SHIP)) {
                    System.out.println("\nGood shoot " + player.name + ", that's a HIT!!!");
                    opponent.getBoard().getGameBoard()[y][x] = Cell.HIT_SHIP;
                    opponent.playerShipNumber--;}

                else if (opponent.getBoard().getGameBoard()[y][x].equals(Cell.EMPTY)){
                    System.out.println("\nOh no!! That's a miss " + player.name + ", Better luck next time Captain.");
                    opponent.getBoard().getGameBoard()[y][x] = Cell.MISS;
                }
                else if (opponent.getBoard().getGameBoard()[x][y].equals(Cell.HIT_SHIP)) {
                    System.out.println("\nThat ship is alredy hit" + player.name + " .");
                }
            }
            else if ((x > 0 || x<= opponent.getBoard().numRows) || (y >= 0 || y < opponent.getBoard().numCols))
                System.out.println("\nPlease " + player.name + ", try to focus. You can't shot outside the gamboard.");
    }

    public void GameLoop() {
        while(player1.playerShipNumber != 0 && player2.playerShipNumber!= 0) {
            player2.getBoard().printGameBoard(true);
            playerTurn(player1, player2);
            player1.getBoard().printGameBoard(true);
            playerTurn(player2, player1);
        }
    }

    public void gameOver(){
        System.out.println( "\n" + player1.name + " has: " + player1.playerShipNumber + " ship | " + player2.name + " has: " + player2.playerShipNumber + " ship");
        if(player1.playerShipNumber > 0 && player2.playerShipNumber <= 0)
            System.out.println("\nGood figth " +player1.name + " !!! You won the battle!!!");
        else if (player2.playerShipNumber > 0 && player1.playerShipNumber <= 0)
            System.out.println("\nGood figth " + player2.name + " !!! You won the battle!!!");
        System.out.println();
    }
}
