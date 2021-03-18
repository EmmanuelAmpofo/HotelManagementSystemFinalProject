import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setResizable(false);
		setTitle("Genius Arena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStaff = new JButton("STAFF");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staffpage staffpage = new Staffpage();
				staffpage.setVisible(true); 
				dispose();  
			}
		});
		btnStaff.setFont(new Font("FangSong", Font.BOLD, 20));
		btnStaff.setBounds(63, 171, 236, 50);
		contentPane.add(btnStaff);
		
		JButton btnRooms = new JButton("ROOMS"); 
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomInfo roominfo = new RoomInfo();
				roominfo.setVisible(true); 
			    dispose(); 
			}
		});
		btnRooms.setFont(new Font("FangSong", Font.BOLD, 20));
		btnRooms.setBounds(63, 368, 236, 50);
		contentPane.add(btnRooms);
		
		JButton btnRestaurant = new JButton("RESTAURANT");
		btnRestaurant.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				RestaurantOrder restaurantorder = new RestaurantOrder();
				restaurantorder.setVisible(true);
				dispose();
			}
		});
		btnRestaurant.setFont(new Font("FangSong", Font.BOLD, 20));
		btnRestaurant.setBounds(498, 171, 252, 50);
		contentPane.add(btnRestaurant);
		
		JButton btnNewButton = new JButton("DISPLAY GUEST INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllInfo allinfo  = new AllInfo();
				allinfo.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("FangSong", Font.BOLD, 15));
		btnNewButton.setBounds(452, 370, 325, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblpict = new JLabel("New label");
		Image img1 = new ImageIcon(this.getClass().getResource("Images\\background.jpg")).getImage();
		lblpict.setIcon(new ImageIcon(img1));
		lblpict.setBounds(0, 0, 843, 518);
		contentPane.add(lblpict);
	}

}
