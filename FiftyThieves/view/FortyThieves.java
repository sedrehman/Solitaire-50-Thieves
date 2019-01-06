package FiftyThieves.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;

import FiftyThieves.model.Card;
import FiftyThieves.model.Deck;
import FiftyThieves.model.FT_StockPile;
import FiftyThieves.model.Homecell;
import FiftyThieves.model.Tableau;
import FiftyThieves.model.WastePile;

/**
 * 
 * @author Syed Rehman
 *
 */
public class FortyThieves {

	/**
	 * This class contains the game logic for forty thieves: lucas variant.
	 */
	private Deck deck;

	private Homecell[] homecell;

	private Tableau[] tableau;

	private WastePile waste;

	private FT_StockPile stock;

	public FortyThieves(Deck d) {
		deck = d;

		homecell = new Homecell[8];
		homecell[0] = new Homecell(d, new Point(256, 30), 1, "hearts");
		homecell[1] = new Homecell(d, new Point(359, 30), 1, "hearts");
		homecell[2] = new Homecell(d, new Point(462, 30), 1, "spades");
		homecell[3] = new Homecell(d, new Point(565, 30), 1, "spades");
		homecell[4] = new Homecell(d, new Point(668, 30), 1, "diamonds");
		homecell[5] = new Homecell(d, new Point(771, 30), 1, "diamonds");
		homecell[6] = new Homecell(d, new Point(874, 30), 1, "clubs");
		homecell[7] = new Homecell(d, new Point(977, 30), 1, "clubs");

		tableau = new Tableau[13];
		tableau[0] = new Tableau(d, new Point(50, 180));
		tableau[1] = new Tableau(d, new Point(153, 180));
		tableau[2] = new Tableau(d, new Point(256, 180));
		tableau[3] = new Tableau(d, new Point(359, 180));
		tableau[4] = new Tableau(d, new Point(462, 180));
		tableau[5] = new Tableau(d, new Point(565, 180));
		tableau[6] = new Tableau(d, new Point(668, 180));
		tableau[7] = new Tableau(d, new Point(771, 180));
		tableau[8] = new Tableau(d, new Point(874, 180));
		tableau[9] = new Tableau(d, new Point(977, 180));
		tableau[10] = new Tableau(d, new Point(1080, 180));
		tableau[11] = new Tableau(d, new Point(1183, 180));
		tableau[12] = new Tableau(d, new Point(1286, 180));

		waste = new WastePile(new Point(153, 30));
		stock = new FT_StockPile(d, new Point(50, 30));

	}

	public Deck getDeck() {
		return deck;
	}

	public Homecell[] getHomecell() {
		return homecell;
	}

	public Tableau[] getTableau() {
		return tableau;
	}

	public WastePile getWaste() {
		return waste;
	}

	public FT_StockPile getStock() {
		return stock;
	}

	/**
	 * addfrom is the card that was being dragged and is being removed addto is the
	 * top card of the pile that addfrom is going to be added to
	 * 
	 * @param cardDraged
	 * @param topCard
	 * @return true if added. false if not
	 */
	public boolean adding(Card cardDragged, Card topCard) {
		// cardDraged-- being dragged
		// topCard -- topCard that addfrom is in range with;
		boolean check = false;
		int skip = 0;
		String cdPile = null;
		// ----------------for adding--------------------------------------------------
		if (topCard.getRank() > 49) {
			int index = topCard.getRank() - 50;

			System.out.println(tableau[index].getPile().size());
			for (Card c : tableau[index].getPile()) {
			}
			cdPile = cardDragged.getPile();
			check = tableau[index].add(cardDragged);
			for (Card c : tableau[index].getPile()) {
			}
			skip = index;
		}
		if (!check && topCard.getPile().equals("t")) { // therefore its a tableau card..
			for (int i = 0; i < tableau.length; i++) {
				if (tableau[i].getTopCard() == topCard) {
					cdPile = cardDragged.getPile();
					check = tableau[i].add(cardDragged);
					skip = i;

				}
			}
		} else if (!check && topCard.getPile().equals("h")) { // homecell
			for (int i = 0; i < homecell.length; i++) {
				if (homecell[i].getTopCard() == topCard) {
					cdPile = cardDragged.getPile();
					check = homecell[i].AddCheck(cardDragged);
					skip = 50; // something unreachable...
				}
			}
		}
		// you cant add cards to any other piles

		// ---------------------for removing ----------------------------------------

		if (check) {
			if (cdPile.equals("t")) {
				for (int i = 0; i < tableau.length; i++) {
					if (tableau[i].getTopCard() == cardDragged) {
						if (i != skip) {
							removeFromTableau(i);
						}
					}
				}
			} else if (cdPile.equals("w")) {
				removeFromWaste();
			}
		}
		return check;
	}

	/**
	 * cards must come from stock!
	 * 
	 * @param c
	 * @return true all the time.
	 */
	public boolean addToWaste(Card c) {
		boolean b = waste.add(c);
		stock.remove();
		return b;
	}

	/**
	 * i-th tableau pile is going to remove its top card;
	 * 
	 * @param i - numbered tableau
	 */
	private void removeFromTableau(int i) {
		tableau[i].remove();
	}

	/**
	 * removed the topCard from the waste pile
	 */
	private void removeFromWaste() {
		waste.remove();
	}

}