package FiftyThieves.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import FiftyThieves.model.*;
import FiftyThieves.view.*;

/**
 * Instances of this class are mouse listeners to be used with the forty thieves
 * game's GUI and stock pile.
 * 
 * @author Syed Rehman
 *
 */
public class FT_StockListener implements MouseListener {

	private FortyThievesWindow window;
	private Card card;

	public FT_StockListener(FortyThievesWindow fortyThievesWindow, Card c) {
		this.window = fortyThievesWindow;
		this.card = c;
	}

	/**
	 * Used to move top card from stock to waste.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		window.getLayers().setLayer(card.getImg(), window.getLayerCounter());
		window.setLayerCounter(window.getLayerCounter() + 1);
		card.getImg().setLocation(window.getGame().getWaste().getBaseLocation());
		window.getGame().addToWaste(card);
		card.getImg().removeMouseListener(this);
		window.setTopCards();
		window.setActionListeners();
		window.setEasterEggCounter(0);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
