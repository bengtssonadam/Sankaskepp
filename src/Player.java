public class Player {

    public String name;
    public int playerShipNumber;
    GameBoard board;

    public Player(String name,int playerShipNumber, int rows, int cols ) {
        this.name = name;
        this.playerShipNumber = playerShipNumber;
        this.board = new GameBoard(rows,cols);
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }
}
