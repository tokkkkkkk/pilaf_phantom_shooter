package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputW implements KeyListener {
	
	public boolean up,down,left,right,shotKeyPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			up=true;
		}
		if (key == KeyEvent.VK_S) {
			down=true;
		}
		if (key == KeyEvent.VK_A) {
			left=true;
		}
		if (key == KeyEvent.VK_D) {
			right=true;
		}
		if (key == KeyEvent.VK_F) {
			shotKeyPressed=true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			up=false;
		}
		if (key == KeyEvent.VK_S) {
			down=false;
		}
		if (key == KeyEvent.VK_A) {
			left=false;
		}
		if (key == KeyEvent.VK_D) {
			right=false;
		}
		if (key == KeyEvent.VK_F) {
			shotKeyPressed=false;
		}

	}

}
