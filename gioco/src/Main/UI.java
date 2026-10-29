package Main;

import java.awt.image.ImageObserver;
import java.text.DecimalFormat;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;

public class UI {
	GamePanel gp;
	Graphics2D g2;

	private JTextField text_nomegiocatore;
	private JList<String> playerList;
	private JTextField nameField;
	private JTextField scoreField;
	JPanel inputPanel = new JPanel(new GridLayout(2, 2));
	private JPanel contentPane;
	public int commandNum = 0;

	public UI(GamePanel gp) {
		this.gp = gp;
		gp.add(inputPanel);

		// Set input panel visible
		contentPane = new JPanel();
		inputPanel.setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	private void setContentPane(JPanel contentPane2) {
		// TODO Auto-generated method stub
		
	}

	public void draw(final Graphics2D g2) {
		this.g2 = g2;
		if (gp.gameState == gp.titleState) {
			drawTitleScreen();
		}

	}

	public void drawTitleScreen() {
		int x;
		int y;

		g2.setColor(new Color(0, 0, 0)); // colore dello sfondo
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		// Title name
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 65F));
		String text = "Pilaf phantom shooter";
		x = getXforCenterText(text);
		y = gp.tileSize * 3;

		g2.setColor(Color.gray); // contorno della scritta
		g2.drawString(text, x, y);

		g2.setColor(Color.white); // colore della scritta
		g2.drawString(text, x, y);

		// immagini sotto la scritta
		x = gp.screenWidth / 2 - 300 - (gp.tileSize * 2) / 2;
		y = 180;
		g2.drawImage(gp.playerWASD.menu, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

		x = gp.screenWidth / 2 - 300 - (gp.tileSize * 2) / 2;
		y = 300;
		g2.drawImage(gp.playerArrows.menu, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

		// scritta NEW GAME
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
		text = "NEW GAME";
		x = getXforCenterText(text) - 75;
		y = gp.tileSize * 5;
		g2.drawString(text, x, y);
		if (commandNum == 0) { //
			g2.drawString(">", x - gp.tileSize, y);
		}

		// SCRITTA CLASSIFICA
		text = "QUIT"; //
		x = getXforCenterText(text) - 75;
		y = gp.tileSize * 9;
		g2.drawString(text, x, y);
		if (commandNum == 1) {
			g2.drawString(">", x - gp.tileSize, y);
		}

		// scritta QUIT
		text = "CLASSIFICA"; 
		x = getXforCenterText(text) - 75;
		y = gp.tileSize * 7;
		g2.drawString(text, x, y);
		if (commandNum == 2) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		// Add a text field for the player name
		JLabel nameLabel = new JLabel("Name:");
		nameField = new JTextField();
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);

		// Add a text field for the player score
		JLabel scoreLabel = new JLabel("Score:");
		scoreField = new JTextField();
		inputPanel.add(scoreLabel);
		inputPanel.add(scoreField);

		// Set the location of the inputPanel
		inputPanel.setBounds(gp.screenWidth - 250, gp.tileSize * 5, 200, 80);
		g2.setColor(Color.white);
		g2.drawRect(gp.screenWidth - 300, gp.tileSize * 5 - 10, 250, 100);
		
		
	
		

	}

	public int getXforCenterText(String text) {
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		return (gp.screenWidth - length) / 2;
	}

	/*
	 * public int getXforCenterText(String text) { int length = (int)
	 * g2.getFontMetrics().getStringBounds(text, g2).getWidth(); return
	 * (gp.screenWidth - length) / 2; }
	 */

}