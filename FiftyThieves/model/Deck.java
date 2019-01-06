package FiftyThieves.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class that represents 2- 52-card decks.
 * 
 * @author Syed Rehman
 *
 */
public class Deck {
	private ArrayList<Card> cards;// a list of 104 cards
	private static final String[] suits = { "diamonds", "clubs", "hearts", "spades" };// helper when initializing deck

	/**
	 * creates two brand new deck of 104 cards in total
	 */
	public Deck() {// create a NEW deck of 104 cards.
		cards = new ArrayList<>();
		String[] fileNames = new String[52];
		int count = 0;

		for (int k = 0; k < 2; k++) {

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < 14; j++) {
					fileNames[count++] = "Cards/" + Integer.toString(j) + suits[i].charAt(0) + ".gif";
				}
			}
			count = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < 14; j++) {
					cards.add(new Card(suits[i], j, createDisplayImage(fileNames[count++])));// suits[0] is diamonds,
																								// suits[1] is clubs
																								// etc..
				}
			}
			count = 0;

		}
		shuffle();

	}

	/**
	 * Takes the file name in String form and loads the image. Then creates a JLabel
	 * and returns it
	 * 
	 * @param fileNameRelativeToClassFile
	 * @return JLabel
	 */
	public JLabel createDisplayImage(String fileNameRelativeToClassFile) {
		JLabel retVal = new JLabel();
		java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
		if (imgURL == null) {
			
			throw new IllegalArgumentException("Couldn't find file " + fileNameRelativeToClassFile);
		}

		ImageIcon cardImage = new ImageIcon(imgURL);
		retVal.setIcon(cardImage);
		Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
		retVal.setSize(d);
		retVal.setPreferredSize(d);
		retVal.setMaximumSize(d);
		retVal.setMinimumSize(d);
		return retVal;
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle() {// shuffle the deck
		Collections.shuffle(cards);

	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * removes and returns the specific card requested.
	 * 
	 * @param rank
	 * @param suit
	 * @return the specific Card
	 */
	public Card getSpecificCard(int rank, String suit) {
		for (int i = 0; i < cards.size(); i++) {
			if ((cards.get(i).getRank() == rank) && (cards.get(i).getSuit().equals(suit))) {
				return cards.remove(i);
			}
		}
		System.out.println(rank + " of " + suit + " can't be found");
		return null;
	}

	/**
	 * removes a random card from the top
	 * 
	 * @return Card
	 */
	public Card delt() {
		return cards.remove(0);
	}
}
