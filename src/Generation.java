public class Generation {
    private int generationNumber = 0;
    Board board;

    public Generation(Board board) {
        this.board = board;
    }

    public void setUpSquares() {
        board.setBox(0,0,true);
    }
}
