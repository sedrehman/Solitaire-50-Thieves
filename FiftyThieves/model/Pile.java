package FiftyThieves.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 * @author syed rehman
 * 
 *         this is generic pile class that all the other piles should extend It
 *         has an ArrayList of Cards and a Point baseLocation.
 * 
 */
public class Pile {
	private ArrayList<Card> pile;
	private Point baseLocation;

	public Pile(Point baseLocation) {
		pile = new ArrayList<>();
		this.baseLocation = baseLocation;
	}

	public ArrayList<Card> getPile() {
		return pile;
	}

	public void setPile(ArrayList<Card> pile) {
		this.pile = pile;
	}

	public Point getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(Point baseLocation) {
		this.baseLocation = baseLocation;
	}

	/**
	 * return the topCard of the pile
	 */
	public Card getTopCard() { // added index check

		if (pile.size() > 0) {
			return pile.get(pile.size() - 1);
		}
		return null;
	}

}
