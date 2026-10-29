package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Projectile;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Main.Player;
import Main.ui4;
public class Rank extends JFrame {
	
	GamePanel gp;
	private JPanel contentPane;
	DefaultListModel mo=new DefaultListModel();
	
	/**
	 * Create the frame.
	 */
	public Rank(GamePanel gp) {
		this.gp=gp;
		
		
		Projectile p=new Projectile(gp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 720, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(mo);
		list.setBounds(10, 11, 445, 459);
		contentPane.add(list);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gp.gameState=gp.titleState;
				setVisible(false);
			}
		});
		btnBack.setBounds(505, 11, 146, 71);
		contentPane.add(btnBack);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String s=ui.nome[0]+" "+Integer.toString(ui.p.getPunteggio());
				//String s1=ui.nome[1]+" "+Integer.toString(ui.p.getPunteggio());
				String s=gp.ui4.textP1.getText();
				String s1 = gp.ui4.textP2.getText();
				mo.addElement(s+" "+gp.playerArrows.punti);	
				mo.addElement(s1+" "+gp.playerWASD.punti);	
			}
		});
		btnShow.setBounds(505, 115, 146, 64);
		contentPane.add(btnShow);
	}
}
