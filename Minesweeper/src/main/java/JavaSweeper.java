import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.ImageIcon;
import java.net.URL;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {

    private Game game;

    private final int COLS = 15;
    private final int ROWS = 15;
    private final int BOMBS = 25;
    private final int IMAGE_SIZE = 50;
    private JPanel panel;
    private JLabel label;

    public static void main(String[] args) {

        new JavaSweeper();
    }

    private JavaSweeper() {

        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImage();
        initPanel();
        initLabel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel(getMessage());
        Font font = new Font("Comics", Font.BOLD, 18);
        label.setFont(font);
        add (label, BorderLayout.SOUTH);


    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setVisible(true);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for(Coord coord: Ranges.getAllCoords()) {

                        g.drawImage((Image)game.getBox(coord).image,
                           coord.x * IMAGE_SIZE,
                           coord.y * IMAGE_SIZE, this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1 -> game.pressLeftButton(coord);
                    case MouseEvent.BUTTON3 -> game.pressRightButton(coord);
                    case MouseEvent.BUTTON2 -> game.start();
                }
                label.setText(getMessage());
                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE,
                Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void setImage () {
        for (Box box: Box.values()){
            box.image = getImage(box.name().toLowerCase());
        }
        setIconImage(getImage("icon"));
    }

    private Image getImage(String name) {
        String fileName = name + ".png";
        ImageIcon icon = new ImageIcon();
            try {
                icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/" + fileName)));
            } catch (NullPointerException e) {
                e.getMessage();
            }
        return icon.getImage();
    }

    private String getMessage () {
        switch (game.getGameState()) {
            case BOMBED: return "Ba-Da-Boom! You Lose!";
            case WINNER: return "Congratulations! All bombs have been marked!";
            case PLAYED :
            default: if (game.getTotalFlagged() == 0)
                return "Welcome to the Game";
            else
                return "Think twice! Flagged " +
                        game.getTotalFlagged() + " of " +
                        game.getTotalBombs() + " bombs";

        }
    }
/**
 *
 String filePath = "путь_к_файлу";
 File file = new File(filePath);
 if (file.exists()) {
 ImageIcon icon = new ImageIcon(file.getAbsolutePath());
 } else {
 // Обработка ошибки, если файл не существует
 }
 */

}
