package FiftyThieves.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author syed rehman
 */
public class FT_StockPile extends Pile {

	// constructor
	public FT_StockPile(Deck remaining, Point location) {
		super(location);
		setPile(remaining.getCards());
		initialSetup(remaining.getCards(), location);
	}

	/*
	 * Method that sets the rest of the 2 decks not dealt to the other piles. Should
	 * contain 57 cards. Grabs the images from the cards and sets them on to the
	 * graphic pane. Adds layer to each card so that the top card will start at 0,
	 * and cards below will increase by counter.
	 */

	private void initialSetup(ArrayList<Card> cards, Point np) {
		// int counter = 0;
		for (Card c : cards) {
			// Point np = getBaseLocation();
			// np.setLocation(np);
			c.getImg().setLocation(np);
			// c.setLayer(counter++);
			c.setPile("s");
			// counter -= 1;
		}
	}

	/**
	 * Method that adds cards to stock. This was made only for the purpose of
	 * showing that a card cannot be added to the stock by normal means.
	 * 
	 * @param c Card
	 * @return boolean false. Always returns false.
	 */
	public boolean add(Card c) {
		if (!c.getPile().equals("s")) {
			return false;
		} else
			return false;
	}

	/**
	 * Method that removes the top card from the stock pile. Used in conjunction
	 * with waste legal move method.
	 * 
	 * @return top card from the stock pile.
	 */
	public Card remove() {
		Card retVal = this.getPile().remove(this.getPile().size() - 1);
		return retVal;
	}

//	
//	/**
//	 * Method that updates the the card locations. To be used after a card has been moved from the stock.
//	 */
//	@Override
//	public void updateTopCardLocation() {
//		int layer = getPile().size()-1;
//		for(Card c: this.getPile()) {
//			c.getImg().setLocation(getBaseLocation());
//			c.setLayer(layer--);
//		}
//	}
//	

}
