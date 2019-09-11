package visual;

import visual.dialog.StartScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainScreen extends JFrame {

	private StartScreen startScreen;

	public MainScreen() {
		//main settings
		super("Main");
		pack();
		setLayout(new FlowLayout());
		setSize(530,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		startScreen = new StartScreen(this);
		
		//jPanel
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(530, 500));
		jPanel.setBackground(Color.BLACK);
		//addPanel
		GameField field = new GameField();
		jPanel.add(field);
		
	setContentPane(jPanel);
	pack();
	setVisible(true);	
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(MainScreen::new);
	}
	
	
}
