package FiftyThieves.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Syed Rehman
 *
 */
public class EasterEgg2 extends JPanel {
	public EasterEgg2() {
		JFrame frame = new JFrame("!!!!CONGRATULATIONS!!!!");
		java.net.URL imgURL = this.getClass().getResource("easterEgg.gif");
		Icon imgIcon = new ImageIcon(imgURL);
		JLabel label = new JLabel(imgIcon);
		label.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());
		JLabel label2 = new JLabel("  YOU WON  ");
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
