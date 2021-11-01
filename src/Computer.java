public class Computer extends GameBoard{
    public static int computerShips = Player.playerShips;
    protected static void placeComputerShips() {
        System.out.println("\nThe Computer is position it's " + computerShips +" ships: Place wait:");

        for (int i = 1; i <= computerShips;){
            int x = (int)(Math.random() * 9);
            int y = (int)(Math.random() * 9);

            if ((x > 0 && x <= numRows) && (y > 0 && y <= numCols) && (gameBoard[x][y] ==("  "))) {
                gameBoard[x][y] = "c1";
                System.out.println("Computer has placed " + i + " of " + Computer.computerShips +" ships");
                i++;
            }
        }
    }
    protected static void computerTurn() {
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
                    Player.playerShips--;
                }
                else if (gameBoard[x][y] == "c1") {
                    System.out.println("Captain don't worry!!! The Computer is sinking there own ship.");
                    gameBoard[x][y] = "xx";
                    Computer.computerShips--;
                }
                else if (gameBoard[x][y] == "  ") {
                    System.out.println("Captain don't worry!!! The Computer is hitting the water!!");
                }
            }
        }
        while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) ;
    }
}
