package FiftyThieves.view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author syed rehman
 *
 */
public class FrontPage {

	public JLabel label() {
		java.net.URL imgURL = this.getClass().getResource("start.jpg");
		Icon imgIcon = new ImageIcon(imgURL);
		JLabel label = new JLabel(imgIcon);
		label.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());
		return label;
	}
}
