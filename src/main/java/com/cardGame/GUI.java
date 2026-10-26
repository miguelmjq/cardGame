//Miguel M Querales
//10/23
// sets up the gui for blackjack

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
import java.util.Stack;

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
		cont.setLayout(new BorderLayout(10, 10));

		JPanel dealerArea = new JPanel(new GridLayout(1, 2, 10, 0));
		dealerArea.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
		dealerArea.setOpaque(false);
		dealerArea.setPreferredSize(new Dimension(1400, 250));

		JPanel deckArea = new JPanel();
		deckArea.setBorder(BorderFactory.createLineBorder(Color.white));

		JPanel dealcardsarea = new JPanel(new BorderLayout());
		dealcardsarea.setBorder(BorderFactory.createLineBorder(Color.white));

		dealerArea.add(deckArea);
		dealerArea.add(dealcardsarea);

		// creates cardarea
		cardArea = new JPanel(new FlowLayout());
		cardArea.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		cardArea.setOpaque(false);

		// creates playarea
		JPanel playArea = new JPanel(new GridBagLayout());
		playArea.setBorder(BorderFactory.createLineBorder(Color.pink, 2));
		playArea.setOpaque(false);
		playArea.setPreferredSize(new Dimension(1400, 250));

		// constraints for buttons
		GridBagConstraints btncon = new GridBagConstraints();
		btncon.gridy = 0;
		btncon.insets = new Insets(10, 15, 10, 15);

		// creates buttons
		JButton hbtn = new JButton("Hit");
		hbtn.setPreferredSize(new Dimension(140, 60));
		hbtn.setFont(new Font("Arial", Font.BOLD, 20));
		btncon.gridx = 0;
		playArea.add(hbtn, btncon);

		JButton sbtn = new JButton("Stand");
		sbtn.setPreferredSize(new Dimension(140, 60));
		sbtn.setFont(new Font("Arial", Font.BOLD, 20));
		btncon.gridx = 1;
		playArea.add(sbtn, btncon);

		cont.add(dealerArea, BorderLayout.NORTH);
		cont.add(cardArea, BorderLayout.CENTER);
		cont.add(playArea, BorderLayout.SOUTH);

		// button logic
		hbtn.addActionListener(e -> {
		});

		this.setVisible(true);
	}

	public JLayeredPane drawPile(Stack<Card> stackIn) {

		Object cards[];

		cards = stackIn.toArray();

		JLayeredPane cardpile = new JLayeredPane();
		cardpile.setLayout(null);

		Card firstCard = (Card) cards[0];
		Dimension cardSize = firstCard.getPreferredSize();
		int offset = 20;

		cardpile.setPreferredSize(new Dimension(cardSize.width,cardSize.height + (cards.length - 1) * offset));

		for (int i = cards.length - 1; i >= 0; i--) {
			Card card = (Card) cards[i];
			Dimension size = card.getPreferredSize();

			card.setBounds(0, i * offset, size.width, size.height);
			cardpile.add(card, Integer.valueOf(cards.length - 1 - i));
		}

		return cardpile;

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
