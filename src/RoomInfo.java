import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

 
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class RoomInfo extends JFrame {
	Connection connections ;

	private JPanel contentPane;
	private JTable tableroom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomInfo frame = new RoomInfo();
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
	public RoomInfo() {
		setResizable(false);
		setTitle("Genius Arena");
		connections = hotelDbConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 241, 630, 260);
		contentPane.add(scrollPane);
		
		tableroom = new JTable();
		scrollPane.setViewportView(tableroom);
		
		JButton btnLoadRoom = new JButton("LOAD ROOMS ");
		btnLoadRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select RoomNo,BedType,RoomPrice from guestinfo";
					PreparedStatement pst = connections.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableroom.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1) { 
					e1.printStackTrace();
					
				}
			}
		});
		btnLoadRoom.setFont(new Font("FangSong", Font.BOLD, 15));
		btnLoadRoom.setBounds(49, 550, 207, 33);
		contentPane.add(btnLoadRoom);
		
		JButton btnNewButton = new JButton("ADD ROOM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomAdd roomadd = new RoomAdd();
				roomadd.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton.setBounds(320, 550, 143, 33);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mainpg = new MainPage();
				mainpg.setVisible(true); 
				dispose();
			}
		});
		btnExit.setFont(new Font("FangSong", Font.BOLD, 15));
		btnExit.setBounds(521, 550, 116, 33);
		contentPane.add(btnExit);
		
		JLabel lblNewp = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("Images\\roompic.jpg")).getImage();
		lblNewp.setIcon(new ImageIcon(img1));
		lblNewp.setBounds(49, 11, 630, 219);
		contentPane.add(lblNewp);
	}
}
