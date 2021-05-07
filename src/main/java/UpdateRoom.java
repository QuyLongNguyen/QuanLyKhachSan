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

public class UpdateRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRoom frame = new UpdateRoom("");
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
	public UpdateRoom(final String MaPhong) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 508, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 ph\u00F2ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 72, 105, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblMLoi = new JLabel("M\u00E3 lo\u1EA1i");
		lblMLoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMLoi.setBounds(34, 129, 105, 30);
		contentPane.add(lblMLoi);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(34, 186, 105, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnGi.setBounds(34, 186, 105, 30);
		contentPane.add(lblnGi);
		
		JButton btnNewButton = new JButton("C\u1EADp nh\u1EADt");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(188, 268, 112, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u00F4ng tin ph\u00F2ng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(174, 23, 151, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel(MaPhong);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(149, 72, 112, 30);
		contentPane.add(lblNewLabel_3);
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(149, 131, 105, 30);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(149, 186, 143, 30);
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
					PreparedStatement stt = conn.prepareStatement("update phong set maloai = ? where maphong = ?");
					stt.setString(2, MaPhong);
					stt.setString(1, (String) comboBox.getSelectedItem());
					int row =0 ;
					row = stt.executeUpdate();	
					if(row !=0) {
						JOptionPane.showMessageDialog(comboBox, "Cập nhật thành công");
					}
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
	}
	
}
