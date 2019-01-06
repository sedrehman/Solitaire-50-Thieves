package FiftyThieves.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author syed rehman Class representing the waste pile for the card game
 *         "Lucas" a variant of "Forty Thieves." This pile can only be added to
 *         from the stock pile.
 *
 */
public class WastePile extends Pile {

	// constructor
	public WastePile(Point location) {
		super(location);
	}

	/**
	 * Method that adds a card to the waste pile iff the card originates from the
	 * stock pile.
	 * 
	 * @param c
	 * @return boolean
	 */
	public boolean add(Card c) {
		if (c.getPile().equals("s")) {
			this.getPile().add(c);
			this.getTopCard().setPile("w");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that removes the top card from the waste pile. To be used in
	 * conjunction with another pile's legal check.
	 * 
	 * @return
	 */
	public Card remove() {
		Card retVal = this.getPile().remove(this.getPile().size() - 1);
		// updateTopCardLocation();
		return retVal;
	}

}
