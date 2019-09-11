package visual.dialog;

import sound.Sound;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.WEST;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;

import javax.swing.*;


public class StartScreen extends JDialog {

	private static final ImageIcon START = new ImageIcon(StartScreen.class.getClassLoader().getResource("img/start.png"));
	private static final ImageIcon START_ROLLOVER = new ImageIcon(StartScreen.class.getClassLoader().getResource("img/startClick.png"));
	private static final ImageIcon BACKGROUND = new ImageIcon(StartScreen.class.getClassLoader().getResource("img/fon.jpg"));

	private Sound sound = new Sound();
	private JButton button;
	private SpringLayout layout;
	private Container container;
	
	public StartScreen(Frame frame) {
		super(frame,"Start", true);
		pack();
		setSize(500, 500);
		setLocationRelativeTo(null);
		//container
		container = getContentPane();
		container.setBackground(Color.BLACK);
		//button
		button = new JButton(START);
		button.setRolloverIcon(START_ROLLOVER);
		button.setActionCommand("Start");
		button.setPreferredSize(new Dimension(125, 53));
		button.setBorderPainted(false);
		button.setFocusPainted(false);

		ActionListener listener = n-> {
			if (n.getActionCommand().equals("Start")) {
				sound.click();
				dispose();
			}
		};
		button.addActionListener(listener);

		//layout
		layout = new SpringLayout();
		container.setLayout(layout);
		layout.putConstraint(WEST, button, 185, WEST, container);
		layout.putConstraint(NORTH, button, 300, NORTH, container);
		
	add(new JLabel(BACKGROUND));
	add(button);
	setVisible(true);	
	}

	
	
	
	

}
