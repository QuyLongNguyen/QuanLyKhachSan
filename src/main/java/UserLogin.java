import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UserLogin extends JFrame  {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					
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
	public UserLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java projects\\QuanLyPhong\\assets\\hotel-finder-icon.png"));
		setTitle("Qu\u1EA3n l\u00FD kh\u00E1ch s\u1EA1n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("M\u1EADt kh\u1EA9u :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		txt_username = new JTextField();
		txt_username.setColumns(10);
		
		final JButton btn_login = new JButton("\u0110\u0103ng nh\u1EADp");
		
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txt_username.getText();
				String passWord = txt_password.getText();
				
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("Select * from user where username = ? and password = ?");
					stt.setString(1, userName);
					stt.setString(2, passWord);
					ResultSet rs = stt.executeQuery();
					String t;
					if(rs.next()) {
						dispose();
						int permission = rs.getInt("Permission");
						if(permission == 0) {
							HomePage ah = new HomePage();
	                        ah.setTitle("Chao mung");
	                        ah.setVisible(true);
						}
						else {
							HomePage2 ah = new HomePage2();
	                        ah.setTitle("Chao mung");
	                        ah.setVisible(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(txt_username, "Đăng nhập không thành công");
					}
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
		
		txt_password = new JPasswordField();
		
		JLabel image_home = new JLabel(new ImageIcon("D:\\Java projects\\QuanLyPhong\\assets\\hotel-finder-icon.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(215)
					.addComponent(image_home, GroupLayout.PREFERRED_SIZE, 106, Short.MAX_VALUE)
					.addGap(215))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_username, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(txt_password, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
					.addGap(133))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(216)
					.addComponent(btn_login, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(197))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(image_home, GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE)
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addGap(58))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(txt_username, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(txt_password, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
							.addGap(14)))
					.addGap(18)
					.addComponent(btn_login, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(37))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
}
