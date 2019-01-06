package FiftyThieves.controller;

import java.awt.*;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import FiftyThieves.model.*;
import FiftyThieves.view.*;

/**
 * Mouse listeners to be use as components with the Forty Thieves game GUI.
 * These are specifically for the waste and tableau piles.
 * 
 * @author Syed Rehman
 *
 */

public class FT_Listeners implements MouseListener, MouseMotionListener {

	private Point originalLocation;
	private Card card;
	private FortyThievesWindow window;

	public FT_Listeners(Card card, FortyThievesWindow window) {
		this.card = card;
		this.window = window;
		this.originalLocation = card.getImg().getLocation();
	}

	/**
	 * Method that drags the card around with the cursor.
	 */
	public void mouseDragged(MouseEvent e) {
		// using this..
		JLabel lbl = card.getImg();
		lbl.setLocation(e.getLocationOnScreen().x - lbl.getParent().getLocationOnScreen().x - 30,
				e.getLocationOnScreen().y - lbl.getParent().getLocationOnScreen().y - 35);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * when top card is pressed the card is moved to the highest layer
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		window.getLayers().setLayer(card.getImg(), window.getLayerCounter());
		window.setLayerCounter(window.getLayerCounter() + 1);
	}

	/**
	 * Method that checks if a card is in range of the card that's being dragged and
	 * then checks if the move is legal before placing the card on top of the pile.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		Card cardInRange = null;
		String newPile = null;
		JLabel lbl1 = card.getImg();
		JLabel lbl2 = null;

		for (Card c : window.getTopCards()) { // for loop to check point location of each top card.
			if ((c != card && card.getImg().getBounds().intersects(c.getImg().getBounds()))) {
				// --------- card is in range ---------------
				cardInRange = c; // cardInRange is the topCard of the pile where we are adding card.
				newPile = c.getPile();
				lbl2 = c.getImg(); // topcard
			}
		}
		if ((cardInRange != null) && (window.getGame().adding(card, cardInRange))) {

			// ------------ card is in range ----------------------------

			Point p = lbl2.getLocation(); // create new point from topCard.
			if (newPile.equals("t")) {
				p.setLocation(p.getX(), p.getY() + 15); // for tableau move it down by 15;
			}
			lbl1.setLocation(p);
			if (lbl2.getMouseListeners().length != 0) {
				for (int i = 0; i < lbl2.getMouseListeners().length; i++) {
					lbl2.removeMouseListener(lbl2.getMouseListeners()[i]);
				}
				if (lbl2.getMouseMotionListeners().length != 0) {
					for (int i = 0; i < lbl2.getMouseMotionListeners().length; i++) {
						lbl2.removeMouseMotionListener(lbl2.getMouseMotionListeners()[i]);
					}
				}
			}
			if (lbl1.getMouseListeners().length != 0) {
				for (int i = 0; i < lbl1.getMouseListeners().length; i++) {
					lbl1.removeMouseListener(lbl1.getMouseListeners()[i]);
				}
				if (lbl1.getMouseMotionListeners().length != 0) {
					for (int i = 0; i < lbl1.getMouseMotionListeners().length; i++) {
						lbl1.removeMouseMotionListener(lbl1.getMouseMotionListeners()[i]);
					}
				}
			}
			window.setTopCards();
			window.setActionListeners();
			card.getImg().getParent().repaint();
			if (window.isWinning()) {
				EasterEgg2 eg2 = new EasterEgg2();
			}
			window.setEasterEggCounter(0);

		} else {

			// -------------------card is not in range-------------------------

			card.getImg().setLocation(originalLocation);
			card.getImg().getParent().repaint();
			window.setEasterEggCounter(window.getEasterEggCounter() + 1);
			if (window.getEasterEggCounter() == 5) {
				window.runEasterEgg();
				window.setEasterEggCounter(0);
			}

		}

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
