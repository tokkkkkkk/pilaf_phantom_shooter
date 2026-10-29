package Main;

import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Entity.Entity;
import Entity.Projectile;

public class deathScreen{
	GamePanel gp;
	Graphics2D g2;
	public int commandNum2 = 0;
	public int k=0;
	/**
	 * @wbp.parser.entryPoint
	 */
	public deathScreen(GamePanel gp){
		this.gp=gp;
	}	
    /**
     * @wbp.parser.entryPoint
     */
    public void draw(final Graphics2D g2) {
		this.g2=g2;
		if(gp.gameState==gp.deathState){
			drawDeathScreen();
		}
		
    }
	public int drawDeathScreen(){
		int x;
		int y;
		
		g2.setColor(new Color(0, 0, 0)); // colore dello sfondo
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		//Title name
		g2.setFont(new Font("Dialog", Font.BOLD, 65));
		
		if(gp.playerWASD.alive==false) {
			String text = "PlayerArrows WIN!!!!!";
			x = getXforCenterText(text);
			y = gp.tileSize*3;
			
			g2.setColor(Color.gray); //contorno della scritta
			g2.drawString(text, x, y);
			
			g2.setColor(Color.white); //colore della scritta
			g2.drawString(text, x, y);
			
			//scritta QUIT
			 text="QUIT";                                //
			 x = getXforCenterText(text);
			 y = gp.tileSize*10;
			 g2.drawString(text, x, y);
			 if(commandNum2==0) {
				g2.drawString(">", x-gp.tileSize, y);
				
			 }
			 
			 return 1;
		}
		if(gp.playerArrows.alive==false) {
			String text = "PlayerWASD WIN!!!!!";
			x = getXforCenterText(text);
			y = gp.tileSize*3;
			
			g2.setColor(Color.gray); //contorno della scritta
			g2.drawString(text, x, y);
			
			g2.setColor(Color.white); //colore della scritta
			g2.drawString(text, x, y);
			
			//scritta QUIT
			 text="QUIT";                                //
			 x = getXforCenterText(text);
			 y = gp.tileSize*10;
			 g2.drawString(text, x, y);
			 if(commandNum2==0) {
				g2.drawString(">", x-gp.tileSize, y);
				
			 }
			 return 1;
		}
		
		
		
		/*
		//immagini sotto la scritta
		 x=gp.screenWidth/2-300 - (gp.tileSize*2)/2;
		 y = 180;
		 g2.drawImage(gp.playerWASD.menu,x, y, gp.tileSize*2, gp.tileSize*2, null);
		 
		 x=gp.screenWidth/2+300 - (gp.tileSize*2)/2;
		 y = 180;
		 g2.drawImage(gp.playerArrows.menu,x, y, gp.tileSize*2, gp.tileSize*2, null);
		 */
		 
		
		 return 0;
		
	}
	
	public int getXforCenterText(String text){
		int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x=gp.screenWidth/2 - length/2;
		return x;
	} 
}
