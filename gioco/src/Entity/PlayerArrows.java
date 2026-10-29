package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.InputArrows;
import Main.InputW;
import Main.UtilityTool;
import Objects.OBJ_Projectile;

public class PlayerArrows extends Entity {

	
	InputArrows keyArrows;
	public int punti=0;
	public PlayerArrows(GamePanel gp, InputArrows keyArrows) {
		super(gp);
		this.keyArrows = keyArrows;

		solidArea = new Rectangle();
		solidArea.x = 16;
		solidArea.y = 16;
		solidArea.width = 16;
		solidArea.height = 16;

		setDefaultValues();
		getPlayerImage();
	}
	

	public void setDefaultValues() {
		x = 600;
		y = 450;
		speed = 3;
		direction = "down";
		projectile=new OBJ_Projectile(gp);
		
	}

	public void getPlayerImage() {
		up = setup("player2_up");
		up2 = setup("player2_up2");
		down = setup("player2_down");
		down2 = setup("player2_down2");
		left = setup("player2_left");
		left2 = setup("player2_left2");
		right = setup("player2_right");
		right2 = setup("player2_right2");
		menu = setup("sans");
	}

	public BufferedImage setup(String imageName) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;

		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player2/" + imageName + ".png"));
			image = uTool.scaleImage(image, pSize, pSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public void update() {
		if (keyArrows.up == true) {
			direction = "up";
			last = 0;
		} else if (keyArrows.down == true) {
			direction = "down";
			last = 1;
		} else if (keyArrows.left == true) {
			direction = "left";
			last = 2;
		} else if (keyArrows.right == true) {
			direction = "right";
			last = 3;
		} else if (keyArrows.down == false && keyArrows.left == false && keyArrows.right == false
				&& keyArrows.up == false) {
			direction = "static";
		}
		// CHECK COLLISION
		collisionOn = false;
		gp.cChecker.checkTile(this);
		// COLLISION FALSE
		if (collisionOn == false) {
			switch (direction) {
			case "up":
				y -= speed;
				break;
			case "down":
				y += speed;
				break;
			case "left":
				x -= speed;
				break;
			case "right":
				x += speed;
				break;

			}
		}

		spriteCounter++;
		if (spriteCounter > 20) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		if (gp.keyArrows.shotKeyPressed==true && projectile.alive==false&&direction!="static") {
			projectile.set(x,y,direction,true,this);
			
			gp.projectileList.add(projectile);
		}
	}

	public void draw(Graphics2D g2) {
		/*
		 * g2.setColor(Color.white); g2.fillRect(x, y, gp.accPlayerSize,
		 * gp.accPlayerSize);
		 */
		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up;
			} else if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down;
			} else if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left;
			} else if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right;
			} else if (spriteNum == 2) {
				image = right2;
			}
			break;
		case "static":
			if (last == 0) {
				image = up;
			} else if (last == 1) {
				image = down;
			} else if (last == 2) {
				image = left;
			} else {
				image = right;
			}
		}
		g2.drawImage(image, x, y, null);
	}
}
