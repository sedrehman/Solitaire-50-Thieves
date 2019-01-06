package FiftyThieves.model;

import javax.swing.JLabel;

/**
 * Class that represents a standard card used in a typical 52-card deck.
 * 
 * @author Syed Rehman
 */
public class Card {
	private int rank;
	private String suit;
	private String pile;
	private JLabel img;
	private Integer layer;

	public Card(String suit, int rank, JLabel img) {
		super();
		this.rank = rank;
		this.suit = suit;
		this.img = img;
		this.pile = "w";
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getPile() {
		return pile;
	}

	public void setPile(String pile) {
		this.pile = pile;
	}

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + ", pile=" + pile + "]";
	}

}
