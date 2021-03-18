import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login {

	private JFrame frmGeniusArena;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPicture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmGeniusArena.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frmGeniusArena = new JFrame();
		frmGeniusArena.setResizable(false);
		frmGeniusArena.setTitle("Genius Arena");
		frmGeniusArena.setBounds(100, 100, 544, 409);
		frmGeniusArena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeniusArena.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("FangSong", Font.BOLD, 15));
		lblUsername.setBounds(90, 139, 104, 25);
		frmGeniusArena.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("FangSong", Font.BOLD, 15)); 
		lblPassword.setBounds(90, 223, 76, 14);
		frmGeniusArena.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(204, 135, 211, 32);
		frmGeniusArena.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 214, 211, 32);
		frmGeniusArena.getContentPane().add(passwordField);
		
		JButton btnLoginAsStaff = new JButton("STAFF LOGIN");
		btnLoginAsStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textField.getText();
				String password = passwordField.getText();
				
				if(username.equals("staff") && password.equals("staff")) {
					Staffpage staffpage = new Staffpage();
					staffpage.setVisible(true);
					frmGeniusArena.dispose();
				}
				else {
					JOptionPane.showMessageDialog(btnLoginAsStaff, "Invalid Credentials");
				}
			}
		});
		btnLoginAsStaff.setForeground(Color.BLUE);
		btnLoginAsStaff.setFont(new Font("FangSong", Font.BOLD, 14));
		btnLoginAsStaff.setBounds(65, 310, 125, 32);
		frmGeniusArena.getContentPane().add(btnLoginAsStaff);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				System.exit(JFrame.EXIT_ON_CLOSE); 
			} 
		});
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("FangSong", Font.BOLD, 14));
		btnCancel.setBounds(400, 312, 89, 28);
		frmGeniusArena.getContentPane().add(btnCancel);
		
		JButton btnAdminLogin = new JButton("ADMIN LOGIN");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				if(username.equals("admin") && password.equals("admin")) {
					MainPage mainpage = new MainPage(); 
					mainpage.setVisible(true);
					frmGeniusArena.dispose();
				}
				else {
					JOptionPane.showMessageDialog(btnAdminLogin, "Invalid Credentials");
				}
			}
		});
		btnAdminLogin.setFont(new Font("FangSong", Font.BOLD, 13));
		btnAdminLogin.setForeground(Color.BLUE);
		btnAdminLogin.setBounds(226, 310, 134, 32);
		frmGeniusArena.getContentPane().add(btnAdminLogin);
		
		JLabel lblNewP = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("Images\\Fpage.jpg")).getImage();
		lblNewP.setIcon(new ImageIcon(img1));
		lblNewP.setBounds(0, 0, 528, 374);
		frmGeniusArena.getContentPane().add(lblNewP);
		
		
		
		
		
	}
}
