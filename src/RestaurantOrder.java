import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.TextArea;

public class RestaurantOrder extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JCheckBox chckbx5;
	
	private JCheckBox chckbx7;
	private JCheckBox chckbx8;
	private JCheckBox chckbx9;
	private JCheckBox chckbx11;
	
	private JCheckBox chckbx13;
	private JCheckBox chckbx14;
	private JCheckBox chckbx15;
	private JCheckBox chckbx16;
	
	
	
	private JCheckBox chckbx19;
	private JCheckBox chckbx21;
	
	private JCheckBox chckbx24;
	private JCheckBox chckbx25;
	
	
	private JCheckBox chckbx28;
	private JCheckBox chckbx29;
	
	private JCheckBox chckbx32;
	private JCheckBox chckbx33;
	private JRadioButton rdbtnDinner;
	private JRadioButton rdbtnLunch;
	private JRadioButton rdbtnBreakfast;
	private JButton btnCalcu;
	private JButton btnExit;
	private JTextField textFieldSubtotal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textFieldTax;
	private JTextField textFieldTotal;
	private TextArea textArea;
	private JSeparator separator_3;
	private JLabel lblpicture;
	private JLabel lblpicture2;
	private JLabel lblpicture3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantOrder frame = new RestaurantOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RestaurantOrder() {
		setResizable(false);
		setTitle("Genius Arena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1161, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(445, 242, 2, 290);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-22, 349, 469, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 440, 438, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_3 = new JLabel("SOFT DRINKS");
		lblNewLabel_3.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_3.setBounds(457, 271, 118, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("ALCOHOL");
		lblNewLabel_5.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_5.setBounds(457, 414, 78, 14);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(445, 379, 392, 2);
		contentPane.add(separator_5);
		
		rdbtnBreakfast = new JRadioButton("BREAKFAST");
		rdbtnBreakfast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBreakfast.isSelected()) {
					rdbtnLunch.setSelected(false);
					rdbtnDinner.setSelected(false);
					
				}
			}
		});
		rdbtnBreakfast.setFont(new Font("FangSong", Font.BOLD, 15));
		rdbtnBreakfast.setBounds(6, 267, 109, 23);
		contentPane.add(rdbtnBreakfast);
		
		rdbtnLunch = new JRadioButton("LUNCH");
		rdbtnLunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnLunch.isSelected()) {
					rdbtnBreakfast.setSelected(false);
					rdbtnDinner.setSelected(false);
				}
			}
		});
		rdbtnLunch.setFont(new Font("FangSong", Font.BOLD, 15));
		rdbtnLunch.setBounds(6, 358, 109, 23);
		contentPane.add(rdbtnLunch);
		
		rdbtnDinner = new JRadioButton("DINNER");
		rdbtnDinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDinner.isSelected()) {
					rdbtnBreakfast.setSelected(false);
					rdbtnLunch.setSelected(false);
				}
			}
		});
		rdbtnDinner.setFont(new Font("FangSong", Font.BOLD, 15));
		rdbtnDinner.setBounds(10, 449, 109, 23);
		contentPane.add(rdbtnDinner);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("FangSong", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx1.setSelected(false);
				chckbx2.setSelected(false);
				chckbx3.setSelected(false);
				
				chckbx5.setSelected(false);
				chckbx7.setSelected(false);
				chckbx8.setSelected(false);
				chckbx9.setSelected(false);
				
				chckbx11.setSelected(false);
				
				chckbx13.setSelected(false);
				chckbx14.setSelected(false);
				chckbx15.setSelected(false);
				chckbx16.setSelected(false);
				
				chckbx19.setSelected(false);
				
				chckbx21.setSelected(false);
				
				chckbx24.setSelected(false);
				chckbx25.setSelected(false);
				
				
				chckbx28.setSelected(false);
				chckbx29.setSelected(false);
				
				
				chckbx32.setSelected(false);
				chckbx33.setSelected(false);
				
				
				rdbtnBreakfast.setSelected(false);
				rdbtnLunch.setSelected(false);
				rdbtnDinner.setSelected(false);
				
				textFieldSubtotal.setText("");
				textFieldTax.setText("");
				textFieldTotal.setText("");
				textArea.setText("");
				
			}
		});
		btnReset.setBounds(479, 658, 89, 23);
		contentPane.add(btnReset);
		
		chckbx1 = new JCheckBox("English Breakfast -100gh");
		chckbx1.setBounds(6, 293, 218, 23);
		contentPane.add(chckbx1);
		
		 chckbx2 = new JCheckBox("American Breakfast -120gh");
		chckbx2.setBounds(221, 293, 218, 23);
		contentPane.add(chckbx2);
		
		 chckbx3 = new JCheckBox("Healthy Breakfast -150gh");
		chckbx3.setBounds(6, 319, 218, 23);
		contentPane.add(chckbx3);
		
		 chckbx5 = new JCheckBox("White Toast -20gh");
		chckbx5.setBounds(226, 319, 155, 23);
		contentPane.add(chckbx5);
		
		chckbx8 = new JCheckBox("Spaghetti Bolognaise -120gh");
		chckbx8.setBounds(196, 384, 204, 23);
		contentPane.add(chckbx8);
		
		chckbx9 = new JCheckBox("Spaghetti with Concasse  -100gh");
		chckbx9.setBounds(196, 410, 230, 23);
		contentPane.add(chckbx9);
		
		chckbx11 = new JCheckBox("Tuna Sandwich -80gh\r\n");
		chckbx11.setBounds(6, 410, 183, 23);
		contentPane.add(chckbx11);
		
		chckbx7 = new JCheckBox("Lunch Buffet 250gh");
		chckbx7.setBounds(6, 384, 196, 23);
		contentPane.add(chckbx7);
		
		chckbx13 = new JCheckBox("Chef's Special Salmon  -300gh");
		chckbx13.setBounds(11, 475, 195, 23);
		contentPane.add(chckbx13);
		
		chckbx14 = new JCheckBox("New Zealand Lamb Soup -200gh");
		chckbx14.setBounds(208, 475, 218, 23);
		contentPane.add(chckbx14);
		
		chckbx15 = new JCheckBox("Japenese Scallop -180gh");
		chckbx15.setBounds(209, 501, 195, 23);
		contentPane.add(chckbx15);
		
		chckbx16 = new JCheckBox("Goat/Beef Light Soup -170gh");
		chckbx16.setBounds(10, 501, 214, 23);
		contentPane.add(chckbx16);
		
		chckbx19 = new JCheckBox("Malta Guinness -15gh");
		chckbx19.setBounds(458, 319, 155, 23);
		contentPane.add(chckbx19);
		
		chckbx25 = new JCheckBox("Sprite -10gh");
		chckbx25.setBounds(648, 349, 109, 23);
		contentPane.add(chckbx25);
		
		chckbx24 = new JCheckBox("Bitter Lemon -10gh");
		chckbx24.setBounds(460, 349, 153, 23);
		contentPane.add(chckbx24);
		
		chckbx21 = new JCheckBox("Diet Coke -12gh");
		chckbx21.setBounds(648, 319, 129, 23);
		contentPane.add(chckbx21);
		
		chckbx28 = new JCheckBox("Heineken-30gh");
		chckbx28.setBounds(453, 437, 123, 23);
		contentPane.add(chckbx28);
		
		chckbx29 = new JCheckBox("Guinness -25gh");
		chckbx29.setBounds(453, 475, 142, 23);
		contentPane.add(chckbx29);
		
		chckbx32 = new JCheckBox("Hennesey V.S -50gh");
		chckbx32.setBounds(648, 437, 154, 23);
		contentPane.add(chckbx32);
		
		chckbx33 = new JCheckBox("Grey Goose -75gh");
		chckbx33.setBounds(648, 475, 138, 23);
		contentPane.add(chckbx33);
		
		btnCalcu = new JButton("CALCULATE BILL");
		btnCalcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total;
				double subtotal = 0;
				final double TAXRATE = 0.09;
				double tax;
				
				if (chckbx1.isSelected()) {
					subtotal = subtotal + 100;
				}
				if (chckbx2.isSelected()) {
					subtotal = subtotal + 120;
				}
				if (chckbx3.isSelected()) {
					subtotal = subtotal + 150;
				}
				if (chckbx5.isSelected()) {
					subtotal = subtotal + 20;
				}
				
				if (chckbx7.isSelected()) {
					subtotal = subtotal + 250;
				}
				if (chckbx8.isSelected()) {
					subtotal = subtotal + 120;
				}
				if (chckbx9.isSelected()) {
					subtotal = subtotal + 100;
				}
				if (chckbx11.isSelected()) {
					subtotal = subtotal + 80;
				}
				if (chckbx13.isSelected()) {
					subtotal = subtotal + 300;
				}
				if (chckbx14.isSelected()) {
					subtotal = subtotal + 200;
				}
				if (chckbx15.isSelected()) {
					subtotal = subtotal + 180;
				}
				if (chckbx16.isSelected()) {
					subtotal = subtotal + 170;
				}
				if (chckbx19.isSelected()) {
					subtotal = subtotal + 15;
				}
				if (chckbx21.isSelected()) {
					subtotal = subtotal + 12;
				}
				if (chckbx24.isSelected()) {
					subtotal = subtotal + 10;
				}
				if (chckbx25.isSelected()) {
					subtotal = subtotal + 10;
				}
				if (chckbx28.isSelected()) {
					subtotal = subtotal + 30;
				}
				if (chckbx29.isSelected()) {
					subtotal = subtotal + 100;
				}
				if (chckbx32.isSelected()) {
					subtotal = subtotal + 50;
				}
				if (chckbx33.isSelected()) {
					subtotal = subtotal + 75;
				}
				
				textFieldSubtotal.setText(Double.toString(subtotal));
				subtotal = Double.parseDouble(textFieldSubtotal.getText());
				tax = subtotal * TAXRATE;
				total = tax + subtotal;
				
				textFieldTax.setText(Double.toString(tax));
				textFieldTotal.setText(Double.toString(total));
				
			}
		});
		btnCalcu.setFont(new Font("FangSong", Font.BOLD, 15));
		btnCalcu.setBounds(133, 596, 168, 23);
		contentPane.add(btnCalcu);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staffpage staff = new Staffpage();
				staff.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("FangSong", Font.BOLD, 15));
		btnExit.setBounds(956, 658, 89, 23);
		contentPane.add(btnExit);
		
		textFieldSubtotal = new JTextField();
		textFieldSubtotal.setBounds(162, 547, 142, 20);
		contentPane.add(textFieldSubtotal);
		textFieldSubtotal.setColumns(10);
		
		lblNewLabel = new JLabel("SubTotal");
		lblNewLabel.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel.setBounds(63, 550, 89, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tax");
		lblNewLabel_1.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_1.setBounds(335, 550, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_2.setBounds(311, 600, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldTax = new JTextField();
		textFieldTax.setBounds(376, 544, 142, 20);
		contentPane.add(textFieldTax);
		textFieldTax.setColumns(10);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(376, 597, 142, 20);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 531, 827, 2);
		contentPane.add(separator_6);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(845, 241, 290, 378);
		contentPane.add(textArea);
		
		JButton btnReceipt = new JButton("GENERATE RECEIPT");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date1 = new Date();
				String date = date1.toString();
				textArea.setText("*****************************************************\n");
				textArea.setText(textArea.getText()+ "****      RESTAURANT OFFICIAL RECEIPT     ****\n");
				textArea.setText(textArea.getText()+ "*****************************************************\n");
				
				textArea.setText(textArea.getText()+ "SubTotal : "+textFieldSubtotal.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "Tax : "+textFieldTax.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "Total Payable : "+textFieldTotal.getText()+"\n");
				textArea.setText(textArea.getText()+ "*****************************************************\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "         THANK YOU FOR DINNING WITH US!!!!\n");
			
				textArea.setText(textArea.getText()+ "\n"+date+"\n");
			}
		});
		btnReceipt.setFont(new Font("FangSong", Font.BOLD, 15));
		btnReceipt.setBounds(221, 658, 190, 23);
		contentPane.add(btnReceipt);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 241, 827, 2);
		contentPane.add(separator_3);
		
		lblpicture = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("Images\\restaurant.jpg")).getImage();
		lblpicture.setIcon(new ImageIcon(img1));
		lblpicture.setBounds(10, 11, 371, 220);
		contentPane.add(lblpicture);
		
		lblpicture2 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("Images\\restaurant1.jpg")).getImage();
		lblpicture2.setIcon(new ImageIcon(image));
		lblpicture2.setBounds(383, 11, 374, 219);
		contentPane.add(lblpicture2);
		
		lblpicture3 = new JLabel("");
		Image image3 = new ImageIcon(this.getClass().getResource("Images\\restaurant2.jpg")).getImage();
		lblpicture3.setIcon(new ImageIcon(image3));
		lblpicture3.setBounds(756, 11, 379, 219);
		contentPane.add(lblpicture3);
	}
}
