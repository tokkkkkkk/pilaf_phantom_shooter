package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class SaveLoad {
	GamePanel gp;
	private Player p[];
	
	public SaveLoad(GamePanel gp) {
		this.gp=gp;
		p=new Player[100];
	}
	
	public int size() {
        int c = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.p[i] != null) {
                c++;
            }
        }
        return c;
    }
	
	public void save() {
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
			
						
			} catch (Exception e) {
			
		}
	}
}
