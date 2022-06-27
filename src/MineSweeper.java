import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;

public class MineSweeper extends JFrame {

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;



    public static void main(String[] args) {
        new MineSweeper();

    }

    private MineSweeper() {
        setImages();
        initPanel();
        initFrame();

    }
    private void initPanel() {

        panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()) {
                    Coord coord = new Coord(box.ordinal() * IMAGE_SIZE, 0);
                    g.drawImage((Image) box.image,
                            coord.x, coord.y, this);
                }

            }
        };

        panel.setPreferredSize(new Dimension(
                COLS * IMAGE_SIZE , ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
    }

    private void setImages () {
        for ( Box box : Box.values())
            box.image = getImage(box.name());


    }

    private Image getImage (String name) {
        String filename = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
        
    }
}
