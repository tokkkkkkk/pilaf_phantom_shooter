package Main;

import java.awt.EventQueue;
import Main.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;


public class ui4 extends JFrame {

	private JPanel contentPane;
	JTextField textP1;
	JTextField textP2;
	GamePanel gp;
	public Player p=new Player();
	public Player p2=new Player();
	private String nomep1;
	private String nomep2;
	public String nome[]=new String[2];
	deathScreen dead=new deathScreen(gp);
	private int score1;
	private int score2;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui4 frame = new ui4(gp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ui4(GamePanel gp) {
		this.gp=gp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 720, 576);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gp.gameState=gp.playState;
				setVisible(false);
				dispose();
			}
		});
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setBackground(Color.BLACK);
		btnNewGame.setFont(new Font("Power Clear", Font.PLAIN, 30));
		btnNewGame.setBounds(112, 273, 239, 48);
		contentPane.add(btnNewGame);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.BLACK);
		btnQuit.setForeground(Color.WHITE);
		btnQuit.setFont(new Font("Power Clear", Font.PLAIN, 30));
		btnQuit.setBounds(112, 429, 239, 48);
		contentPane.add(btnQuit);
		
		JButton btnClassifica = new JButton("Classifica");
		btnClassifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gp.gameState=gp.rankState;
				}
		});
		btnClassifica.setBackground(Color.BLACK);
		btnClassifica.setForeground(Color.WHITE);
		btnClassifica.setFont(new Font("Power Clear", Font.PLAIN, 30));
		btnClassifica.setBounds(112, 351, 239, 48);
		contentPane.add(btnClassifica);
		
		JLabel lblP1 = new JLabel("Player WASD");
		lblP1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblP1.setBackground(Color.BLACK);
		lblP1.setForeground(Color.WHITE);
		lblP1.setBounds(112, 131, 115, 48);
		contentPane.add(lblP1);
		
		JLabel lblP2 = new JLabel("Player Arrows");
		lblP2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblP2.setForeground(Color.WHITE);
		lblP2.setBackground(Color.BLACK);
		lblP2.setBounds(112, 179, 139, 48);
		contentPane.add(lblP2);
		
		textP1 = new JTextField();
		textP1.setBounds(225, 146, 93, 20);
		contentPane.add(textP1);
		textP1.setColumns(10);
		
		textP2 = new JTextField();
		textP2.setBounds(225, 194, 93, 20);
		contentPane.add(textP2);
		textP2.setColumns(10);
		
		JLabel lblTitolo = new JLabel("Pilaf phantom shooter");
		lblTitolo.setForeground(Color.WHITE);
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 50));
		lblTitolo.setBounds(90, 44, 587, 64);
		contentPane.add(lblTitolo);
		
		JButton btnAddButton = new JButton("add");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("sss");
				nome[0]=textP1.getText();				
				nome[1]=textP2.getText();
			}
		});
		btnAddButton.setBounds(358, 145, 70, 23);
		contentPane.add(btnAddButton);
		
		JList list = new JList();
		list.setBounds(381, 273, 282, 204);
		contentPane.add(list);
		
		JButton btnMostra = new JButton("Mostra");
		btnMostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel m = new DefaultListModel();
		        m.addElement(("posizione       nome giocatore             punteggio"));
		        m.addElement(("       "));
		        m.addElement(("1                               "+nomep1+"                         0 "));
		        m.addElement(("2                               "+nomep2+"                         0 "));
		       
		        list.setModel(m);
			}
		});
		btnMostra.setBounds(559, 235, 89, 23);
		contentPane.add(btnMostra);
		
	}
}
