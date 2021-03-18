import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Scrollbar;

public class Staffpage extends JFrame {
	Connection connection ;

	private JPanel contentPane;
	private JTable table;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staffpage frame = new Staffpage();
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
	public Staffpage() {
		setResizable(false);
		setTitle("Genius Arena");
		connection = hotelDbConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1205, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 66, 802, 534);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewGuest = new JButton("CHECK_IN");
		btnNewGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GuestInformation guestinformation = new GuestInformation();
				guestinformation.setVisible(true);
				dispose();
				
			}
		});
		btnNewGuest.setFont(new Font("FangSong", Font.BOLD, 14));
		btnNewGuest.setBounds(70, 32, 109, 23);
		contentPane.add(btnNewGuest);
		
		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checkoutpage checkoutpage = new Checkoutpage();
				checkoutpage.setVisible(true);
				dispose();
			}
		});
		btnCheckout.setFont(new Font("FangSong", Font.BOLD, 14));
		btnCheckout.setBounds(257, 32, 103, 23);
		contentPane.add(btnCheckout);
		
		JButton btnLoadInfo = new JButton("LOAD GUEST INFORMATION");
		btnLoadInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select GuestID,FirstName,Surname,Address,Phone,Sex,RoomType,InitialDeposit,NumberOfDays from guestinfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnLoadInfo.setFont(new Font("FangSong", Font.BOLD, 14));
		btnLoadInfo.setBounds(427, 32, 200, 23);
		contentPane.add(btnLoadInfo);
		
		JButton btnNewButton = new JButton("RESTAURANT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestaurantOrder restaurant = new RestaurantOrder();
				restaurant.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton.setBounds(675, 32, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton_1.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton_1.setBounds(705, 622, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblnew = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("Images\\front.jpg")).getImage();
		lblnew.setIcon(new ImageIcon(img1));
		lblnew.setBounds(839, 66, 340, 534);
		contentPane.add(lblnew);
		
		
	}
}
