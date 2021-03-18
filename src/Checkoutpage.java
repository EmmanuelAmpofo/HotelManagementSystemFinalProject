import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.text.*;
import java.awt.TextArea;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.TextField;
import java.awt.print.*;
import java.awt.Button; 


public class Checkoutpage extends JFrame {
	Connection connection ;

	private JPanel contentPane;
	private JTextField textFieldGuest;
	private JTextField textFieldFName;
	private JTextField textFieldDepo;
	private JTextField textFieldRNo;
	private JTextField textFieldRType;
	private JTextField textFieldRPrice;
	private JTextField textFieldDays;
	private JTextField textFieldSName;
	private JComboBox comboBoxName;
	private JTextField textFieldsubtotal;
	private JTextField textFieldtax;
	private JTextField textFieldtotal;
	private TextArea textArea;
	private JTable table;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkoutpage frame = new Checkoutpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*public void refreshTable() {
		try {
			
			//CODE TO LOAD AND REFRESH DATABASE
			
			String query = "Select * from guestinfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		}*/
	
	public void fillComboBox() {
		try {
			String query = "Select * from guestinfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBoxName.addItem(rs.getString("GuestID"));
				textFieldGuest.setText("");
				textFieldFName.setText("");
				textFieldSName.setText("");
				textFieldDepo.setText("");
				textFieldRNo.setText("");
				textFieldRType.setText("");
				textFieldRPrice.setText("");
				textFieldDays.setText("");
			}
			
		}catch(Exception e2) {
			
		}
	}
	

	/**
	 * Create the frame.
	 */
	public Checkoutpage() {
		setResizable(false);
		setTitle("Genus Arena");
		connection = hotelDbConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest ID");
		lblNewLabel.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel.setBounds(40, 82, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_1.setBounds(40, 118, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Deposit");
		lblNewLabel_2.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_2.setBounds(40, 201, 88, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RoomNo.");
		lblNewLabel_3.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_3.setBounds(40, 243, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RoomType");
		lblNewLabel_4.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_4.setBounds(40, 279, 88, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("RoomPrice");
		lblNewLabel_5.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_5.setBounds(40, 316, 88, 14);
		contentPane.add(lblNewLabel_5);
		
		textFieldGuest = new JTextField();
		textFieldGuest.setBounds(138, 79, 134, 20);
		contentPane.add(textFieldGuest);
		textFieldGuest.setColumns(10);
		
		textFieldFName = new JTextField();
		textFieldFName.setBounds(138, 115, 134, 20);
		contentPane.add(textFieldFName);
		textFieldFName.setColumns(10);
		
		textFieldDepo = new JTextField();
		textFieldDepo.setBounds(138, 198, 134, 20);
		contentPane.add(textFieldDepo);
		textFieldDepo.setColumns(10);
		
		textFieldRNo = new JTextField();
		textFieldRNo.setBounds(138, 240, 134, 20);
		contentPane.add(textFieldRNo);
		textFieldRNo.setColumns(10);
		
		textFieldRType = new JTextField();
		textFieldRType.setBounds(138, 276, 134, 20);
		contentPane.add(textFieldRType);
		textFieldRType.setColumns(10);
		
		textFieldRPrice = new JTextField();
		textFieldRPrice.setBounds(138, 313, 134, 20);
		contentPane.add(textFieldRPrice);
		textFieldRPrice.setColumns(10);
		
		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT CHECK THIS GUEST OUT?","CheckOut Confirmation", JOptionPane.YES_NO_OPTION);
				if (action == 0) {
					try {
						String query = "Delete from guestinfo where GuestID='"+textFieldGuest.getText()+" '";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "GUEST CHECKED_OUT SUCCESSFUL");
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				textFieldtotal.setText("");
				textFieldtax.setText("");
				textFieldsubtotal.setText("");
				textFieldDays.setText("");
				textFieldGuest.setText("");
				textFieldFName.setText("");
				textFieldSName.setText("");
				textFieldDepo.setText("");
				textFieldRNo.setText("");
				textFieldRType.setText("");
				textFieldRPrice.setText("");
				textArea.setText("");	
			}
		});
		btnCheckout.setFont(new Font("FangSong", Font.BOLD, 15));
		btnCheckout.setBounds(546, 526, 115, 23);
		contentPane.add(btnCheckout);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staffpage staffpage = new Staffpage();
				staffpage.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("FangSong", Font.BOLD, 15));
		btnBack.setBounds(735, 526, 115, 23);
		contentPane.add(btnBack);
		
		JButton btnCalcBill = new JButton("CALCULATE BILL");
		btnCalcBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total;
				double subtotal = 0;
				double tax;
				final double TAXRATE = 0.1;
				
				subtotal = subtotal + Double.parseDouble(textFieldRPrice.getText());
				textFieldsubtotal.setText(Double.toString(subtotal));
				
				tax = subtotal * TAXRATE;
				total = tax + subtotal;
				
				textFieldtax.setText(Double.toString(tax));
				textFieldtotal.setText(Double.toString((total * Double.parseDouble(textFieldDays.getText()) - Double.parseDouble(textFieldDepo.getText()))));
				
				
				
				
			}
		});
		btnCalcBill.setFont(new Font("FangSong", Font.BOLD, 15));
		btnCalcBill.setBounds(10, 526, 157, 23);
		contentPane.add(btnCalcBill);
		
		JLabel lblNewLabel_7 = new JLabel("Days Stayed");
		lblNewLabel_7.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_7.setBounds(22, 355, 107, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldDays = new JTextField();
		textFieldDays.setBounds(138, 352, 134, 20);
		contentPane.add(textFieldDays);
		textFieldDays.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Surname");
		lblNewLabel_8.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_8.setBounds(42, 159, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldSName = new JTextField();
		textFieldSName.setBounds(138, 156, 134, 20);
		contentPane.add(textFieldSName);
		textFieldSName.setColumns(10);
		
		comboBoxName = new JComboBox();
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select * from guestinfo where GuestID=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, (String)comboBoxName.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					
					
					
					while(rs.next()) {
						textFieldGuest.setText(rs.getString("GuestID"));
						textFieldFName.setText(rs.getString("FirstName"));
						textFieldSName.setText(rs.getString("Surname"));
						textFieldDepo.setText(rs.getString("InitialDeposit"));
						textFieldRNo.setText(rs.getString("RoomNo"));
						textFieldRType.setText(rs.getString("RoomType"));
						textFieldRPrice.setText(rs.getString("RoomPrice"));
						textFieldDays.setText(rs.getString("NumberOfDays"));
						
					}
					pst.close();
					
				}catch(Exception e1) {
					
				}
			}
		});
		comboBoxName.setFont(new Font("FangSong", Font.BOLD, 15));
		comboBoxName.setBounds(136, 33, 136, 20);
		contentPane.add(comboBoxName);
		
		JLabel lblNewLabel_9 = new JLabel("Search by ID");
		lblNewLabel_9.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 36, 118, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6 = new JLabel("SubTotal");
		lblNewLabel_6.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_6.setBounds(40, 417, 71, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_10 = new JLabel("Tax");
		lblNewLabel_10.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_10.setBounds(57, 453, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Total Payable");
		lblNewLabel_11.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_11.setBounds(10, 487, 123, 14);
		contentPane.add(lblNewLabel_11);
		
		textFieldsubtotal = new JTextField();
		textFieldsubtotal.setBounds(138, 414, 134, 20);
		contentPane.add(textFieldsubtotal);
		textFieldsubtotal.setColumns(10);
		
		textFieldtax = new JTextField();
		textFieldtax.setBounds(138, 450, 134, 20);
		contentPane.add(textFieldtax);
		textFieldtax.setColumns(10);
		
		textFieldtotal = new JTextField();
		textFieldtotal.setBounds(138, 484, 134, 20);
		contentPane.add(textFieldtotal);
		textFieldtotal.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 391, 323, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(336, 499, 1, 61);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldtotal.setText("");
				textFieldtax.setText("");
				textFieldsubtotal.setText("");
				textFieldDays.setText("");
				textFieldGuest.setText("");
				textFieldFName.setText("");
				textFieldSName.setText("");
				textFieldDepo.setText("");
				textFieldRNo.setText("");
				textFieldRType.setText("");
				textFieldRPrice.setText("");
				textArea.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton.setBounds(201, 526, 89, 23);
		contentPane.add(btnNewButton);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("FangSong", Font.BOLD, 12));
		textArea.setBounds(336, 68, 514, 433);
		contentPane.add(textArea);
		
		JButton btnReceipt = new JButton("RECEIPT");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date1 = new Date();
				String date = date1.toString();
				textArea.setText("*************************************************************************************************\n");
				textArea.setText(textArea.getText()+ "****                                    HILL VIEW HOTEL OFFICIAL RECEIPT                                            ****\n");
				textArea.setText(textArea.getText()+ "*************************************************************************************************\n");
				textArea.setText(textArea.getText()+ "First Name : "+textFieldFName.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "Surname Name : "+textFieldSName.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "Room Number : "+textFieldRNo.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "NUmber of Days Stayed : "+textFieldDays.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "*************************************************************************************************\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "SubTotal : "+textFieldsubtotal.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "Tax : "+textFieldtax.getText()+"\n");
				textArea.setText(textArea.getText()+ "\n");
				textArea.setText(textArea.getText()+ "Total Payable : "+textFieldtotal.getText()+"\n");
				textArea.setText(textArea.getText()+ "*************************************************************************************************\n");
				textArea.setText(textArea.getText()+ "                                             THANK YOU FOR STAYING WITH US!!!!\n");
			
				textArea.setText(textArea.getText()+ "\n"+date+"\n");
			}
		});
		btnReceipt.setFont(new Font("FangSong", Font.BOLD, 15));
		btnReceipt.setBounds(365, 526, 107, 23);
		contentPane.add(btnReceipt);
		
		fillComboBox();
		
		
	}
}
