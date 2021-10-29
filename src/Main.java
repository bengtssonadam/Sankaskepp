import java.util.Scanner;

public class Main {
    public static int numRows = 9;
    public static int numCols = 9;
    public static int playerShips;
    public static int computerShips;
    public static String[][] gameBoard = new String[numRows][numCols];
    public static int[][] missedGuesses = new int[numRows][numCols];
    private static void createGameBoard() {
        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i +1 +" ");
        System.out.println();

        //X-coordinats on both sides of gameboard
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = "--";
                if (j == 0)
                    System.out.print(i +1 + "|" + gameBoard[i][j]);
                else if (j == gameBoard[i].length - 1)
                    System.out.print(gameBoard[i][j] + "|" + (1 + i));
                else
                    System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i+1 + " ");
        System.out.println();
    }
    private static void placePlayersShips() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlayer 1: Place your ships:");
        //Place 3 ships for player
        playerShips = 3;
        for (int i = 1; i <= playerShips;) {
            System.out.print("Enter X coordinate for your " + i + " of "+ playerShips +" ships: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " of "+ playerShips +" ships: ");
            int y = input.nextInt();

            if ((x > 0 && x <= numRows) && (y > 0 && y <= numCols) && (gameBoard[x][y] == "--")) {
                gameBoard[x][y] = "ps";
                i++;
            } else if ((x > 0 && x <= numRows) && (y < 0  && y >= numCols && gameBoard[x][y] == "ps")){
                System.out.println("You alredy have a ships on this coordinats");  }
            else if ((x < 0 || x > numRows) || (y < 0 || y > numCols))
                System.out.println("You can't place your ship outside the " + numRows + " by " + numCols + " gameboard");
            }
        System.out.println("Smart choices Captin, Soon time for battle.");
    }

    private static void simulateComputerShipsAndPlace() {
        System.out.println("Generet and placing Computers 3 ships: Place wait:");
        computerShips = 3;
        for (int i = 1; i <= computerShips;){
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

        if ((x > 0 && x <= numRows) && (y > 0 && y <= numCols) && (gameBoard[x][y] == "--")) {
            gameBoard[x][y] = "cs";
            System.out.println("Computer has placed " + i + " of " + computerShips +" ships");
            i++;
            }
        }
    }

    private static void gameLoop() {

        System.out.println("\nTime to go to Battle Captain!!!");


            int x = 0;
            int y = 0;

                do {
                 Scanner input = new Scanner(System.in);
                 System.out.print("Set row coordinat for strik");
                 x = input.nextInt();

                 System.out.print("Set col coordinat for strik");
                 y = input.nextInt();

               // Check so coordinats is valid
               if ((x < 0 && x <= numRows) && (y < 0 && y <= numCols)) {
                //Check for computer ship
                   if (gameBoard[x][y] = "cs") {
                       System.out.println(" Good shoot Captain, thats a HIT!!!");
                       gameBoard[x][y] = "xx";
                       computerShips--;
                   }
               }
           }
           }
    }

        public static void main(String[] args) {

        createGameBoard();
        placePlayersShips();
        simulateComputerShipsAndPlace();
        gameLoop();

    }
}

