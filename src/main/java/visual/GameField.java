package visual;

import logic.Logic;
import sound.Sound;
import visual.dialog.EndGame;
import visual.dialog.StartScreen;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import static logic.Logic.*;

public class GameField extends JPanel {
	private Sound sound = new Sound();
	private static final ImageIcon EMPTY_BLOCK = new ImageIcon(GameField.class.getClassLoader().getResource("img/emptyBlock.jpg"));
	private static final ImageIcon ROLLOVER_RED = new ImageIcon(GameField.class.getClassLoader().getResource("img/redBlock.jpg"));
	private static final ImageIcon ROLLOVER_BLUE = new ImageIcon(GameField.class.getClassLoader().getResource("img/blueBlock.jpg"));
	private static final ImageIcon CROSS = new ImageIcon(GameField.class.getClassLoader().getResource("img/crossBlock.jpg"));
	private static final ImageIcon ZERO = new ImageIcon(GameField.class.getClassLoader().getResource("img/zeroBlock.jpg"));
	private static final ImageIcon RESTART = new ImageIcon(GameField.class.getClassLoader().getResource("img/restart.jpg"));
	private static final ImageIcon RESTART_ROLLOVAR = new ImageIcon(GameField.class.getClassLoader().getResource("img/restartClick.jpg"));
	private static final ImageIcon RESTART_PRESSED = new ImageIcon(GameField.class.getClassLoader().getResource("img/restartPressed.png"));
	JPanel grid = new JPanel();
	private JButton[] buttons = new JButton[9];
	private JButton restart;
	private EndGame crossWinner;

	public GameField() {
		grid.setLayout(new GridLayout(3,3,0,0));
		grid.setSize(350, 350);
			setBackground(new Color(10, 10, 10));
			setLayout(new FlowLayout());
			setSize(new Dimension(350, 470));

		ActionListener listener = n -> {
			int index = Integer.valueOf(n.getActionCommand());
			switch (n.getActionCommand()) {
				case "0" :
					clickButtonField(index);
					break;
				case "1" :
					clickButtonField(index);
					break;
				case "2" :
					clickButtonField(index);
					break;
				case "3" :
					clickButtonField(index);
					break;
				case "4" :
					clickButtonField(index);
					break;
				case "5" :
					clickButtonField(index);
					break;
				case "6" :
					clickButtonField(index);
					break;
				case "7" :
					clickButtonField(index);
					break;
				case "8" :
					clickButtonField(index);
					break;
			}
		};
		// init field
		for (Integer i = 0; i < 9;i++) {
			buttons[i] = new JButton(EMPTY_BLOCK);
			buttons[i].setActionCommand(i.toString());
			buttons[i].setPreferredSize(new Dimension(116, 116));
			buttons[i].setRolloverIcon(ROLLOVER_RED);
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusPainted(false);
			buttons[i].addActionListener(listener);
		}
		restart = new JButton(RESTART);
		restart.setActionCommand("restart");
		restart.setPreferredSize(new Dimension(136, 49));
		restart.setRolloverIcon(RESTART_ROLLOVAR);
		restart.setPressedIcon(RESTART_PRESSED);
		restart.setBorderPainted(false);
		restart.setFocusPainted(false);
		restart.addActionListener(n -> {
			if(n.getActionCommand().equals("restart")) {
				sound.click();
				resetFields();
				Logic.restart();
			}
		});
		for (JButton button : buttons) grid.add(button);
		add(grid);
		add(restart);
	}
	private  void clickButtonField(int index) {
		sound.startPlayClick();
		renderIcon(index);
		int result = tern(index);
		if (result == Logic.WIN) {
			sound.startPlayWin();
			crossWinner = (getTurn() == 'X') ? new EndGame(EndGame.WIN_CROSS) : new EndGame(EndGame.WIN_ZERO);
			Logic.restart();
			resetFields();
			return;
		}
		if (result == Logic.DRAW) {
			Logic.restart();
			sound.startPlayWin();
			crossWinner = new EndGame(EndGame.DRAW);
			resetFields();
		}
	}
	private void resetFields() {
		for (int i = 0; i < 9;i++) {
			buttons[i].setEnabled(true);
			buttons[i].setIcon(EMPTY_BLOCK);
			buttons[i].setRolloverIcon(ROLLOVER_RED);
		}
	}
	private void renderIcon(int index) {
		if (getTurn() == 'X') {
			buttons[index].setIcon(CROSS);
			buttons[index].setEnabled(false);
			buttons[index].setDisabledIcon(CROSS);
			setRollover(ROLLOVER_BLUE);
		} else {
			buttons[index].setIcon(ZERO);
			buttons[index].setEnabled(false);
			buttons[index].setDisabledIcon(ZERO);
			setRollover(ROLLOVER_RED);
		}
	}
	private void setRollover(ImageIcon rollover){
		for (int i = 0; i < 9;i++) {
			buttons[i].setRolloverIcon(rollover);
		}
	}

}
