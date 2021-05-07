import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoom frame = new AddRoom();
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
	public AddRoom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 442, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMLoi = new JLabel("M\u00E3 lo\u1EA1i");
		lblMLoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMLoi.setBounds(60, 72, 86, 30);
		contentPane.add(lblMLoi);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(84, 136, 105, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnGi.setBounds(60, 136, 105, 30);
		contentPane.add(lblnGi);
		
		JButton btnNewButton = new JButton("Thêm");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(156, 207, 112, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Thêm phòng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(156, 21, 151, 30);
		contentPane.add(lblNewLabel_1);
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(156, 74, 105, 30);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(156, 136, 143, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		try {
			Connection conn = DBConnectioner.getConnection();
			PreparedStatement stt = conn.prepareStatement("select * from loaiphong;");
			ResultSet rs = stt.executeQuery();	
			while (rs.next()) {
			   comboBox.addItem(rs.getString("MaLoai"));  
			}		
			conn.close();
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		textField.setEditable(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select dongia from loaiphong where maloai = ?;");
					stt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = stt.executeQuery();	
					while (rs.next()) {
					Float dongia = rs.getFloat("dongia");
					   textField.setText(dongia.toString());
					}		
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("insert into Phong(MaLoai) values (?)");
					stt.setString(1, (String) comboBox.getSelectedItem());
					int row =0 ;
					row = stt.executeUpdate();	
					if(row !=0) {
						JOptionPane.showMessageDialog(comboBox, "Thêm phòng thành công");
					}
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
	}
	
}
