package FiftyThieves;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import FiftyThieves.view.FT_MenuBar;
import FiftyThieves.view.FrontPage;

/**
 * Main method to run the suite of card games.
 * 
 * @author Syed Rehman
 *
 */

public class MainClass {

	/**
	 * Just creates the main frame where the games shall be a played on
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// main class for Fourty Thieves
		JFrame frame = new JFrame("~~~...Solitarie...~~~");
		JPanel panel = new JPanel();

		FrontPage f = new FrontPage();
		panel.add(f.label());
		frame.add(panel);
		panel.setSize(300, 320);
		FT_MenuBar menuBar = new FT_MenuBar(frame, panel);
		frame.setJMenuBar(menuBar.getMenuBar());
		frame.setSize(panel.getSize());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocationRelativeTo(null); // *** this will center your app ***

		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
