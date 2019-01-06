package FiftyThieves.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * 
 * @author Syed Rehman
 *
 */

public class EasterEgg extends JPanel {

	/**
	 * If a card is dragged to the wrong place 5 times then this easter egg appears
	 * ! Every is adding Hertz's face or something in the cards but I didn't want to
	 * do the same thing that everyone else did.
	 */
	public EasterEgg() {

		JFrame frame = new JFrame("Try a move that works.");
		java.net.URL imgURL = this.getClass().getResource("YouShallNotPass.gif");
		Icon imgIcon = new ImageIcon(imgURL);
		JLabel label = new JLabel(imgIcon);
		label.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());
		JLabel label2 = new JLabel("YOU SUCK");
		label2.setForeground(Color.red);
		label2.setFont(new Font("Serif", Font.BOLD, 16));
		this.add(label);
		this.add(label2);
		this.setSize((int) label.getSize().getWidth(), ((int) label.getSize().getHeight()) + 50);
		frame.setSize(getSize());
		frame.getContentPane().add(this);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
