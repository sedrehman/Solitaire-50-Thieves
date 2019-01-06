package FiftyThieves.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import FiftyThieves.controller.FTMunuListener;

/**
 * 
 * @author syed rehman
 * 
 *         This is class creates the Menu Bar and returns it.
 */

public class FT_MenuBar {
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem ft;
	private JMenuItem exit;

	public FT_MenuBar(JFrame frame, JPanel panel) {

		menuBar = new JMenuBar();
		menu = new JMenu("New Games..");

		ft = new JMenuItem("New 40 Thieves");
		ft.addActionListener(new FTMunuListener(frame, panel));

		exit = new JMenuItem("Exit app");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		menu.add(ft);
		menu.add(exit);
		menuBar.add(menu);

	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

}
