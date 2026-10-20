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

	private Blackjack game;
	public static String IMG_PATH = System.getProperty("user.dir") + "/src/main/java/com/cardGame/resources/";

	public GUI(Blackjack game) {
		this.game = game;
		// Create and set up the window.
		setTitle("Blackjack");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this supplies the background
		try {
			Image blackImg = ImageIO.read(new File(IMG_PATH + "background.jpg"));

			setContentPane(new ImagePanel(blackImg));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Container cont = getContentPane();
		cont.setLayout(new GridBagLayout());

		JPanel cardArea = new JPanel(new GridBagLayout());
		cardArea.setBorder(BorderFactory.createLineBorder(Color.red));
		cardArea.setOpaque(false);
		cardArea.setPreferredSize(new Dimension(900,300));

		JPanel playArea = new JPanel(new GridBagLayout());
		playArea.setBorder(BorderFactory.createLineBorder(Color.pink));
		playArea.setOpaque(false);

		GridBagConstraints con = new GridBagConstraints();
		playArea.setPreferredSize(new Dimension(900,300));

		GridBagConstraints pcon = new GridBagConstraints();
		pcon.gridheight = 1;
		pcon.gridwidth = 3;
		JButton hbtn = new JButton();
		hbtn.setText("Hit");
		hbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pcon.gridx = 0;
		pcon.gridy = 1;
		playArea.add(hbtn);

		JButton sbtn = new JButton();
		sbtn.setText("Stand");
		sbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pcon.gridx = 3;
		pcon.gridy = 1;
		playArea.add(sbtn);

		con.gridx = 0;
		con.weightx = 1;
		con.weighty = 1;


		con.gridy = 0;
		cont.add(cardArea, con);

		con.gridy = 2;
		cont.add(playArea, con);


		
		hbtn.addActionListener(e -> {
			Card card = randomCard();
			cardArea.add(card);
			System.out.println(card);
			this.setVisible(true);
		});


		this.setVisible(true);
	}

	public Card randomCard() {
		int rsuit = (int)(Math.random()*4)+1;
		int rval = (int)(Math.random()*13)+1;
		Card rCard = new Card(rval, Card.Suit.values()[rsuit]);
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
