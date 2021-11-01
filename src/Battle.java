import java.util.Scanner;

public class Battle {
    public static int numRows = 9;
    public static int numCols = 9;
    public static int playerShips = 3;
    public static int computerShips = 3;
    public static String[][] gameBoard = new String[numRows][numCols];
    static void createGameBoard() {
        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i + " ");
        System.out.println();

        //X-coordinats on both sides of gameboard
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = "  ";
                if (j == 0)
                    System.out.print(i + "|" + gameBoard[i][j]);
                else if (j == gameBoard[i].length - 1)
                    System.out.print(gameBoard[i][j] + "|" + i);
                else
                    System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i + " ");
        System.out.println();
    }
    static void placePlayersShips() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcomem Captain : Place your ships:");
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

    static void placeComputerShips() {
        System.out.println("\nThe Computer is palcing it's " + computerShips +" ships: Place wait:");

        for (int i = 1; i <= computerShips;){
            int x = (int)(Math.random() * 9);
            int y = (int)(Math.random() * 9);

            if ((x > 0 && x <= numRows) && (y > 0 && y <= numCols) && (gameBoard[x][y] ==("  "))) {
                gameBoard[x][y] = "c1";
                System.out.println("Computer has placed " + i + " of " + computerShips +" ships");
                i++;
            }
        }
    }

    static void GameLoop() {

        playerTurn();
        computerTurn();
        printOceanMap();

        System.out.println();
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        System.out.println();
    }

    private static void playerTurn() {


        System.out.println("\n Captain it's your time to shot!!!");
        int x ;
        int y ;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Set X coordinat for strik");
            x = input.nextInt();

            System.out.print("Set Y coordinat for strik");
            y = input.nextInt();
            // Check so coordinats is valid
            if ((x >= 0 && x <= numRows) && (y >= 0 && y <= numCols)) {
                //Check for computer ship
                if (gameBoard[x][y]==("c1")) {
                    System.out.println(" Good shoot Captain, that's a HIT!!!");
                    gameBoard[x][y] = "xx";
                    computerShips--;
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
            else if ((x <= 0 || x > numRows) || (y <= 0 || y > numCols))
                System.out.println("\nPlease Captain, try to focus. We cant shot outside the gamboard.");
        }
        while ((x < 0 || x >= numRows)||(y < 0 || y >= numCols));
    }

    private static void computerTurn() {
        System.out.println(" \nNow its computer's turn to shot, Watch out so they don't hit one of your ship.");
        int x = 0;
        int y = 0;

        //random pick x & y coordinats for computers shots.
        do {
            x = (int) (Math.random()*9);
            y = (int) (Math.random()*9);

            if ((x >= 0 && x <= numRows) && (y >= 0 && y <= numCols))
            {
                if (gameBoard[x][y] == "p1")  {
                    System.out.println("The Computer sunk one of your ships Captain !!!");
                    gameBoard[x][y] = "oo";
                    playerShips--;
                }

                else if (gameBoard[x][y] == "c1") {
                    System.out.println("Captain don't worry!!! The Computer is sinking there own ship.");
                    gameBoard[x][y] = "xx";
                    computerShips--;
                }

                else if (gameBoard[x][y] == "  ") {
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
            System.out.print(i +" ");
        System.out.println();

        //X-coordinats on the sides of gameboard
        for(int x = 0; x < gameBoard.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < gameBoard[x].length; y++){
                System.out.print(gameBoard[x][y]);
            }

            System.out.println("|" + x);
        }

        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i + " ");
        System.out.println();

    }
}
