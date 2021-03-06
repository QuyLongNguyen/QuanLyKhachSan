import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import com.mysql.cj.xdevapi.PreparableStatement;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.CellRendererPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class HomePage2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField txt_tim_kiem;
	private JTable table_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage2 frame = new HomePage2();
					frame.setVisible(true);
					// frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage2() {

		setTitle("Qu\u1EA3n l\u00FD kh\u00E1ch s\u1EA1n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JMenuBar menuBar = new JMenuBar();

		JMenu mnPhong = new JMenu("Ph\u00F2ng");
		menuBar.add(mnPhong);

		JMenuItem menu_phong_co_san = new JMenuItem("Ph\u00F2ng c\u00F3 s\u1EB5n");

		mnPhong.add(menu_phong_co_san);

		JMenuItem menu_phong_cho_thue = new JMenuItem("Ph\u00F2ng cho thu\u00EA");

		mnPhong.add(menu_phong_cho_thue);

		JMenu mnLoaiPhong = new JMenu("Lo???i ph??ng");
		menuBar.add(mnLoaiPhong);

		JMenuItem menu_sua_loai_phong = new JMenuItem("Qu???n l??");

		mnLoaiPhong.add(menu_sua_loai_phong);

		JMenu mnKhach = new JMenu("Kh??ch thu??");
		menuBar.add(mnKhach);

		JMenuItem menu_khach_thue = new JMenuItem("Xem");

		mnKhach.add(menu_khach_thue);

		JMenu mnHoaDon = new JMenu("H??a ????n");
		menuBar.add(mnHoaDon);

		JMenuItem menu_hoa_don = new JMenuItem("Xem");

		mnHoaDon.add(menu_hoa_don);

		final JTabbedPane tab_content = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel_2 = new JPanel();
		tab_content.addTab("New tab", null, panel_2, null);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 638, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 604, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);

		JPanel panel = new JPanel();
		tab_content.addTab("New tab", null, panel, null);

		JPanel panel_1 = new JPanel();
		tab_content.addTab("New tab", null, panel_1, null);

		final JLabel lblNewLabel_1 = new JLabel("Danh s\u00E1ch ph\u00F2ng \u0111ang thu\u00EA");
		lblNewLabel_1.setBounds(153, 21, 326, 48);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		table_1 = new JTable();
		table_1.setBounds(42, 154, 546, 321);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1);
		panel_1.add(table_1);

		JButton btn_tra_phong = new JButton("Tr??? ph??ng");
		btn_tra_phong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				CheckOut co = new CheckOut(s);
				co.setVisible(true);
			}
		});
		btn_tra_phong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_tra_phong.setBounds(264, 524, 112, 57);
		panel_1.add(btn_tra_phong);

		txt_tim_kiem = new JTextField();
		txt_tim_kiem.setBounds(42, 93, 210, 36);
		panel_1.add(txt_tim_kiem);
		txt_tim_kiem.setColumns(10);

		final JButton btn_tim_kiem = new JButton("T??m ki???m");

		btn_tim_kiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_tim_kiem.setBounds(419, 90, 98, 39);
		panel_1.add(btn_tim_kiem);

		JButton btn_clear = new JButton("X");
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_clear.setBounds(544, 90, 44, 39);
		panel_1.add(btn_clear);

		String[] items = { "M?? ph??ng", "Lo???i ph??ng" };
		final JComboBox cbx_tim_kiem = new JComboBox(items);
		cbx_tim_kiem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbx_tim_kiem.setBounds(283, 92, 112, 36);
		panel_1.add(cbx_tim_kiem);

		table = new JTable();
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		final JLabel lblNewLabel = new JLabel("Danh s\u00E1ch ph\u00F2ng c\u00F3 s\u1EB5n");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btn_dat_phong = new JButton("?????t ph??ng");
		btn_dat_phong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) table.getValueAt(table.getSelectedRow(), 0);
				AddRent rent = new AddRent(s);
				rent.setVisible(true);
			}
		});
		btn_dat_phong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup().addGap(183)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 301,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(154, Short.MAX_VALUE))
						.addGroup(
								gl_panel.createSequentialGroup().addGap(265)
										.addComponent(btn_dat_phong, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
										.addGap(250))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(37)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addContainerGap())
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(table, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
												.addGap(29)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(42).addComponent(lblNewLabel).addGap(10).addGap(18).addComponent(table, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE).addGap(18)
						.addComponent(btn_dat_phong, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE).addGap(33)));
		panel.setLayout(gl_panel);

		JPanel panel_3 = new JPanel();
		tab_content.addTab("New tab", null, panel_3, null);

		JLabel lblNewLabel_2 = new JLabel("Danh s??ch kh??ch thu??");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(196)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGap(213))
				.addGroup(gl_panel_3.createSequentialGroup().addGap(42)
						.addComponent(table_2, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE).addGap(33)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(25)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE).addGap(10)
						.addComponent(table_2, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE).addGap(39)));
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE).addComponent(tab_content,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(0)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
										tab_content, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
								.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JMenu menuTaiKhoan = new JMenu("T??i kho???n");
		menuBar.add(menuTaiKhoan);

		JMenuItem mn_tai_khoan = new JMenuItem("????ng xu???t");
		mn_tai_khoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserLogin ul = new UserLogin();
				ul.setVisible(true);

			}
		});
		menuTaiKhoan.add(mn_tai_khoan);

		JPanel panel_4 = new JPanel();
		tab_content.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Danh s??ch h??a ????n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(220, 24, 189, 43);
		panel_4.add(lblNewLabel_3);

		table_3 = new JTable();
		table_3.setBounds(40, 100, 559, 415);
		panel_4.add(table_3);

		JButton btn_export = new JButton("In h??a ????n");

		btn_export.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_export.setBounds(278, 537, 103, 34);
		panel_4.add(btn_export);

		JPanel panel_5 = new JPanel();
		tab_content.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);

		table_5 = new JTable();
		table_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_5.setBounds(153, 98, 338, 205);
		panel_5.add(table_5);
		contentPane.setLayout(gl_contentPane);

		menu_phong_co_san.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(1);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement(
							"select MaPhong, p.MaLoai , DonGia from phong p join loaiphong l on p.MaLoai = l.MaLoai where TinhTrang = 0;");
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "Ma?? pho??ng", "Ma?? loa??i", "????n gia??"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);

					while (rs.next()) {
						String MaPhong = rs.getString("MaPhong");
						String MaLoai = rs.getString("p.MaLoai");
						Float DonGia = rs.getFloat("DonGia");

						// create a single array of one row's worth of data
						String[] data = { MaPhong, MaLoai, DonGia.toString()};

						// and add this row of data into the table model
						tableModel.addRow(data);
					}
					table.setModel(tableModel);
		

					table.setDefaultEditor(Object.class, null);
					table.changeSelection(1, 0, false, false);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		menu_phong_cho_thue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(2);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement(
							"select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n"
									+ "join loaiphong l on p.MaLoai = l.MaLoai \r\n"
									+ "join thuephong  t on p.MaPhong = t.MaPhong;");
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "", "Ma?? pho??ng", "Ma?? loa??i", "Ma?? kha??ch", "????n gia??", "Nga??y thu??", "Nga??y tra??" };
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaPhieu = rs.getString("t.MaPhieu");
						String MaPhong = rs.getString("MaPhong");
						String MaLoai = rs.getString("p.MaLoai");
						String MaKhach = rs.getString("t.MaKhach");
						Float DonGia = rs.getFloat("DonGia");
						java.util.Date NgayThue = rs.getDate("t.NgayThue");
						java.util.Date NgayTra = rs.getDate("t.NgayTra");

						// create a single array of one row's worth of data
						String[] data = { MaPhieu, MaPhong, MaLoai, MaKhach, DonGia.toString(), NgayThue.toString(),
								NgayTra.toString() };

						// and add this row of data into the table model
						tableModel.addRow(data);
						size++;
					}
					if (size == 0) {
						JOptionPane.showMessageDialog(table_1, "Kh??ng c?? d??? li???u");
					}
					table_1.setModel(tableModel);
					table_1.getColumnModel().getColumn(0).setWidth(0);
					table_1.getColumnModel().getColumn(0).setMinWidth(0);
					table_1.getColumnModel().getColumn(0).setMaxWidth(0);
					table_1.setDefaultEditor(Object.class, null);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		btn_tim_kiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement(
							"select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n"
									+ "join loaiphong l on p.MaLoai = l.MaLoai \r\n"
									+ "join thuephong  t on p.MaPhong = t.MaPhong;");
					if (cbx_tim_kiem.getSelectedIndex() == 0) {
						stt = conn.prepareStatement(
								"select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n"
										+ "join loaiphong l on p.MaLoai = l.MaLoai \r\n"
										+ "join thuephong  t on p.MaPhong = t.MaPhong " + "where t.MaPhong = ?");
						stt.setInt(1, Integer.parseInt(txt_tim_kiem.getText()));
					} else if (cbx_tim_kiem.getSelectedIndex() == 1) {
						stt = conn.prepareStatement(
								"select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n"
										+ "join loaiphong l on p.MaLoai = l.MaLoai \r\n"
										+ "join thuephong  t on p.MaPhong = t.MaPhong " + "where p.MaLoai = ?");
						stt.setInt(1, Integer.parseInt(txt_tim_kiem.getText()));
					}
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "", "Ma?? pho??ng", "Ma?? loa??i", "Ma?? kha??ch", "????n gia??", "Nga??y thu??", "Nga??y tra??" };
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaPhieu = rs.getString("t.MaPhieu");
						String MaPhong = rs.getString("MaPhong");
						String MaLoai = rs.getString("p.MaLoai");
						String MaKhach = rs.getString("t.MaKhach");
						Float DonGia = rs.getFloat("DonGia");
						java.util.Date NgayThue = rs.getDate("t.NgayThue");
						java.util.Date NgayTra = rs.getDate("t.NgayTra");

						// create a single array of one row's worth of data
						String[] data = { MaPhieu, MaPhong, MaLoai, MaKhach, DonGia.toString(), NgayThue.toString(),
								NgayTra.toString() };

						// and add this row of data into the table model
						tableModel.addRow(data);
						size++;
					}
					if (size == 0) {
						JOptionPane.showMessageDialog(table_1, "Kh??ng t??m th???y th??ng tin");
					}
					table_1.setModel(tableModel);
					table_1.getColumnModel().getColumn(0).setWidth(0);
					table_1.getColumnModel().getColumn(0).setMinWidth(0);
					table_1.getColumnModel().getColumn(0).setMaxWidth(0);
					table_1.setDefaultEditor(Object.class, null);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
		menu_khach_thue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(3);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select * from khachthue;");
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "Ma?? kha??ch", "S???? CMT", "T??n", "N??m Sinh", "SDT" };
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaKhach = rs.getString("MaKhach");
						String SoCMT = rs.getString("SoCMT");
						String Ten = rs.getString("Ten");
						Integer NamSinh = rs.getInt("NamSinh");
						String Sdt = rs.getString("SDT");

						// create a single array of one row's worth of data
						String[] data = { MaKhach, SoCMT, Ten, NamSinh.toString(), Sdt };

						// and add this row of data into the table model
						tableModel.addRow(data);
						size++;
					}
					if (size == 0) {
						JOptionPane.showMessageDialog(table_2, "Kh??ng c?? d??? li???u");
					}
					table_2.setModel(tableModel);
					table_2.setDefaultEditor(Object.class, null);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		menu_hoa_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(4);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select * from hoadon;");
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "H??a ????n", "M?? ph??ng", "M?? kh??ch", "M?? lo???i", "????n gi??", "Ng??y thu??",
							"Ng??y tr???", "S??? ng??y", "T???ng ti???n" };
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaHD = rs.getString("MaHoaDon");
						String MaPhong = rs.getString("MaPhong");
						String MaKhach = rs.getString("MaKhach");
						String MaLoai = rs.getString("MaLoai");
						Integer DonGia = rs.getInt("DonGia");
						java.util.Date Thue = rs.getDate("NgayThue");
						java.util.Date Tra = rs.getDate("NgayTra");
						Integer Ngay = rs.getInt("SoNgay");
						Float Tien = rs.getFloat("TongTien");
						// create a single array of one row's worth of data
						String[] data = { MaHD, MaPhong, MaKhach, MaLoai, DonGia.toString(), Thue.toString(),
								Tra.toString(), Ngay.toString(), Tien.toString() };

						// and add this row of data into the table model
						tableModel.addRow(data);
						size++;
					}
					if (size == 0) {
						JOptionPane.showMessageDialog(table_3, "Kh??ng c?? d??? li???u");
					}
					table_3.setModel(tableModel);
					table_3.setDefaultEditor(Object.class, null);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(2);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement(
							"select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n"
									+ "join loaiphong l on p.MaLoai = l.MaLoai \r\n"
									+ "join thuephong  t on p.MaPhong = t.MaPhong;");
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "", "Ma?? pho??ng", "Ma?? loa??i", "Ma?? kha??ch", "????n gia??", "Nga??y thu??", "Nga??y tra??" };
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaPhieu = rs.getString("t.MaPhieu");
						String MaPhong = rs.getString("MaPhong");
						String MaLoai = rs.getString("p.MaLoai");
						String MaKhach = rs.getString("t.MaKhach");
						Float DonGia = rs.getFloat("DonGia");
						java.util.Date NgayThue = rs.getDate("t.NgayThue");
						java.util.Date NgayTra = rs.getDate("t.NgayTra");

						// create a single array of one row's worth of data
						String[] data = { MaPhieu, MaPhong, MaLoai, MaKhach, DonGia.toString(), NgayThue.toString(),
								NgayTra.toString() };

						// and add this row of data into the table model
						tableModel.addRow(data);
						size++;
					}
					if (size == 0) {
						JOptionPane.showMessageDialog(table_1, "Kh??ng c?? d??? li???u");
					}
					table_1.setModel(tableModel);
					table_1.getColumnModel().getColumn(0).setWidth(0);
					table_1.getColumnModel().getColumn(0).setMinWidth(0);
					table_1.getColumnModel().getColumn(0).setMaxWidth(0);
					table_1.setDefaultEditor(Object.class, null);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		menu_sua_loai_phong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(5);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select * from loaiphong;");
					ResultSet rs = stt.executeQuery();

					String[] columnNames = { "M?? lo???i", "????n gi??" };
					DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaLoai = rs.getString("MaLoai");

						Float DonGia = rs.getFloat("DonGia");

						// create a single array of one row's worth of data
						String[] data = { MaLoai, DonGia.toString() };

						// and add this row of data into the table model
						tableModel.addRow(data);
						size++;
					}
					if (size == 0) {
						JOptionPane.showMessageDialog(table_1, "Kh??ng c?? d??? li???u");
					}
					table_5.setModel(tableModel);

					table_5.setDefaultEditor(Object.class, null);
					conn.close();
				} catch (SQLException sql) {
					sql.printStackTrace();
				}

			}
		});
		btn_export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XWPFDocument document = new XWPFDocument();

				XWPFParagraph header = document.createParagraph();
				header.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun run_for_header = header.createRun();
				run_for_header.setFontSize(28);
				run_for_header.setText("Kh??ch s???n ABC");
				run_for_header.addBreak();
				run_for_header.setText("H??a ????n gi?? tr??? gia t??ng");
				run_for_header.addBreak();
				String MaHD = (String) table_3.getValueAt(table_3.getSelectedRow(), 0);
				run_for_header.setText("M?? h??a ????n: " + MaHD);

				String MaPhong = (String) table_3.getValueAt(table_3.getSelectedRow(), 1);
				String MaKhach = (String) table_3.getValueAt(table_3.getSelectedRow(), 2);
				String MaLoai = (String) table_3.getValueAt(table_3.getSelectedRow(), 3);
				String DonGia = (String) table_3.getValueAt(table_3.getSelectedRow(), 4);
				String Thue = (String) table_3.getValueAt(table_3.getSelectedRow(), 5);
				String Tra = (String) table_3.getValueAt(table_3.getSelectedRow(), 6);
				String Ngay = (String) table_3.getValueAt(table_3.getSelectedRow(), 7);
				String Tien = (String) table_3.getValueAt(table_3.getSelectedRow(), 8);
				// Create new Paragraph

				XWPFParagraph content = document.createParagraph();
				XWPFRun run_for_content = content.createRun();
				run_for_content.setFontSize(18);
				run_for_content.setText("M?? ph??ng: "+MaPhong);
				run_for_content.addBreak();
				run_for_content.setText("M?? kh??ch: "+MaKhach);
				run_for_content.addBreak();
				run_for_content.setText("M?? lo???i: "+MaLoai);
				run_for_content.addBreak();
				run_for_content.setText("????n gi??: "+DonGia);
				run_for_content.addBreak();
				run_for_content.setText("Ng??y thu??: "+Thue);
				run_for_content.addBreak();
				run_for_content.setText("Ng??y tr???: "+Tra);
				run_for_content.addBreak();
				run_for_content.setText("S??? ng??y: "+Ngay);
				run_for_content.addBreak();
				run_for_content.setText("-------------------------------------------------");
				run_for_content.addBreak();
				run_for_content.setText("T???ng ti???n: "+Tien);
				run_for_content.addBreak();
				
				XWPFParagraph footer = document.createParagraph();
				XWPFRun run_for_footer = footer.createRun();
				run_for_footer.addBreak();
				run_for_footer.setFontSize(22);
				run_for_footer.setText("Ch??? k?? l??? t??n");
				run_for_footer.addTab();
				run_for_footer.addTab();
				run_for_footer.addTab();
				run_for_footer.addTab();
				run_for_footer.setText("Ch??? k?? kh??ch thu??");
				
			
				
				// Write the Document in file system
				try {
					FileOutputStream out = new FileOutputStream(
							new File(Thue + "_" + Tra + "_" + MaHD + "_" + MaPhong + ".docx"));
					document.write(out);
					out.close();
					document.close();
					JOptionPane.showMessageDialog(table_3, "Xu???t h??a ????n th??nh c??ng");
				} catch (IOException ex) {

				}
			}
		});
	}
}
