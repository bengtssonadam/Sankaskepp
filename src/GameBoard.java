public class GameBoard {

    int numRows ;
    int numCols;
    Cell[][] gameBoard;

    public GameBoard(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        gameBoard = new Cell[numRows][numCols];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = Cell.EMPTY;
            }
        }
    }
    
    public void printGameBoard(boolean hideShips) {
        System.out.println();
        //Y-coordinats  over gameboard
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i +" ");
        System.out.println();

        //X-coordinats on the sides and gameboard
        int x = 0;
        for(var row : gameBoard) {
            System.out.print(x + "|");
            for(var cell : row) {
                if(cell == Cell.EMPTY ) {
                    System.out.print("  ");
                }
                else if(cell == Cell.SHIP) {
                    if(hideShips)
                        System.out.print("  ");
                    else
                        System.out.println("oo");
                }
                else if(cell == Cell.MISS){
                    System.out.print("--");
                }
                else if (cell == Cell.HIT_SHIP){
                    System.out.print("xx");
                }
            }
            System.out.println("|" + x);
            x++;
        }
        //Y-coordinats under gameboard
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i + " ");
        System.out.println();
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}

