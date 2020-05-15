import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    private int width2;
    private int height2;
    private int scale2;
    private Score panel;
    private String title = "Scores";
    private JFrame frame2;

    public Score(int w2, int h2, int scale2) {
        this.width2 = w2;
        this.height2 = h2;
        this.scale2 = scale2;

        frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = new Dimension(scale2*width2, scale2*height2);
        frame2.setVisible(true);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        frame2.setTitle(title);
        frame2.pack();
    }

    public static void start() {

    }
}
