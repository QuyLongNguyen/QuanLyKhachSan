import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRoom frame = new DeleteRoom("");
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
	public DeleteRoom(final String MaPhong) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 400, 427, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txt_xoa_phong = new JLabel("B\u1EA1n c\u00F3 ch\u1EAFc ch\u1EAFc mu\u1ED1n x\u00F3a ph\u00F2ng " + MaPhong + " ?");
		txt_xoa_phong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_xoa_phong.setBounds(65, 22, 307, 128);
		contentPane.add(txt_xoa_phong);
		
		final JButton btn_xoa = new JButton("X\u00F3a");
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("delete from phong where maphong = ?");
					stt.setString(1,MaPhong);
					int row = 0;
					row = stt.executeUpdate();
					if(row != 0 ) {
						JOptionPane.showMessageDialog(btn_xoa, "Xóa phòng thành công");
					}
					
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_xoa.setBounds(56, 171, 105, 47);
		contentPane.add(btn_xoa);
		
		JButton btn_huy = new JButton("H\u1EE7y b\u1ECF");
		btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_huy.setBounds(234, 171, 105, 47);
		contentPane.add(btn_huy);
	}
}
