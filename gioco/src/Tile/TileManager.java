package Tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.UtilityTool;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];

	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[20];
		mapTileNum = new int[gp.screenCol][gp.screenRow];
		getTileImage();
		loadMap("/map/mapp.txt");
	}

	public void getTileImage() {

			setup(0,"0",false);
			setup(1,"1",false);
			setup(2,"2",true);
			setup(3,"3",true);
			setup(4,"4",true);
			setup(5,"5",true);
			setup(6,"6",true);
			setup(7,"7",true);
			setup(8,"8",true);
			setup(9,"9",true);
			setup(10,"10",true);
			setup(11,"11",true);
			setup(12,"12",true);
			setup(13,"13",true);
			setup(14,"14",true);
			setup(15,"15",true);
			setup(16,"16",true);
			
	}
	
	public void setup(int index,String imagepath, boolean collision) {
		UtilityTool uTool=new UtilityTool();
		try {
			tile[index]=new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imagepath+".png"));
			tile[index].image=uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision=collision;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void loadMap(String filepath) {
        try {
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader (new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col <gp.screenCol && row < gp.screenRow) {
                String line = br.readLine();

                while (col < gp.screenCol) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col ++;
                }
                if (col == gp.screenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
        	System.out.println("ggggggggggggggggggggggggggggggggGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        }
    }

	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		while (col < gp.screenCol && row < gp.screenRow) {
			int tileNum=mapTileNum[col][row];
			
		
			g2.drawImage(tile[tileNum].image,x,y,null);
			col++;
			x += gp.tileSize;
			if (col == gp.screenCol) {
				col = 0;
				x = 0;
				row++;
				y +=gp.tileSize;
			}
		}
	}
}
