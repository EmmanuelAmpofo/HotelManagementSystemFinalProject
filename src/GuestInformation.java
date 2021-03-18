import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GuestInformation extends JFrame {
	Connection connection;

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldType;
	private JTextField textFieldRoomtype;
	private JTextField textFieldAmount;
	private JTextField textFieldGuestID;
	private JTextField textFieldSurname;
	private JTextField textFieldnDays;
	private JTextField textFieldrn;
	private JTextField textFieldrpx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestInformation frame = new GuestInformation();
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
	public GuestInformation() {
		setResizable(false);
		setTitle("Genius Arena");
		connection = hotelDbConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setFont(new Font("FangSong", Font.BOLD, 17));
		lblNewLabel.setBounds(63, 69, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName:");
		lblNewLabel_1.setFont(new Font("FangSong", Font.BOLD, 17));
		lblNewLabel_1.setBounds(63, 111, 97, 14);
		contentPane.add(lblNewLabel_1);
		//textFieldGuestID.setVisible(false);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(170, 109, 148, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setFont(new Font("FangSong", Font.BOLD, 17));
		lblNewLabel_2.setBounds(63, 194, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone:");
		lblNewLabel_3.setFont(new Font("FangSong", Font.BOLD, 16));
		lblNewLabel_3.setBounds(64, 235, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sex:");
		lblNewLabel_4.setFont(new Font("FangSong", Font.BOLD, 17));
		lblNewLabel_4.setBounds(78, 274, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(170, 192, 148, 20);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(170, 231, 148, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldType = new JTextField();
		textFieldType.setBounds(171, 273, 148, 20);
		contentPane.add(textFieldType);
		textFieldType.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD GUEST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "Insert into guestinfo (Guestid, FirstName,Surname, Address, Phone, Sex, Roomtype,RoomNo,RoomPrce InitialDeposit,NumberOfDays) values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldGuestID.getText());
					pst.setString(2, textFieldName.getText());
					pst.setString(3, textFieldSurname.getText());
					pst.setString(4, textFieldAddress.getText());
					pst.setString(5, textFieldPhone.getText());
					pst.setString(6, textFieldType.getText());
					pst.setString(7,textFieldRoomtype.getText());
					pst.setString(8,textFieldrn.getText());
					pst.setString(9,textFieldrpx.getText());
					pst.setString(10, textFieldAmount.getText());
					pst.setString(11, textFieldnDays.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(btnNewButton, "GUEST CHECK_IN SUCCESSFUL");
					pst.close();
					textFieldGuestID.setText("");
					textFieldName.setText("");
					textFieldSurname.setText("");
					textFieldAddress.setText("");
					textFieldAddress.setText("");
					textFieldPhone.setText("");
					textFieldType.setText("");
					textFieldRoomtype.setText("");
					textFieldAmount.setText("");
					textFieldnDays.setText("");
					textFieldrn.setText("");
					textFieldrpx.setText("");
					
					//Staffpage staffpage = new Staffpage();
					//staffpage.setVisible(true);
					//dispose();
					
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton.setBounds(63, 551, 128, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(JFrame.DISPOSE_ON_CLOSE);
				Staffpage staffpage = new Staffpage();
				staffpage.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton_1.setBounds(272, 551, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("GUEST DETAILS");
		lblNewLabel_5.setFont(new Font("FangSong", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_5.setBounds(98, 11, 303, 41);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Room Type");
		lblNewLabel_6.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_6.setBounds(62, 316, 85, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldRoomtype = new JTextField();
		textFieldRoomtype.setBounds(170, 313, 148, 20);
		contentPane.add(textFieldRoomtype);
		textFieldRoomtype.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Initial Deposit");
		lblNewLabel_7.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_7.setBounds(21, 439, 128, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(172, 437, 148, 20);
		contentPane.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		textFieldGuestID = new JTextField();
		textFieldGuestID.setColumns(10);
		textFieldGuestID.setBounds(170, 67, 148, 20);
		contentPane.add(textFieldGuestID);
		
		JLabel lblNewLabel_8 = new JLabel("Surname:");
		lblNewLabel_8.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_8.setBounds(63, 155, 76, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(170, 150, 148, 20);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Number of Days");
		lblNewLabel_9.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_9.setBounds(31, 482, 128, 14);
		contentPane.add(lblNewLabel_9);
		
		textFieldnDays = new JTextField();
		textFieldnDays.setBounds(171, 479, 148, 20);
		contentPane.add(textFieldnDays);
		textFieldnDays.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Room Number");
		lblNewLabel_10.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_10.setBounds(54, 358, 116, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Room Price");
		lblNewLabel_11.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_11.setBounds(63, 399, 85, 14);
		contentPane.add(lblNewLabel_11);
		
		textFieldrn = new JTextField();
		textFieldrn.setBounds(171, 354, 148, 20);
		contentPane.add(textFieldrn);
		textFieldrn.setColumns(10);
		
		textFieldrpx = new JTextField();
		textFieldrpx.setBounds(172, 393, 148, 20);
		contentPane.add(textFieldrpx);
		textFieldrpx.setColumns(10);
	}
}
