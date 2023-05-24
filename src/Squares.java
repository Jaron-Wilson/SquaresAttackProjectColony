import java.awt.*;
import java.util.Random;

public class Squares {

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

        if (type == 0) {
            System.out.println("FIRST WHITE");
            color = Color.WHITE;
        } else if (type == 1) {
            System.out.println("BLACK");
            color = Color.BLACK;
        } else if (type == 2) {
            System.out.println("GREEN");
            color = Color.GREEN;
        }else if (type == 3) {
            System.out.println("RED");
            color = Color.RED;
        } else {
            System.out.println("White");
            color = Color.WHITE;
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

    public void setNull(int x, int y, Squares[][] grid) {
        if (grid != null) {
            grid[x][y].setActive(false);
            grid[x][y].setType(0);
        }
    }

    public boolean checkDeath(Board board, int x, int y, int type) {
        Squares[][] grid = board.getGrid();

//        if it is deactivate and type is not itself and type is not 0 then set it to 0
        if (!grid[x][y].isActive() && (this.type != 0 || this.type != type)) {
            setNull(x,y,grid);
        }

        return true;
    }
}