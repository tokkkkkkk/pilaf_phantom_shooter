package Entity;

import Main.GamePanel;
import java.awt.geom.Rectangle2D;

public class Projectile extends Entity {

	Entity user;
	int a = 0, b = 0;
	public int punti=0;
	
	public Projectile(GamePanel gp) {
		super(gp);

	}

	public void set(int x, int y, String direction, boolean alive, Entity user) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.life = this.maxLife;

	}

	public void update() {
		Entity player[] = new Entity[1];
		Entity entity=new Entity(gp);
		
		
		if (user == gp.playerArrows) {
			collisionOn = false;
			gp.cChecker.checkTile(this);

			player[0] = gp.playerWASD;
			int playerWASDIndex = gp.cChecker.checkEntity(this, player);
			
			if (playerWASDIndex != 999) {
				System.out.println("PlayerWASD colpito");
				gp.playerWASD.alive=false;
				gp.playerArrows.punti++;
			}
		}
		
		if (user == gp.playerWASD) {
			collisionOn = false;
			gp.cChecker.checkTile(this);
			player[0] = gp.playerArrows;
			int playerArrowsIndex = gp.cChecker.checkEntity(this, player);
			if (playerArrowsIndex != 999) {
				System.out.println("PlayerArrows colpito");
				gp.playerArrows.alive=false;
				gp.playerWASD.punti++;
			}
			

		}

		if (collisionOn==false) {	
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
		life--;
		if (life <= 0) {
			alive = false;
		}
		spriteCounter++;
		if (spriteCounter > 12) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	
}
