
package Main;

import java.awt.*;
import java.lang.Comparable;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import Entity.Entity;
import Entity.PlayerArrows;
import Entity.PlayerWASD;
import Tile.TileManager;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable {

	// Screen
	public final int playerSize = 16;
	public final int mapSize = 16;
	public final int scale = 3;

	public final int tileSize = playerSize * scale;
	public final int screenCol = 16;
	public final int screenRow = 12;
	final int screenWidth = tileSize * screenCol;
	final int screenHeight = tileSize * screenRow;
	// FULL SCREEN
	int screenWidth2 = screenWidth;
	int screenHeigth2 = screenHeight;
	BufferedImage tempScreen;
	Graphics2D g2;
	// fps (60)
	int FPS = 60;
	// PROJECTILE
	public final int projectileWidth = 16;
	public final int projectileHeight = 16;
	public ArrayList<Entity> projectileList = new ArrayList<>();
	public ArrayList<Entity> entityList = new ArrayList<>();
	public Entity obj[] = new Entity[10];

	//InsertText inTxt=new InsertText(this);
	
	// INITS
	TileManager tileM = new TileManager(this);
	public InputW keyH = new InputW();
	public InputArrows keyArrows = new InputArrows(this);
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public PlayerWASD playerWASD = new PlayerWASD(this, keyH);
	public PlayerArrows playerArrows = new PlayerArrows(this, keyArrows);

	public UI ui = new UI(this);
	public ui4 ui4=new ui4(this);
	public deathScreen ded = new deathScreen(this);
	//public RankingList rank=new RankingList();
	// game state
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int rankState = 2;
	public final int deathState = 3;
	public int a = 0;
	public String playerName;
	//class
	Player p=new Player();
	Player p2=new Player();
	Rank rank = new Rank(this);
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(new java.awt.Color(46, 46, 46));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addKeyListener(keyArrows);
		this.setFocusable(true);

	}

	public void StartGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void setupGame() {
		gameState = titleState;
		// gameState=playState;
		// aSetter.setObject();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {
			update();
			repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				// se il ciclo ci ha messo piu di 0.1666 setto a 0 cosi non mette nulla in sleep
				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		if (gameState == playState) {
			if (playerWASD.alive == true && playerWASD.dying == false) {
				playerWASD.update();
			}
			if (playerArrows.alive == true && playerArrows.dying == false) {
				playerArrows.update();
			}
			if (playerWASD.alive == false) {			
				playerWASD.dying = true;
				try {
					Thread.sleep(600);
					gameState=deathState;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gameState=deathState;
			}
			if (playerArrows.alive == false) {
				playerArrows.dying = true;
				try {
					Thread.sleep(600);
					gameState=deathState;
					//rank
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			for (int i = 0; i < projectileList.size(); i++) {
				if (projectileList.get(i) != null) {
					if (projectileList.get(i).alive == true) {
						projectileList.get(i).update();
					}
					if (projectileList.get(i).alive == false) {
						projectileList.remove(i);
					}
				}
			}
		}
		if (gameState == rankState) {
			
		}

	}

	public void changeAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// title screen
		if (gameState == titleState) {
			//ui.draw(g2);
			ui4.setVisible(true);
		} else if (gameState == playState) {
			tileM.draw(g2);
			playerWASD.draw(g2);
			playerArrows.draw(g2);
			entityList.add(playerArrows);
			entityList.add(playerWASD);
			for (int i = 0; i < projectileList.size(); i++) {
				if (projectileList.get(i) != null) {
					entityList.add(projectileList.get(i));
				}
			}

			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {

					int result = Integer.compare(e1.y, e1.y);
					return result;
				}

			});

			for (int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			entityList.clear();

		}
		if(gameState==deathState) {
			ded.draw(g2);
		}
		if(gameState==rankState) {
			rank.setVisible(true);
		}

		g2.dispose();
	}

}