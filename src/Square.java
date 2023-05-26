import java.awt.*;

public class Square {

    private int type = 0; // 1,2,3 // 0 means off
    private Color color;
    private double[] spreadChance = {0.0, 0.2, 0.3, 0.5};
    private int powerLevel = 1;
    private int lifeTime = 100;
    private boolean active = false;


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setColor(int type) {
        this.type = type; // Update the type property of the Squares object

        switch (type) {
            case 0 -> {
                color = Color.WHITE;
            }
            case 1 -> {
                color = Color.BLACK;
            }
            case 2 -> {
                color = Color.GREEN;
            }
            case 3 -> {
                color = Color.RED;
            }
            default -> {
                color = Color.WHITE;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public double[] getSpreadChance() {
        return spreadChance;
    }

    public void setSpreadChance(double[] spreadChance) {
        this.spreadChance = spreadChance;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void setNull(int x, int y, Square[][] grid) {
        if (grid != null) {
            grid[x][y].setActive(false);
            grid[x][y].setType(0);
        }
    }

    public boolean checkDeath(Board board, int x, int y, int type) {
        Square[][] grid = board.getGrid();

//        if it is deactivate and type is not itself and type is not 0 then set it to 0
        if (!grid[x][y].isActive() && (this.type != 0 || this.type != type)) {
            setNull(x,y,grid);
        }

        return true;
    }

    public boolean canMoveHere(int x, int y, Board board) {
        Square[][] grid = board.getGrid();
        int gridLength = grid.length;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < gridLength && j >= 0 && j < gridLength) {
                    if (grid[i][j].getType() == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }




    private boolean isValidMove(int x, int y, int gridLength) {
        return x >= 0 && x < gridLength && y >= 0 && y < gridLength;
    }





}
