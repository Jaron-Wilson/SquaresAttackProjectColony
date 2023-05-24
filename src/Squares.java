import java.awt.*;
import java.util.Random;

public class Squares {

    private int type = 0; // 1,2,3 // 0 means off
    private Color color;
    private double[] spreadChance = {0.0, 0.2, 0.3, 0.5};
    private int powerLevel = 1;
    private int lifeTime = 100;

    public Squares() {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
}