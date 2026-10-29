package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;

public class InputArrows implements KeyListener {

	public boolean up, down, left, right, shotKeyPressed;
	GamePanel gp;
	Graphics2D g2;

	public InputArrows(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (gp.gameState == gp.titleState) { // muovere i tastini della schermata iniziale

			if (key == KeyEvent.VK_DOWN) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if (key == KeyEvent.VK_UP) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if (key == KeyEvent.VK_ENTER) {
				if (gp.ui.commandNum == 0) {
					// gp.inTxt.draw(g2);
					gp.gameState = gp.playState;

				}
				if (gp.ui.commandNum == 1) {
					System.exit(0);
				}
				if (gp.ui.commandNum == 2) {
					gp.gameState = gp.rankState;
				}
			}
		} else if (gp.gameState == gp.deathState) {
			System.out.println("ddddd");
			if (key == KeyEvent.VK_ENTER) {
				gp.ded.commandNum2 = 0;
				if (gp.ded.commandNum2 == 0) {
					System.exit(0);
				}
			}
		} else {

			if (key == KeyEvent.VK_UP) {
				up = true;
			}
			if (key == KeyEvent.VK_DOWN) {
				down = true;
			}
			if (key == KeyEvent.VK_LEFT) {
				left = true;
			}
			if (key == KeyEvent.VK_RIGHT) {
				right = true;
			}
			if (key == KeyEvent.VK_M) {
				shotKeyPressed = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			up = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			down = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (key == KeyEvent.VK_M) {
			shotKeyPressed = false;
		}

	}

}
