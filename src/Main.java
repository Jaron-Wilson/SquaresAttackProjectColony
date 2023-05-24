import javax.swing.*;

public class Main {
    private int windowSize = 800;
    private String title = "Game Board";
    private int size = 20;
//    private int cellSize = 20;
    private int cellSize = windowSize/size;

    public static void main(String[] args) {
        System.out.println("Loading Classes...");
        Main main = new Main();
        Board board = new Board(main);  // Create an instance of the Board class
        Squares squares = new Squares();
        Generation generation = new Generation(board, squares);
        System.out.println("Classes Loaded! \n Starting Game...");
        SwingUtilities.invokeLater(() -> {
            board.setVisible(true);  // Make the JFrame visible
        });


        main.mainGameLoop(board, generation, squares);


    }

    public void mainGameLoop(Board board, Generation generation, Squares squares) {
        System.out.println("Setting up Basic squares!");
        generation.setUpSquares();
        System.out.println("Loaded! \n GameLoop STARTED");
        while (true) {
            int gridSize = getSize();
            for (int row = 0; row < gridSize - 1; row++) {
                for (int col = 0; col < gridSize - 1; col++) {
//                    System.out.println(board.getGrid()[row][col]);
                    generation.checkWhoDies(row, col, row + 1, col + 1);

                }
            }

//            System.out.println(generation);
            try {
                Thread.sleep(500); // Add a delay of 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

}