import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut("");
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
	public CheckOut(final String MaPhieu) {
		setTitle("Th\u00F4ng tin tr\u1EA3 ph\u00F2ng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 605, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin tr\u1EA3 ph\u00F2ng");
		lblNewLabel.setBounds(186, 10, 202, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMPhng = new JLabel("M\u00E3 phi\u1EBFu:");
		lblMPhng.setBounds(35, 61, 88, 40);
		lblMPhng.setHorizontalAlignment(SwingConstants.LEFT);
		lblMPhng.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMPhng_1 = new JLabel("M\u00E3 ph\u00F2ng:");
		lblMPhng_1.setBounds(35, 131, 88, 40);
		lblMPhng_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMPhng_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMKhch = new JLabel("M\u00E3 kh\u00E1ch:");
		lblMKhch.setBounds(282, 131, 88, 40);
		lblMKhch.setHorizontalAlignment(SwingConstants.LEFT);
		lblMKhch.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMLoi = new JLabel("M\u00E3 lo\u1EA1i:");
		lblMLoi.setBounds(35, 189, 88, 40);
		lblMLoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblMLoi.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNgyThu = new JLabel("Ng\u00E0y thu\u00EA:");
		lblNgyThu.setBounds(282, 247, 88, 40);
		lblNgyThu.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgyThu.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNgyTr = new JLabel("Ng\u00E0y tr\u1EA3:");
		lblNgyTr.setBounds(282, 297, 88, 40);
		lblNgyTr.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgyTr.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblTngTin = new JLabel("T\u1ED5ng ti\u1EC1n:");
		lblTngTin.setBounds(35, 382, 88, 40);
		lblTngTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblMPhng_1);
		contentPane.add(lblMPhng);
		contentPane.add(lblMLoi);
		contentPane.add(lblTngTin);
		contentPane.add(lblNgyThu);
		contentPane.add(lblNgyTr);
		contentPane.add(lblMKhch);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(129, 361, 396, 11);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(129, 102, 396, 11);
		contentPane.add(separator_1);

		JButton btn_tra_phong_xn = new JButton("Tr\u1EA3 ph\u00F2ng");

		btn_tra_phong_xn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_tra_phong_xn.setBounds(234, 464, 133, 42);
		contentPane.add(btn_tra_phong_xn);

		JLabel txt_ma_phieu_tra = new JLabel("");
		txt_ma_phieu_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ma_phieu_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ma_phieu_tra.setBounds(149, 61, 88, 40);
		contentPane.add(txt_ma_phieu_tra);

		final JLabel txt_ma_phong_tra = new JLabel("");
		txt_ma_phong_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ma_phong_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ma_phong_tra.setBounds(149, 131, 88, 40);
		contentPane.add(txt_ma_phong_tra);

		JLabel txt_ma_khach_tra = new JLabel("");
		txt_ma_khach_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ma_khach_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ma_khach_tra.setBounds(399, 131, 88, 40);
		contentPane.add(txt_ma_khach_tra);

		JLabel txt_ma_loai_tra = new JLabel("");
		txt_ma_loai_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ma_loai_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ma_loai_tra.setBounds(149, 189, 88, 40);
		contentPane.add(txt_ma_loai_tra);

		JLabel txt_don_gia_tra = new JLabel("");
		txt_don_gia_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_don_gia_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_don_gia_tra.setBounds(399, 189, 88, 40);
		contentPane.add(txt_don_gia_tra);

		JLabel txt_ngay_thue_tra = new JLabel("");
		txt_ngay_thue_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ngay_thue_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ngay_thue_tra.setBounds(399, 247, 126, 40);
		contentPane.add(txt_ngay_thue_tra);

		JLabel txt_ngay_tra_tra = new JLabel("");
		txt_ngay_tra_tra.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ngay_tra_tra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ngay_tra_tra.setBounds(399, 297, 126, 40);
		contentPane.add(txt_ngay_tra_tra);

		JLabel txt_so_ngay = new JLabel("");
		txt_so_ngay.setHorizontalAlignment(SwingConstants.LEFT);
		txt_so_ngay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_so_ngay.setBounds(149, 263, 88, 40);
		contentPane.add(txt_so_ngay);

		JLabel txt_tong_tien = new JLabel("");
		txt_tong_tien.setHorizontalAlignment(SwingConstants.LEFT);
		txt_tong_tien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tong_tien.setBounds(149, 382, 175, 40);
		contentPane.add(txt_tong_tien);

		txt_ma_phieu_tra.setText(MaPhieu);

		JLabel txt_sad = new JLabel("S\u1ED1 ng\u00E0y:");
		txt_sad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_sad.setBounds(38, 263, 85, 40);
		contentPane.add(txt_sad);

		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1:");
		lblnGi.setHorizontalAlignment(SwingConstants.LEFT);
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnGi.setBounds(282, 189, 88, 40);
		contentPane.add(lblnGi);
	
		try {
			Connection conn = DBConnectioner.getConnection();
			PreparedStatement stt = conn.prepareStatement(
					"select t.*, l.MaLoai , l.DonGia,datediff(NgayTra,NgayThue) as SoNgay, (datediff(NgayTra,NgayThue) * l.DonGia) as TongTien from thuephong t \r\n"
							+ "join phong p on t.MaPhong = p.MaPhong \r\n"
							+ "join loaiphong l on p.MaLoai = l.MaLoai\r\n" + "where t.MaPhieu = ?; ");
			stt.setInt(1, Integer.parseInt(MaPhieu));
			ResultSet rs = stt.executeQuery();
			while (rs.next()) {
				
				txt_ma_phong_tra.setText(rs.getString("t.MaPhong"));
				txt_don_gia_tra.setText(rs.getString("l.DonGia"));
				txt_ma_khach_tra.setText(rs.getString("t.MaKhach"));
				txt_ngay_thue_tra.setText(rs.getDate("NgayThue").toString());
				txt_ngay_tra_tra.setText(rs.getDate("NgayTra").toString());
				txt_so_ngay.setText(rs.getString("SoNgay"));
				txt_tong_tien.setText(rs.getString("TongTien"));
				txt_ma_loai_tra.setText(rs.getString("l.MaLoai"));
			}
			conn.close();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		btn_tra_phong_xn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement(
							"insert into hoadon(MaPhong,MaKhach,MaLoai,DonGia,NgayThue,NgayTra,SoNgay,TongTien)\r\n" + 
							"select t.MaPhong,t.MaKhach,l.MaLoai,l.DonGia, t.NgayThue, t.NgayTra,datediff(NgayTra,NgayThue) as SoNgay, (datediff(NgayTra,NgayThue) * l.DonGia) as TongTien from thuephong t \r\n" + 
							"					join phong p on t.MaPhong = p.MaPhong \r\n" + 
							"					join loaiphong l on p.MaLoai = l.MaLoai\r\n" + 
							"					where t.MaPhieu = ?; ");
					stt.setInt(1, Integer.parseInt(MaPhieu));
					int row = stt.executeUpdate();
					
					stt = conn.prepareStatement("select MaPhong from thuephong where maphieu = ?");
					stt.setInt(1, Integer.parseInt(MaPhieu));
					ResultSet rs = stt.executeQuery();
					int maphong = -1;
					while(rs.next()) {
						maphong = rs.getInt("MaPhong");
					}
					stt = conn.prepareStatement("delete from thuephong where maphong = ?");
					stt.setInt(1, maphong);
					stt.execute();
					if(row != 0) {
						JOptionPane.showMessageDialog(txt_ma_phong_tra, "Đã thêm hóa đơn" + maphong);
					}
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
	}
}
