import java.awt.*;
import java.util.Random;

public class Ball {
    private int p1Score, p2Score;
    private int xDirection, yDirection;
    private int[] pixels;
    private Rectangle boundingBox;
    private int height = 10;
    private int width = 10;

    public Ball(int x, int y){
        pixels = new int[width*height];
        /*for(int j = 0 ; j < height ; j++ ) {
            for (int i = 0 ; i < width ; i++) {
                if ((i-width/2)*(i-width/2) + (j-height/2)*(j-height/2) < width*width/4) {
                    pixels[i] = 0xFFFFFFFF;
                } else {
                    pixels[i] = 0x00000000;
                }
            }
        }*/

        for (int i = 0 ; i < pixels.length ; i++)
            pixels[i] = 0xFFFFFFFF;

        boundingBox = new Rectangle(x, y, width, height);

        Random r = new Random();
        int rDir = r.nextInt(1);
        if(rDir == 0) {
            rDir--;
        }
        setXDirection(rDir);
        int yrDir = r.nextInt(1);
        if(yrDir == 0) {
            yrDir--;
        }
        setYDirection(yrDir);
    }

    public void setXDirection(int xdir){
        xDirection = xdir;
    }

    public void setYDirection(int ydir){
        yDirection = ydir;
    }

    public int getXDirection() {
        return xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public void draw(int[] Screen, int screenWidth){
        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                Screen[(boundingBox.y+i)*screenWidth + boundingBox.x+j] = pixels[i*width+j];
            }
        }
    }

    public void collision(Rectangle r){
        if(boundingBox.intersects(r)) {
            if (getXDirection() > 0 && Math.abs(r.x - (boundingBox.x + boundingBox.width)) <= getXDirection()) {
                setXDirection(-1);
                p1Score++;
            } else if (getXDirection() < 0 && Math.abs(r.x + r.width - boundingBox.x) <= -getXDirection()) {
                setXDirection(+1);
                p2Score++;
            } else if (getYDirection() > 0 && Math.abs(r.y - (boundingBox.y + boundingBox.height)) <= getYDirection()) {
                setYDirection(-1);
            } else if (getYDirection() < 0 && Math.abs(r.y + r.height - boundingBox.y) <= -getYDirection()) {
                setYDirection(1);
            }
        }
    }

    public int move() {

        boundingBox.x += xDirection;
        boundingBox.y += yDirection;
        System.out.println();
        //Bounce the ball when edge is detected
        if (boundingBox.x <= 0) {
            setXDirection(+1);
            p2Score++;
        }
        if (boundingBox.x >= 390) {
            setXDirection(-1);
            p1Score++;
        }
        if (boundingBox.y <= 0) setYDirection(+1);
        if (boundingBox.y >= 290) setYDirection(-1);
        return 0;
    }
    public int getP1Score() {
        return p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void update(Rectangle r) {
        collision(r);
        move();
        collision(r);
    }
}