/**
 * This is a class
 * Created 2020-03-25
 *
 * @author Magnus Silverdal
 */
public class Main {
    public static void main(String[] args) {
        Graphics graphics = new Graphics(400,300,2);
        Score score = new Score(200,200,2);
        graphics.start();
        Score.start();
    }
}