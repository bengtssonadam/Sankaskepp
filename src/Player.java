import java.util.Scanner;

public class Player extends GameBoard {
    public static int playerShips = 3;
    public static void placePlayerShips(){

    System.out.println("\nWelcomem Captain : Place your ships:");
    Scanner input = new Scanner(System.in);

    //Place 3 ships for player
        for (int i = 1; i <= playerShips;i++) {
        System.out.print("Enter X coordinate for your " + i + " of "+ playerShips +" ships: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate for your " + i + " of "+ playerShips +" ships: ");
        int y = input.nextInt();

        if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (gameBoard[x][y] == ("  "))) {
            gameBoard[x][y] = "p1";

        } else if ((x >= 0 && x < numRows) && (y >= 0  && y > numCols && gameBoard[x][y] == ("p1"))){
            System.out.println("You alredy have a ships on this coordinats");
        }
        else if ((x <= 0 || x > numRows) || (y <= 0 || y > numCols))
            System.out.println("You can't place your ship outside the " + numRows + " by " + numCols + " gameboard");
    }
        System.out.println("\nSmart choices Captin, Soon time for battle.");
}
    protected static void playerTurn() {


        System.out.println("\nCaptain it's your time to shot!!!");
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
                if (gameBoard[x][y]==("c1")) {
                    System.out.println(" Good shoot Captain, that's a HIT!!!");
                    gameBoard[x][y] = "xx";
                    Computer.computerShips--;
                }
                //Check for own ships
                else if (gameBoard[x][y] =="p1") {
                    System.out.println("Captain, Are you drunk? We sank our own ship!!!");
                    gameBoard[x][y] = "oo";
                    playerShips--;
                }
                else if (gameBoard[x][y] == "  "){
                    System.out.println("\nOh no!! That's a miss, Better luck next time Captain.");
                    gameBoard[x][y] = "--";
                }
                else if (gameBoard[x][y] == "oo"){
                    System.out.println("\n<That ship is alredy hit");
                }
            }
            else if ((x > 0 || x<= numRows) || (y >= 0 || y < numCols))
                System.out.println("\nPlease Captain, try to focus. We cant shot outside the gamboard.");
        }
        while ((x < 0 || x >= numRows)||(y < 0 || y >= numCols));
    }



}
