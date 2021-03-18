import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class RoomAdd extends JFrame {
	Connection connection;

	private JPanel contentPane;
	private JTextField textFieldrno;
	private JTextField textFieldbtype;
	private JTextField textFieldrpx;
	private JTextField textFieldrcond;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomAdd frame = new RoomAdd();
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
	public RoomAdd() {
		setResizable(false);
		setTitle("Genius Arena");
		connection = hotelDbConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Number");
		lblNewLabel.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel.setBounds(124, 209, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_1.setBounds(139, 254, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room Price");
		lblNewLabel_2.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_2.setBounds(128, 298, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Room Condition");
		lblNewLabel_3.setFont(new Font("FangSong", Font.BOLD, 15));
		lblNewLabel_3.setBounds(107, 340, 139, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldrno = new JTextField();
		textFieldrno.setBounds(256, 206, 139, 20);
		contentPane.add(textFieldrno);
		textFieldrno.setColumns(10);
		
		textFieldbtype = new JTextField();
		textFieldbtype.setBounds(256, 251, 139, 20);
		contentPane.add(textFieldbtype);
		textFieldbtype.setColumns(10);
		
		textFieldrpx = new JTextField();
		textFieldrpx.setBounds(256, 295, 139, 20);
		contentPane.add(textFieldrpx);
		textFieldrpx.setColumns(10);
		
		textFieldrcond = new JTextField();
		textFieldrcond.setBounds(256, 337, 139, 20);
		contentPane.add(textFieldrcond);
		textFieldrcond.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD ROOM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "Insert into guestinfo (RoomNo,Bedtype,RoomPrice,RoomCondition) values (?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldrno.getText());
					pst.setString(2, textFieldbtype.getText());
					pst.setString(3, textFieldrpx.getText());
					pst.setString(4, textFieldrcond.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(btnNewButton, "ROOM ADD SUCCESSFUL");
					pst.close();
					textFieldrno.setText("");
					textFieldbtype.setText("");
					textFieldrpx.setText("");
					textFieldrcond.setText("");
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton.setBounds(151, 429, 122, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomInfo roominfo = new RoomInfo();
				roominfo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton_1.setBounds(344, 429, 105, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewPic = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("Images\\bed.jpg")).getImage();
		lblNewPic.setIcon(new ImageIcon(image));
		lblNewPic.setBounds(46, 11, 528, 187);
		contentPane.add(lblNewPic);
	}
}
