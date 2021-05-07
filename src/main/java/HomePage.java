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

public class HomePage extends JFrame {

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
					HomePage frame = new HomePage();
					frame.setVisible(true);
					//frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		
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
		
		JMenu mnLoaiPhong = new JMenu("Loại phòng");
		menuBar.add(mnLoaiPhong);
		
		JMenuItem menu_sua_loai_phong = new JMenuItem("Quản lý");
		
		mnLoaiPhong.add(menu_sua_loai_phong);
		
		JMenu mnKhach = new JMenu("Khách thuê");
		menuBar.add(mnKhach);
		
		JMenuItem menu_khach_thue = new JMenuItem("Xem");
	
		mnKhach.add(menu_khach_thue);
		
		JMenu mnHoaDon = new JMenu("Hóa đơn");
		menuBar.add(mnHoaDon);
		
		JMenuItem menu_hoa_don = new JMenuItem("Xem");
		
		mnHoaDon.add(menu_hoa_don);
		
		final JTabbedPane tab_content = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_2 = new JPanel();
		tab_content.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
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
		
		JButton btn_tra_phong = new JButton("Trả phòng");
		btn_tra_phong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) table_1.getValueAt(table_1.getSelectedRow(),0);
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
		
		final JButton btn_tim_kiem = new JButton("Tìm kiếm");
		
		btn_tim_kiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_tim_kiem.setBounds(419, 90, 98, 39);
		panel_1.add(btn_tim_kiem);
		
		JButton btn_clear = new JButton("X");
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btn_clear.setBounds(544, 90, 44, 39);
		panel_1.add(btn_clear);
		
		String [] items = {"Mã phòng","Loại phòng"};
		final JComboBox cbx_tim_kiem = new JComboBox(items);
		cbx_tim_kiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbx_tim_kiem.setBounds(283, 92, 112, 36);
		panel_1.add(cbx_tim_kiem);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedColumn() == 3) {
					String Maphong = (String) table.getValueAt(table.getSelectedRow(), 0);
					UpdateRoom ur = new UpdateRoom(Maphong);
					ur.setVisible(true);
				}
				if(table.getSelectedColumn() == 4) {
					String Maphong = (String) table.getValueAt(table.getSelectedRow(), 0);
					DeleteRoom dr = new DeleteRoom(Maphong);
					dr.setVisible(true);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		final JLabel lblNewLabel = new JLabel("Danh s\u00E1ch ph\u00F2ng c\u00F3 s\u1EB5n");
	
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btn_dat_phong = new JButton("Đặt phòng");
		btn_dat_phong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) table.getValueAt(table.getSelectedRow(),0);
				AddRent rent = new AddRent(s);
				rent.setVisible(true);
			}
		});
		btn_dat_phong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btn_dat_phong_1 = new JButton("Thêm phòng");
		btn_dat_phong_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRoom ar = new AddRoom();
				ar.setVisible(true);
			}
		});
		btn_dat_phong_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(183)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(154, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(265)
					.addComponent(btn_dat_phong, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(250))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btn_dat_phong_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
							.addGap(29))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel)
					.addGap(10)
					.addComponent(btn_dat_phong_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btn_dat_phong, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(33))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_3 = new JPanel();
		tab_content.addTab("New tab", null, panel_3, null);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách khách thuê");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(196)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(213))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(42)
					.addComponent(table_2, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
					.addGap(33))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(table_2, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addGap(39))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
						.addComponent(tab_content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tab_content, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
						.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenu menuTaiKhoan = new JMenu("Tài khoản");
		menuBar.add(menuTaiKhoan);
		
		JMenuItem mn_tai_khoan = new JMenuItem("Đăng xuất");
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
		
		JLabel lblNewLabel_3 = new JLabel("Danh sách hóa đơn");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(220, 24, 189, 43);
		panel_4.add(lblNewLabel_3);
		
		table_3 = new JTable();
		table_3.setBounds(40, 100, 559, 415);
		panel_4.add(table_3);
		
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
					PreparedStatement stt = conn.prepareStatement("select MaPhong, p.MaLoai , DonGia from phong p join loaiphong l on p.MaLoai = l.MaLoai where TinhTrang = 0;");
					ResultSet rs = stt.executeQuery();
					
					String[] columnNames = {"MaPhong", "MaLoai", "DonGia","",""};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
					tableModel.addRow(columnNames);
					
					while (rs.next()) {
						String MaPhong = rs.getString("MaPhong");
					    String MaLoai = rs.getString("p.MaLoai");
					    Float DonGia = rs.getFloat("DonGia");

					    // create a single array of one row's worth of data
					    String[] data = { MaPhong, MaLoai, DonGia.toString(),"Cập nhật","Xóa" } ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					}
					table.setModel(tableModel);
					table.getColumnModel().getColumn(3).setMaxWidth(80);
					table.getColumnModel().getColumn(4).setMaxWidth(40);
					
					
					table.setDefaultEditor(Object.class, null);
					table.changeSelection(1, 0, false, false);
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
				
			}
		});
		menu_phong_cho_thue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(2);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n" + 
							"join loaiphong l on p.MaLoai = l.MaLoai \r\n" + 
							"join thuephong  t on p.MaPhong = t.MaPhong;");
					ResultSet rs = stt.executeQuery();
					
					String[] columnNames = {"","MaPhong", "MaLoai","MaKhach","DonGia","NgayThue","NgayTra"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
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
					    String[] data = {MaPhieu, MaPhong, MaLoai,MaKhach, DonGia.toString(),NgayThue.toString(),NgayTra.toString()} ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					    size++;
					}
					if(size == 0) {
						JOptionPane.showMessageDialog(table_1,"Không có dữ liệu");
					}
					table_1.setModel(tableModel);
					table_1.getColumnModel().getColumn(0).setWidth(0);
					table_1.getColumnModel().getColumn(0).setMinWidth(0);
					table_1.getColumnModel().getColumn(0).setMaxWidth(0);
					table_1.setDefaultEditor(Object.class, null);
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
				
			}
		});
		btn_tim_kiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n" + 
							"join loaiphong l on p.MaLoai = l.MaLoai \r\n" + 
							"join thuephong  t on p.MaPhong = t.MaPhong;");
					if(cbx_tim_kiem.getSelectedIndex() == 0) {
						stt = conn.prepareStatement("select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n" + 
								"join loaiphong l on p.MaLoai = l.MaLoai \r\n" + 
								"join thuephong  t on p.MaPhong = t.MaPhong "
								+ "where t.MaPhong = ?");
						stt.setInt(1, Integer.parseInt(txt_tim_kiem.getText()));
					}
					else if(cbx_tim_kiem.getSelectedIndex() == 1) {
						stt = conn.prepareStatement("select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n" + 
								"join loaiphong l on p.MaLoai = l.MaLoai \r\n" + 
								"join thuephong  t on p.MaPhong = t.MaPhong "
								+ "where p.MaLoai = ?");
						stt.setInt(1, Integer.parseInt(txt_tim_kiem.getText()));
					}
					ResultSet rs = stt.executeQuery();
				
					String[] columnNames = {"","MaPhong", "MaLoai","MaKhach","DonGia","NgayThue","NgayTra"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
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
					    String[] data = {MaPhieu, MaPhong, MaLoai,MaKhach, DonGia.toString(),NgayThue.toString(),NgayTra.toString()} ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					    size++;
					}
					if(size == 0) {
						JOptionPane.showMessageDialog(table_1,"Không tìm thấy thông tin");
					}
					table_1.setModel(tableModel);
					table_1.getColumnModel().getColumn(0).setWidth(0);
					table_1.getColumnModel().getColumn(0).setMinWidth(0);
					table_1.getColumnModel().getColumn(0).setMaxWidth(0);
					table_1.setDefaultEditor(Object.class, null);
					conn.close();
				}catch(SQLException sql) {
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
					
					String[] columnNames = {"MaKhach", "SoCMT", "Ten","NamSinh","SDT"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
					    String MaKhach = rs.getString("MaKhach");
					    String SoCMT = rs.getString("SoCMT");
					    String Ten = rs.getString("Ten");
					    Integer NamSinh = rs.getInt("NamSinh");
					    String Sdt = rs.getString("SDT");

					    // create a single array of one row's worth of data
					    String[] data = { MaKhach,SoCMT,Ten,NamSinh.toString(),Sdt} ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					    size++;
					}
					if(size == 0) {
						JOptionPane.showMessageDialog(table_2,"Không có dữ liệu");
					}
					table_2.setModel(tableModel);
					table_2.setDefaultEditor(Object.class, null);
					conn.close();
				}catch(SQLException sql) {
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
					
					String[] columnNames = {"Hóa đơn", "Mã phòng", "Mã khách","Mã loại","Đơn giá","Ngày thuê","Ngày trả","Số ngày","Tổng tiền"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
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
					    String[] data = {MaHD,MaPhong,MaKhach,MaLoai,DonGia.toString(),Thue.toString(),Tra.toString(),Ngay.toString(),Tien.toString()} ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					    size++;
					}
					if(size == 0) {
						JOptionPane.showMessageDialog(table_3,"Không có dữ liệu");
					}
					table_3.setModel(tableModel);
					table_3.setDefaultEditor(Object.class, null);
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
		});
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_content.setSelectedIndex(2);
				try {
					Connection conn = DBConnectioner.getConnection();
					PreparedStatement stt = conn.prepareStatement("select t.MaPhieu ,p.MaPhong, p.MaLoai,t.MaKhach , DonGia , t.NgayThue , t.NgayTra from phong p \r\n" + 
							"join loaiphong l on p.MaLoai = l.MaLoai \r\n" + 
							"join thuephong  t on p.MaPhong = t.MaPhong;");
					ResultSet rs = stt.executeQuery();
					
					String[] columnNames = {"","MaPhong", "MaLoai","MaKhach","DonGia","NgayThue","NgayTra"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
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
					    String[] data = {MaPhieu, MaPhong, MaLoai,MaKhach, DonGia.toString(),NgayThue.toString(),NgayTra.toString()} ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					    size++;
					}
					if(size == 0) {
						JOptionPane.showMessageDialog(table_1,"Không có dữ liệu");
					}
					table_1.setModel(tableModel);
					table_1.getColumnModel().getColumn(0).setWidth(0);
					table_1.getColumnModel().getColumn(0).setMinWidth(0);
					table_1.getColumnModel().getColumn(0).setMaxWidth(0);
					table_1.setDefaultEditor(Object.class, null);
					conn.close();
				}catch(SQLException sql) {
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
					
					String[] columnNames = {"Mã loại","Đơn giá"};
					DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
					tableModel.addRow(columnNames);
					int size = 0;
					while (rs.next()) {
						String MaLoai= rs.getString("MaLoai");
						
						
					    Float DonGia = rs.getFloat("DonGia");
					

					    // create a single array of one row's worth of data
					    String[] data = {MaLoai,DonGia.toString()} ;

					    // and add this row of data into the table model
					    tableModel.addRow(data);
					    size++;
					}
					if(size == 0) {
						JOptionPane.showMessageDialog(table_1,"Không có dữ liệu");
					}
					table_5.setModel(tableModel);
					
					table_5.setDefaultEditor(Object.class, null);
					conn.close();
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
				
			}
		});
		
	}
}
