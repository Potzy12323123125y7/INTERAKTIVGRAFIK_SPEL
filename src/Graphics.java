import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Graphics extends Canvas implements Runnable {
    int x, y;
    int x1 = 400;
    int y1 = 400;
    double angle = 0;
    

    public Graphics(int WIDTH, int HEIGHT, int scale) {
        this.width = WIDTH;
        this.height = HEIGHT;
        this.scale = scale;
    }

    public void start() {
    }

    @Override
    public void run() {

    }
}
