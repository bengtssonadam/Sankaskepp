import java.util.Scanner;

public class Main {
    public static int numRows = 9;
    public static int numCols = 9;
    public static int playerShips;
    public static int computerShips;
    public static String[][] gameBoard = new String[numRows][numCols];
    //public static int[][] missedGuesses = new int[numRows][numCols];
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

        System.out.println("\nWelcomem Captain : Place your ships:");
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
                System.out.println("You alredy have a ships on this coordinats");
            }
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

    private static void GameLoop() {

        playerTurn();
        computerTurn();
        printOceanMap();

        System.out.println();
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        System.out.println();
    }



    private static void playerTurn() {


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
                if ((x > 0 && x <= numRows) && (y > 0 && y <= numCols)) {
                //Check for computer ship
                   if (gameBoard[x][y] == "cs") {
                       System.out.println(" Good shoot Captain, thats a HIT!!!");
                       gameBoard[x][y] = "xx";
                       computerShips--;
                   }
                   else if (gameBoard[x][y] =="ps") {
                       System.out.println("Captain, Are you drunk? We sank our own ship!!!");
                       gameBoard[x][y] = "oo";
                       playerShips--;
                   }
                   else if (gameBoard[x][y] == "--"){
                       System.out.println("Oh no!! Thats a miss, Better luck next time Captain.");
                       gameBoard[x][y] = "ms";
                   }
               }
               else if ((x <= 0 || x > numRows) || (y <= 0 || y > numCols))
                   System.out.println("Please Captain, try to focus. We cant shot outside the water.  ");
                }
                while ((x < 0 || x >= numRows)||(y < 0 || y >= numCols));
                }

    private static void computerTurn() {
        System.out.println(" Now its computer's turn to shot, Watch out so they don't hit one of your ship.");
        int x = 0;
        int y = 0;

        //random pick x & y coordinats for computers shots.
        do {
            x = (int) (Math.random()*10);
            y = (int) (Math.random()*10);

            if ((x > 0 && x <= numRows) && (y > 0 && y <= numCols))
            {
                if (gameBoard[x][y] == "ps")  {
                    System.out.println("The Computer sunk one of your ships Captain !!!");
                    gameBoard[x][y] = "oo";
                    playerShips--;
                }

                else if (gameBoard[x][y] == "cs") {
                    System.out.println("Captain don't worry!!! The Computer is sinking there own ship.");
                    gameBoard[x][y] = "xx";
                    computerShips--;
                }

                else if (gameBoard[x][y] == "--") {
                    System.out.println("Captain don't worry!!! The Computer is hitting the water!!");
                }
        }
        }
                while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) ;

        }

        public static void gameOver(){
                System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
                if(playerShips > 0 && computerShips <= 0)
                    System.out.println("good figth Captain!!! You won the battle");
                else
                    System.out.println("Sorry Captain, You lost all your ships");
                System.out.println();
            }
    private static void printOceanMap() {
        System.out.println();
        //Y-coordinats 1-9 over gameboard
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i +1 +" ");
        System.out.println();

        //X-coordinats on the sides of gameboard
        for(int x = 0; x < gameBoard.length; x++) {
            System.out.print((x+1) + "|");

            for (int y = 0; y < gameBoard[x].length; y++){
                System.out.print(gameBoard[x][y]);
            }

            System.out.println("|" + (1+x));
        }

        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i + 1 + " ");
        System.out.println();

    }


        public static void main(String[] args) {

        createGameBoard();
        placePlayersShips();
        simulateComputerShipsAndPlace();

            do {
                GameLoop();
            }
            while(playerShips != 0 && computerShips != 0);
            gameOver();
    }
}

