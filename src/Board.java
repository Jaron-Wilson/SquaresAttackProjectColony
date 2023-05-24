import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private Squares[][] grid; // 2D array of Cell objects to represent the grid

    private Main main;

    public Board(Main main) {
        this.main = main;
        setUpWindow();  // Method to set up the JFrame window
        grid = new Squares[main.getSize()][main.getSize()];  // Initializing the grid
        initializeGrid();  // Method to set all elements in the grid to false

//        grid[0][0] = true;  // Setting element at position [0][0] to true
    }

    void setBox(int x, int y, boolean b, int type) {
        grid[x][y].setColor(type);
        grid[x][y].setActive(b);
    }

    private void setUpWindow() {
        setTitle(main.getTitle());  // Setting the title of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the application when the window is closed

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g, main.getCellSize());  // Method to draw the grid on the panel
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(main.getWindowSize(), main.getWindowSize());  // Setting the preferred size of the panel
            }
        };

        add(panel);  // Adding the panel to the JFrame
        pack();  // Packing the components within the JFrame
        setLocationRelativeTo(null);  // Center the frame on the screen
    }

    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Squares();
                grid[i][j].setActive(false);  // Setting all elements in the grid to false
                grid[i][j].setType(0); // Setting all elements in the grid to type 0;
            }
        }
    }

    private void drawGrid(Graphics g, int cellSize) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int x = col * cellSize;  // X-coordinate of the box
                int y = row * cellSize;  // Y-coordinate of the box

                if (grid[row][col].isActive()) {
                    g.setColor(grid[row][col].getColor());  // Set color to colorType if the box is true
                } else {
                    g.setColor(Color.WHITE);  // Set color to white if the box is false
                }


                g.fillRect(x, y, cellSize, cellSize);  // Fill the True boxes with the specified color

                g.setColor(Color.BLACK); // Line colors
                g.drawRect(x, y, cellSize, cellSize);  // Draw the outlines of the boxes/ GRIDS

            }
        }
    }

    public Squares[][] getGrid() {
        return grid;
    }


}