package pis.hue1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class CodecGUII {

	private Codec c1 ;
	private Codec c2 ;
	private JFrame frame;
	private JTextField textField1;
	private JRadioButton JRadioButton1 ;
	private JRadioButton JRadioButton2 ;
	private JButton btnNewButton ;
	private ButtonGroup buttongroup ;   //cette variable est pour grouper les deux bouttons et ne permettre qu'un seul boutton ne soit
	                                    //choisi

	
	/**
	 * Launch the application.
	 */
	

	public CodecGUII(Codec c1, Codec c2) {
		this.c1 = c1 ;
		this.c2 = c2 ;
		
	
	
	/**
	 * Create the application.
	 */
	//public CodecGUII() {
		//initialize();
	//}

	//}
	/**
	 * Initialize the contents of the frame.
	 */
	//private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(250, 250, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setLineWrap(true);
		textArea2.setBounds(230, 138, 296, 106);
		frame.getContentPane().add(textArea2);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setLineWrap(true);
		textArea1.setBounds(230, 11, 296, 106);
		frame.getContentPane().add(textArea1);
		
		textField1 = new JTextField();
		textField1.setBounds(158, 255, 250, 50);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		
		
		
		btnNewButton = new JButton("Verschluesselung");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String tony;
				//String tony123 ;
				if(textField1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Wir brauchen bitte eine Schluessel!");
				}
				if(JRadioButton1.isSelected()) {
					//tony = "DoppelwuerfelVerfahren selected ? " ;//avant d'executer l'operation je me rassure d'abord qu'un verschluesselung est selectione 
				    c1.setzeLosung(textField1.getText());
				    textArea2.setText(c1.kodiere(textArea1.getText()));
				
				
				
				
				} else if(JRadioButton2.isSelected() ){ 
					c2.setzeLosung(textField1.getText());
					textArea2.setText(c2.kodiere(textArea1.getText()));
					
					
				} else {
					
				}
				
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(55, 326, 180, 39);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton1 = new JRadioButton("Doppelwuerfelverfahren");
		                                                    //celui ci peux etre optionnel car il decide si le premier boutton
		                                                           //est deja coche ou non
		
		JRadioButton1.setFont(new Font("Tahoma", Font.BOLD, 16));
		JRadioButton1.setBounds(10, 386, 250, 53);
		frame.getContentPane().add(JRadioButton1);
		
		JRadioButton2 = new JRadioButton("CaesarVerfahren");
		//JRadioButton2.setMnemonic(KeyEvent.VK_C);
		//JRadioButton2.setActionCommand("CaesarVerfahren");
		JRadioButton2.setFont(new Font("Tahoma", Font.BOLD, 16));
		JRadioButton2.setBounds(276, 386, 250, 53);
		frame.getContentPane().add(JRadioButton2);
		
		
		
		ButtonGroup buttongroup  = new ButtonGroup();      //tout simplement pour ne choisir qu'unseul Verfahren, alors on a regroupper 
		buttongroup.add(JRadioButton1);                    //les JRadioButton dans le group 
		buttongroup.add(JRadioButton2);
		
		JButton btnNewButton_1 = new JButton("Entschluesselung");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Wir brauchen bitte eine Schluessel!");
					
				}
				
				if(JRadioButton2.isSelected()) {
					c2.setzeLosung(textField1.getText());
					textArea1.setText(c2.dekodiere(textArea2.getText())) ;
				} else if(JRadioButton1.isSelected()){
					c1.setzeLosung(textField1.getText());
					textArea1.setText(c1.dekodiere(textArea2.getText()));
					
				}
				
				
			}

			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(307, 326, 180, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Klartext  ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(8, 11, 154, 106);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("   Geheimtext");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 138, 154, 106);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("END");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(437, 255, 89, 50);
		frame.getContentPane().add(btnNewButton_4);
		
		
	}
	//}
	
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CodecGUII window = new CodecGUII(new Wuerfel(), new Caesar());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
