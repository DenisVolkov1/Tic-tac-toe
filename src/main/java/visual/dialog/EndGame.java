package visual.dialog;

import visual.GameField;

import javax.swing.*;
import java.awt.*;


public class EndGame extends JDialog {
    private static final ImageIcon WON_CROSS_IMG = new ImageIcon(GameField.class.getClassLoader().getResource("img/woncross.png"));
    private static final ImageIcon WON_ZERO_IMG = new ImageIcon(GameField.class.getClassLoader().getResource("img/wonzero.png"));
    private static final ImageIcon DRAW_IMG = new ImageIcon(GameField.class.getClassLoader().getResource("img/draw.png"));

    public static final int WIN_CROSS = 1;
    public static final int DRAW = 0;
    public static final int WIN_ZERO = -1;
    private Container container;
    private JLabel jLabel;

    public EndGame(int x) {

        setSize(new Dimension(175,150));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
            container = getContentPane();
            container.setBackground(Color.BLACK);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jLabel = new JLabel();
        jLabel.setBorder(BorderFactory.createEmptyBorder());

        if (x == 1) {
            jLabel.setIcon(WON_CROSS_IMG);
        } else if (x == -1) {
            jLabel.setIcon(WON_ZERO_IMG);
        } else if (x == 0) {
            jLabel.setIcon(DRAW_IMG);
        }
    add(jLabel,BorderLayout.CENTER);
    setVisible(true);
    }


}
