package Objects;

import Main.GamePanel;
import Entity.Projectile;

public class OBJ_Projectile extends Projectile{

	GamePanel gp;
	
	public OBJ_Projectile(GamePanel gp) {
		super(gp);
		this.gp=gp;
		
		//name="Projectile";
		speed=5;
		maxLife=80;
		life =maxLife;
		attack=2;
		useCost=1;
		alive=false;
		getImage();
		
		
	}

	public void getImage() {
		up=setup("/proj/proiettile_up",pSize,pSize);
		up2=setup("/proj/proiettile_up",pSize,pSize);
		down=setup("/proj/proiettile_down",pSize,pSize);
		down2=setup("/proj/proiettile_down",pSize,pSize);
		left=setup("/proj/proiettile_left",pSize,pSize);
		left2=setup("/proj/proiettile_left",pSize,pSize);
		right=setup("/proj/proiettile_right",pSize,pSize);
		right2=setup("/proj/proiettile_right",pSize,pSize);
	}

}
