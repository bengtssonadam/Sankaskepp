import java.util.Scanner;

public class Player extends GameBoard  {

    public static int playerShips = 3;
    private final String name;

    public Player(String name) {
        this.name = name;
    }


    public void placePlayerShips(GameBoard board){

        System.out.println("\nWelcomem " + name + ": Place your ships:");
        Scanner input = new Scanner(System.in);




        //Place 3 ships for player
        for (int i = 1; i <= playerShips;i++) {
            System.out.print("Enter X coordinate for your " + i + " of "+ playerShips +" ships: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " of "+ playerShips +" ships: ");
            int y = input.nextInt();

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (gameBoard[x][y] == Cell.EMPTY)) {
                gameBoard[x][y] = Cell.SHIP;
            }
            else if ((x >= 0 && x < numRows) && (y >= 0  && y > numCols && gameBoard[x][y] == Cell.SHIP)) {
                System.out.println("You alredy have a ships on this coordinats");
            }
            else if ((x <= 0 || x > numRows) || (y <= 0 || y > numCols))
                System.out.println("You can't place your ship outside the " + numRows + " by " + numCols + " gameboard");
        }
        System.out.println("\nSmart choices " + name +", Soon time for battle.");
    }

    protected void playerTurn() {


        System.out.println("\n"+ name +" it's your time to shot!!!");
        int x ;
        int y ;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Set X coordinat for strik: ");
            x = input.nextInt();

            System.out.print("Set Y coordinat for strik: ");
            y = input.nextInt();
            // Check so coordinats is valid
            if ((x >= 0 && x <= numRows) && (y >= 0 && y <= numCols)) {
                //Check for computer ship
                if (gameBoard[x][y]==(Cell.SHIP)) {
                    System.out.println(" Good shoot " + name + ", that's a HIT!!!");
                    gameBoard[x][y] = Cell.HIT_SHIP;
                    Computer.computerShips--;}

                else if (gameBoard[x][y].equals(Cell.EMPTY)){
                    System.out.println("\nOh no!! That's a miss" + name + ", Better luck next time Captain.");
                    gameBoard[x][y] = Cell.MISS;
                }
                else if (gameBoard[x][y].equals(Cell.HIT_SHIP)) {
                    System.out.println("\n That ship is alredy hit " + name + " .");
                    gameBoard[x][y] = Cell.HIT_SHIP;
                }
            }
            else if ((x > 0 || x<= numRows) || (y >= 0 || y < numCols))
                System.out.println("\nPlease " + name + ", try to focus. We cant shot outside the gamboard.");
        }
        while ((x < 0 || x >= numRows)||(y < 0 || y >= numCols));
    }
}
