import javax.swing.*;

public class Main {
    private int windowSize = 800;
    private String title = "Game Board";
    private int size = 20;
//    private int cellSize = 20;
    private int cellSize = windowSize/size;

    public static void main(String[] args) {
        Main main = new Main();
        Board board = new Board(main);  // Create an instance of the Board class
        Squares squares = new Squares();
        Generation generation = new Generation(board, squares);
        System.out.println("Starting...");
        SwingUtilities.invokeLater(() -> {
            board.setVisible(true);  // Make the JFrame visible
        });


        generation.setUpSquares();

        while (true) {
            for (int i = 0; i < board.getGrid().length; i++) {
                System.out.println(board.getGrid()[i][i]);
                generation.checkWhoDies(i,i,i+1,i+1);
            }
//            System.out.println(generation);

            try {
                Thread.sleep(100); // Add a delay of 100 milliseconds
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