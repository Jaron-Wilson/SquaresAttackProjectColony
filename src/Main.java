import javax.swing.*;
import java.util.Random;

public class Main {
    private String title = "Game Board";
    private int size = 100;
    private int width = 800, height = 800;
//    private int cellSize = windowSize/size;
    private int cellSize = width/size;

    public static void main(String[] args) {
        System.out.println("Loading Classes...");
        Main main = new Main();
        Board board = new Board(main);  // Create an instance of the Board class
        Square squares = new Square();
        Generation generation = new Generation(board, squares);
        System.out.println("Classes Loaded! \n Starting Game...");
        SwingUtilities.invokeLater(() -> {
            board.setVisible(true);  // Make the JFrame visible
        });


        main.mainGameLoop(board, generation, squares);

    }


    public void mainGameLoop(Board board, Generation generation, Square squares) {
        Random random = new Random();
        System.out.println("Setting up Basic squares!");
        generation.setUpStartingSquares();
        System.out.println("Loaded! \n GameLoop STARTED");
        while (true) {
//            int gridSize = getSize();

//            for (int x = 0; x < gridSize; x++) {
//                for (int y = 0; y < gridSize ; y++) {
////                    generation.checkWhoDies(row, col, row + 1, col + 1);
////                    generation.checkWhoDies(x, y, x+1 , y+0);
//                    board.setBox(x, y, true, 2);
//                }
//            }


//            System.out.println(board.getGrid()[3][3].getColor()); // Get the color of the square




//            int x = random.nextInt(gridSize);
//            int y = random.nextInt(gridSize);
//            if (board.getGrid()[x][y].getType() == 0) {
//                board.setBox(x, y, true, random.nextInt(3) + 1); // Activate the square at position (x, y) and set its type to ?
////                for (int e = 0; e < gridSize; e++) {
////                    for (int f = 0; f < gridSize; f++) {
//////                    generation.checkWhoDies(row, col, row + 1, col + 1);
//////                    generation.checkWhoDies(x, y, x+1 , y+0);
////                        board.setBox(e, f, true, 3);
////                    }
////                }
//            }




            Square[][] grid = board.getGrid();
            int gridLength = grid.length;

            for (int x = 0; x < gridLength; x++) {
                for (int y = 0; y < gridLength; y++) {
                    try {
                        Thread.sleep(100); // Delay of 1 second
                    } catch (InterruptedException e) {
                        // Handle exception if needed
                    }
                    System.out.println(x + ", " + y);
                    if (squares.canMoveHere(x, y, board)){
                        grid[x][y].setType(grid[x][y].getType());
                        grid[x][y].setActive(true);
                        // Render the game board
                        board.repaint();
                    }
                }
            }





        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getWindowWidth() {
        return width;
    }

    public int getWindowHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

}