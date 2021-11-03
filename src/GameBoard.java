public class GameBoard {
    public int numRows = 9;
    public int numCols = 9;
    public Cell[][] gameBoard = new Cell[numRows][numCols];
    protected GameBoard createGameBoard(GameBoard board) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = Cell.EMPTY;
            }
        }return this ;
    }
    public void printGameBoard(GameBoard board) {

        System.out.println();
        //Y-coordinats 1-9 over gameboard
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i +" ");
        System.out.println();

        //X-coordinats on the sides of gameboard

        int x = 0;
            for(var row : board.gameBoard) {
                System.out.print(x + "|");
                for(var cell : row) {
                    if(cell == Cell.EMPTY || cell == Cell.SHIP) {
                        System.out.print("  ");
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
            //Y-coordinats 1-9 under gameboard
            System.out.print("  ");
            for(int i = 0; i < numCols; i++)
            System.out.print(i + " ");
        System.out.println();
    }

    public GameBoard getGameBoard() {
        return this;
    }
}
