package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.AlphaComposite;
import Main.GamePanel;
import Main.UtilityTool;
import Objects.OBJ_Projectile;

import java.awt.Rectangle;

public class Entity {
	GamePanel gp;
	public int x, y;
	public int speed;
	public BufferedImage up, up2, down, down2, left, left2, right, right2,menu,trasp;
	public String direction = "down";
	public int last = 0;
	// obj
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	//punteggio

	
	// player size
	public final int pSize = 50;
	public Rectangle solidArea = new Rectangle(0, 0, 16, 16);
	public boolean collisionOn = false;

	public int spriteCounter = 0;
	public int spriteNum = 1;

	// proj
	public int maxLife;
	public int life;
	public int attack;
	public int useCost;
	public boolean alive=true;
	public Projectile projectile;
	public int solidAreaDefaultX=0;
	public int solidAreaDefaultY=0;
	public boolean dying=false;
	public  int dyingCounter;

	public Entity(GamePanel gp) {
		this.gp = gp;
	}

	public void draw(Graphics2D g2) {
		BufferedImage image=null;
		//int screenX=x-gp.playerWASD.x;
		
		
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
			break;
		

	}
		/*
		if (gp.playerArrows.dying==true) {
			dyingAnimation(g2);
			System.out.println(dying);
		}
		if (gp.playerWASD.dying==true) {
			dyingAnimation(g2);
			System.out.println(dying);
		}*/
		g2.drawImage(image, x, y, pSize, pSize, null);
	}
	public void dyingAnimation(Graphics2D g2) {
		dyingCounter++;
		
		int i=5;
		if(dyingCounter<=5) {changeAlpha(g2,0f);}
		if(dyingCounter>i && dyingCounter<=i*2) {changeAlpha(g2,1f);}
		if(dyingCounter>i*2 && dyingCounter<=i*3) {changeAlpha(g2,0f);}
		if(dyingCounter>i*3 && dyingCounter<=i*4) {changeAlpha(g2,1f);}
		if(dyingCounter>i*4 && dyingCounter<=i*5) {changeAlpha(g2,0f);}
		if(dyingCounter>i*5 && dyingCounter<=i*6) {changeAlpha(g2,1f);}
		if(dyingCounter>i*6 && dyingCounter<=i*7) {changeAlpha(g2,0f);}
		if(dyingCounter>i*7 && dyingCounter<=i*8) {changeAlpha(g2,1f);}
		if(dyingCounter>i*8) {
				dying=true;
				alive=false;
		}
	}
	public void changeAlpha(Graphics2D g2,float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alphaValue));
	}
	public void update() {
		setAction();
	}

	public void setAction() {

	}

	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
