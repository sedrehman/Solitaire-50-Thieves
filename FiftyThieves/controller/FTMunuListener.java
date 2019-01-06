package FiftyThieves.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FiftyThieves.model.*;
import FiftyThieves.view.*;

/**
 * 
 * @author Syed Rehman this class is just to run Forty Thieves Game
 *
 */
public class FTMunuListener implements ActionListener {
	private JPanel panel;
	private JFrame frame;

	public FTMunuListener(JFrame frame, JPanel panel) {
		this.frame = frame;
		this.panel = panel;
	}

	/**
	 * Clears out the frame then adds Forty Thieves Games in the frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.repaint();
		Deck d = new Deck();
		FortyThieves game = new FortyThieves(d);
		FortyThievesWindow window = new FortyThievesWindow(game);
		if (panel != null) {
			frame.remove(panel);
			frame.repaint();
			panel = null;
		}
		frame.getContentPane().add(window);
		frame.setSize(window.getSize());
		frame.setLocationRelativeTo(null);
	}

}
