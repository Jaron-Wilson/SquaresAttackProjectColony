public class Generation {
    private int generationNumber = 0;
    Board board;
    Squares squares;

    public Generation(Board board, Squares squares) {
        this.board = board;
        this.squares = squares;
    }

    public void setUpSquares() {
        board.setBox(0,0,true, 1);

    }

    public void checkWhoDies(int x, int y, int newX, int newY) {
        boolean[][] grid = board.getGrid();
        int[][] gridValues = board.getGridValues();
        if (gridValues[x][y] != 0) {
            if(grid[x][y]) {
                if (newX >= 0 && newX < board.getSize().getWidth()-1 && newY >= 0 && newY < board.getSize().getHeight()-1) {
                    grid[newX][newY] = true;
                    gridValues[newX][newY] = 1;
                    //System.out.println(gridValues[newX][newY]);
                } else {
                    System.out.println("Too far!");
                }

            }
        }
    }

    public int getGenerationNumber() {
        return generationNumber;
    }

    public void setGenerationNumber(int generationNumber) {
        this.generationNumber = generationNumber;
    }
}
