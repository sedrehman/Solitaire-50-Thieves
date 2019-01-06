package FiftyThieves.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import FiftyThieves.*;
import FiftyThieves.controller.FT_Listeners;
import FiftyThieves.controller.FT_StockListener;
import FiftyThieves.model.Card;
import FiftyThieves.model.FT_StockPile;
import FiftyThieves.model.Homecell;
import FiftyThieves.model.Pile;
import FiftyThieves.model.Tableau;
import FiftyThieves.model.WastePile;

/**
 * 
 * @author Syed Rehman Forty Thieves GUI;
 */

public class FortyThievesWindow extends JPanel {
	private FortyThieves game;
	private ArrayList<Card> topCards = new ArrayList<>();
	private Tableau[] tbl;
	private Homecell[] hcell;
	private FT_StockPile stock;
	private WastePile waste;
	private JLayeredPane layer;

	private static int win = 0;
	private static Integer layerCounter = 0;
	public static int EasterEggCounter;

	public FortyThievesWindow(FortyThieves game) {
		this.game = game;
		this.tbl = game.getTableau();
		this.hcell = game.getHomecell();
		this.stock = game.getStock();
		this.waste = game.getWaste();
		setTopCards();

		this.setLayout(null);
		setSize(new Dimension(1400, 800));
		setBackground(Color.GREEN);
		layer = new JLayeredPane();
		layer.setSize(this.getSize());
		layer.setBounds(0, 0, 1400, 800);

		// addTitles();

		// adding all piles to the layer
		addToLayer(stock);
		addToLayer(waste);
		for (int i = 0; i < hcell.length; i++) {
			addToLayer(hcell[i]);
		}
		for (int i = 0; i < tbl.length; i++) {
			addToLayer(tbl[i]);
		}

		setActionListeners();
		add(layer);
		this.repaint();
	}

	public void addToLayer(Pile pile) {
		for (int i = 0; i < pile.getPile().size(); i++) {
			Card c = pile.getPile().get(i);
			JLabel l = c.getImg();
			c.setLayer(layerCounter++);
			layer.add(l, c.getLayer());
		}
	}

	public void setTopCards() {
		if (!topCards.isEmpty()) {
			topCards = null;
			topCards = new ArrayList<Card>();
		}

		if (!stock.getPile().isEmpty()) {
			topCards.add(stock.getTopCard());
		}

		if (!waste.getPile().isEmpty()) {
			topCards.add(waste.getTopCard());
		}

		// homecell is never empty
		for (int i = 0; i < hcell.length; i++) {
			topCards.add(hcell[i].getTopCard());
		}

		for (int i = 0; i < tbl.length; i++) {
			if (!tbl[i].getPile().isEmpty()) {
				topCards.add(tbl[i].getTopCard());
			}
			if (tbl[i].getPile().isEmpty()) {
				int x = tbl[i].getBaseLocation().x;
				int y = tbl[i].getBaseLocation().y;
				Card c = getBaseCard(x, y, i);
				topCards.add(c);
			}

		}
	}

	/**
	 * 
	 * used for base card when a tableau pile is empty !
	 * 
	 * @param x
	 * @param y
	 * @param rank
	 * @return a card of solid color.
	 */
	private Card getBaseCard(int x, int y, int rank) {

		java.net.URL imgURL = this.getClass().getResource("../Cards/gold.gif");
		Icon imgIcon = new ImageIcon(imgURL);
		JLabel label = new JLabel(imgIcon);
		label.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());
		label.setLocation(x, y);
		Card card = new Card("none", 50 + rank, label);
		card.setPile("t");
		card.setLayer(layerCounter++);
		layer.add(label, card.getLayer());
		return card;

	}

	public void setActionListeners() {
		for (int i = 0; i < topCards.size(); i++) {
			Card c = topCards.get(i);
			if (c.getPile().equals("s")) {
				// the top card is from the stock pile
				if (c.getImg().getMouseListeners().length == 0) {
					c.getImg().addMouseListener(new FT_StockListener(this, c));
				}
			} else if (c.getPile().equals("t") || c.getPile().equals("w")) {
				// the top card is from the tableau pile
				if ((c.getImg().getMouseListeners().length == 0)
						|| (c.getImg().getMouseMotionListeners().length == 0)) {
					// FT_Listeners l = new FT_Listeners(c, this);
					c.getImg().addMouseMotionListener(new FT_Listeners(c, this));
					c.getImg().addMouseListener(new FT_Listeners(c, this));
				}
			}
		}
	}

	public void removeTopActionListeners() {
		for (int i = 0; i < topCards.size(); i++) {
			Card c = topCards.get(i);
			if (c.getImg().getMouseListeners().length != 0) {
				for (int j = 0; j < c.getImg().getMouseListeners().length; j++) {
					c.getImg().removeMouseListener(c.getImg().getMouseListeners()[i]);
				}
				if (c.getImg().getMouseMotionListeners().length != 0) {
					for (int k = 0; k < c.getImg().getMouseMotionListeners().length; k++) {
						c.getImg().removeMouseMotionListener(c.getImg().getMouseMotionListeners()[k]);
					}
				}
			}
		}
	}

	public void runEasterEgg() {
		EasterEgg egg = new EasterEgg();
	}

	public ArrayList<Card> getTopCards() {
		return topCards;
	}

	public FortyThieves getGame() {
		return game;
	}

	public JLayeredPane getLayers() {
		return layer;
	}

	public int getLayerCounter() {
		return layerCounter;
	}

	public void setLayerCounter(int n) {
		this.layerCounter = n;
	}

	public WastePile getWaste() {
		return waste;
	}

	public void setWaste(WastePile waste) {
		this.waste = waste;
	}

	public int getEasterEggCounter() {
		return this.EasterEggCounter;
	}

	public void setEasterEggCounter(int count) {
		this.EasterEggCounter = count;
	}

	/**
	 * Method that checks the combined size of homecell. Sum of homecell == 104,
	 * game is won.
	 * 
	 * @return boolean true or false
	 */
	public boolean isWinning() {
		win = 0;
		for (int i = 0; i < hcell.length; i++) {
			win += hcell[i].getPile().size();
		}
		if (win == 104 || win == 18 || win == 35 || win == 50 || win == 75) {
			return true;
		} else {
			return false;
		}
	}

}
