public class GameBoard {
    public static int numRows = 9;
    public static int numCols = 9;
    public static String[][] gameBoard = new String[numRows][numCols];
    protected static void createGameBoard() {
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
    public static void printGameBoard() {
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