package Main;

import java.awt.image.ImageObserver;
import java.io.Serializable;
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
import Main.ui4;

public class Player implements Serializable {
	private int punteggio;
	private String nome[];
	
	public Player() {
		this.nome=new String[100];
		this.punteggio=0;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public String[] getNome() {
		return nome;
	}

	public void setNome(String[] nome) {
		this.nome = nome;
	}
	
	
}
