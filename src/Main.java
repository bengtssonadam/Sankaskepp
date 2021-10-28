public class Main {
    public static int numRows = 9;
    public static int numCols = 9;
    public static int playerShips;
    public static int computerShips;
    public static String[][] gameboard = new String[numRows][numCols];
    public static int[][] missedGuesses = new int[numRows][numCols];
    private static void createGameBoard() {
        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i +1 +" ");
        System.out.println();

        //X-coordinats on both sides of gameboard
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = "  ";
                if (j == 0)
                    System.out.print(i +1 + "|" + gameboard[i][j]);
                else if (j == gameboard[i].length - 1)
                    System.out.print(gameboard[i][j] + "|" + (1 + i));
                else
                    System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
        //Y-coordinats 1-9 under gameboard
        System.out.print("  ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i+1 + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        createGameBoard();
    }


}

