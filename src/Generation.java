public class Generation {
    private int generationNumber = 0;
    Board board;
    Square squares;

    public Generation(Board board, Square squares) {
        this.board = board;
        this.squares = squares;
    }

    public void setUpStartingSquares() {
        board.setBox(0,0,true, 1);
        board.setBox(0,1,true, 2);
        board.setBox(0,2,true, 3);

        board.setBox(2,12,true, 3);
        board.setBox(12,34,true, 3);
        board.setBox(35,66,true, 3);
        board.setBox(12,57,true, 3);
        board.setBox(7,6,true, 3);

    }

    public void checkWhoDies(int x, int y, int newX, int newY) {
        Square[][] grid = board.getGrid();
        if (grid[x][y].isActive()) {
            if (newX >= 0 && newX < board.getSize().getWidth() - 1 && newY >= 0 && newY < board.getSize().getHeight() - 1) {
                //if(grid[newY][newX].getType() == 0) {
                 //   grid[newY][newX].setActive(true);
                //}else {
//                    squares.setColor(grid[x][y].getType());






                    squares.checkDeath(board,x,y,grid[x][y].getType());

               // }
                //System.out.println(gridValues[newX][newY]);
            } else {
                System.out.println("Too far!");
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
