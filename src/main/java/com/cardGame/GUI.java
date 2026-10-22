package com.cardGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.color.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

@SuppressWarnings("unused")
public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private Blackjack game;
	private JPanel cardArea;
	public static String IMG_PATH = System.getProperty("user.dir") + "/src/main/java/com/cardGame/resources/";

	public GUI(Blackjack game) {
		this.game = game;
		// Create and set up the window.
		setTitle("Blackjack");
		setSize(1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this supplies the background
		try {
			Image blackImg = ImageIO.read(new File(IMG_PATH + "background.jpg"));

			setContentPane(new ImagePanel(blackImg));

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		Container cont = getContentPane();
		cont.setLayout(new GridBagLayout());
		
		// creates dealerarea
		JPanel dealerArea = new JPanel(new BorderLayout(15, 0));
		dealerArea.setBorder(BorderFactory.createLineBorder(Color.magenta));
		dealerArea.setOpaque(false);
		dealerArea.setPreferredSize(new Dimension(1400, 300));

		JPanel dealerCards = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
		dealerCards.setOpaque(false);
		dealerArea.add(dealerCards, BorderLayout.CENTER);

		JPanel deckArea = new JPanel(new BorderLayout());
		deckArea.setOpaque(false);
		deckArea.setBorder(BorderFactory.createTitledBorder("Deck"));
		deckArea.setPreferredSize(new Dimension(130, 190));
		Card deckCard = new Card(1, Card.Suit.Spades);
		deckCard.hide();
		deckArea.add(deckCard, BorderLayout.CENTER);
		dealerArea.add(deckArea, BorderLayout.EAST);
		
		//creates cardarea
		JPanel cardArea = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
		cardArea.setBorder(BorderFactory.createLineBorder(Color.red));
		cardArea.setOpaque(false);
		cardArea.setPreferredSize(new Dimension(1400, 200));

		//creates playarea
		JPanel playArea = new JPanel(new GridBagLayout());
		playArea.setBorder(BorderFactory.createLineBorder(Color.pink));
		playArea.setOpaque(false);
		playArea.setPreferredSize(new Dimension(1400, 140));

		//constraints for panels
		GridBagConstraints dealcon = new GridBagConstraints();
		dealcon.gridx = 0;
		dealcon.gridy = 0;
		dealcon.weightx = 1;
		dealcon.fill = GridBagConstraints.HORIZONTAL;
		dealcon.anchor = GridBagConstraints.SOUTH;
		dealcon.insets = new Insets(10, 0, 10, 0);

		GridBagConstraints playcon = new GridBagConstraints();
		playcon.gridx = 0;
		playcon.gridy = 1;
		playcon.weightx = 1;
		playcon.fill = GridBagConstraints.HORIZONTAL;
		playcon.anchor = GridBagConstraints.SOUTH;
		playcon.insets = new Insets(10, 0, 10, 0);

		GridBagConstraints btncon = new GridBagConstraints();
		btncon.gridx = 0;
		btncon.gridy = 2;
		btncon.weightx = 1;
		btncon.weighty = 0;
		btncon.fill = GridBagConstraints.NONE;
		btncon.anchor = GridBagConstraints.NORTH;

		//constraints for buttons
		GridBagConstraints hcon = new GridBagConstraints();
		hcon.gridx = 0;
		hcon.gridy = 0;
		hcon.insets = new Insets(10, 10, 10, 30);
		hcon.anchor = GridBagConstraints.CENTER;

		GridBagConstraints scon = new GridBagConstraints();
		scon.gridx = 1;
		scon.gridy = 0;
		scon.insets = new Insets(10, 30, 10, 10);
		scon.anchor = GridBagConstraints.CENTER;

		//creates buttons
		JButton hbtn = new JButton();
		hbtn.setText("Hit");
		hbtn.setFont(new Font("Arial", Font.BOLD, 16));
		hbtn.setPreferredSize(new Dimension(100, 50));
		playArea.add(hbtn, hcon);

		JButton sbtn = new JButton();
		sbtn.setText("Stand");
		sbtn.setFont(new Font("Arial", Font.BOLD, 16));
		sbtn.setPreferredSize(new Dimension(100, 50));
		playArea.add(sbtn, scon);

		cont.add(dealerArea, dealcon);
		cont.add(cardArea, playcon);
		cont.add(playArea, btncon);



		//button logic
		hbtn.addActionListener(e -> {
			Card card = randomCard();
			cardArea.add(card);
			cardArea.revalidate();
			cardArea.repaint();
			System.out.println(card);
		});

		this.setVisible(true);
	}

	public Card randomCard() {
		int rsuit = (int) (Math.random() * 4) + 1;
		int rval = (int) (Math.random() * 13) + 1;
		Card rCard = new Card(rval, Card.Suit.values()[rsuit-1]);
		return rCard;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
