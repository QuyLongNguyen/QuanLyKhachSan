import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import java.awt.Font;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;
import java.util.Date;


import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddRent extends JFrame{

	private JTextField txt_ten_khach;
	private JTextField txt_socmt;
	private JTextField txt_sdt;
	private JTextField txt_ma_khach;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AddRent frame = new AddRent("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AddRent(String MaPhong) {
		
		
		setTitle("Phi\u1EBFu thu\u00EA ph\u00F2ng");
		setBounds(400, 100, 549, 685);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Phi\u1EBFu thu\u00EA ph\u00F2ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn kh\u00E1ch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("S\u1ED1 CMT");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("N\u0103m sinh");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_3 = new JLabel("Ng\u00E0y thu\u00EA");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("SDT");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Ng\u00E0y tr\u1EA3");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txt_ten_khach = new JTextField();
		txt_ten_khach.setColumns(10);
		
		txt_socmt = new JTextField();
		txt_socmt.setColumns(10);
		
		JCalendar x = new JCalendar();

		
		
		 final JComboBox cbx_nam_sinh = new JComboBox();
		 Calendar now = Calendar.getInstance();   
	        int year = now.get(Calendar.YEAR)-18;  
	        Vector v=new Vector();
	        for (int i = year-100; i <= year; i++) {
	            v.add(i);
	        }
	        cbx_nam_sinh.setModel(new DefaultComboBoxModel(v));
	        cbx_nam_sinh.setSelectedItem(year);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);

		
		final JDateChooser txt_ngay_thue = new JDateChooser();
		txt_ngay_thue.setLocale(new Locale("vi", "VN"));
		txt_ngay_thue.getJCalendar().setPreferredSize(new Dimension(260, 150));
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txt_ngay_thue.getDateEditor();
		editor.setEditable(false);
		
		final JDateChooser txt_ngay_tra = new JDateChooser();
		txt_ngay_tra.setLocale(new Locale("vi", "VN"));
		txt_ngay_tra.getJCalendar().setPreferredSize(new Dimension(260, 150));
		JTextFieldDateEditor editor_1 = (JTextFieldDateEditor) txt_ngay_tra.getDateEditor();
		editor_1.setEditable(false);
		
		JLabel lblNewLabel_1_4 = new JLabel("M\u00E3 ph\u00F2ng");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		Date date = new Date(); 
		txt_ngay_thue.setDate(date);
		now.add(Calendar.DATE,+3);
		date = now.getTime();
		txt_ngay_tra.setDate(date);
		now.add(Calendar.DATE,-3);
		
		final JLabel txt_ma_phong = new JLabel("");
		txt_ma_phong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ma_phong.setText(MaPhong);
		
		txt_ma_khach = new JTextField();
		txt_ma_khach.setColumns(10);
		txt_ma_khach.setEditable(false);
		
		final JCheckBox check_customer = new JCheckBox("Khách cũ");
		check_customer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check_customer.isSelected()) {
					txt_ten_khach.setEditable(false);
					txt_socmt.setEditable(false);
					txt_sdt.setEditable(false);
					txt_ma_khach.setEditable(true);
				}
				else {
					txt_ten_khach.setEditable(true);
					txt_socmt.setEditable(true);
					txt_sdt.setEditable(true);
					txt_ma_khach.setEditable(false);
				}
			}
		});
		check_customer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_5 = new JLabel("Mã khách");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_ten_khach.getText().equals("") || txt_socmt.getText().equals("")  || txt_sdt.getText().equals("") ) {
					JOptionPane.showMessageDialog(txt_ten_khach,"Không được để trống");
				}
				else {
				try {
					
				Connection conn = DBConnectioner.getConnection();
				
				PreparedStatement stt;
				int MaKhach = 0;
				if(!check_customer.isSelected()) {
				stt = conn.prepareStatement("insert into khachthue(ten,socmt,namsinh,sdt) value(?,?,?,?)");
				
				stt.setString(1,txt_ten_khach.getText());
				stt.setString(2,txt_socmt.getText());
				stt.setInt(3,(Integer)cbx_nam_sinh.getSelectedItem());
				stt.setString(4,txt_sdt.getText());
				
				int row = stt.executeUpdate();
				
				if(row != 0) {
					JOptionPane.showMessageDialog(txt_ten_khach,"Đã thêm khách thuê");
				} 
				stt = conn.prepareStatement("SELECT * FROM mytestdb.khachthue ORDER BY MaKhach DESC LIMIT 1;");
				ResultSet rs = stt.executeQuery();
				while(rs.next()) {
					MaKhach = rs.getInt("MaKhach");
					JOptionPane.showMessageDialog(txt_ten_khach, "ID cua khach la: " + MaKhach);
				}
				}
				else {
					MaKhach = Integer.parseInt(txt_ma_khach.getText());
				}
				
				stt = conn.prepareStatement("insert into thuephong(Maphong,makhach,ngaythue,ngaytra) value(?,?,?,?);");
				java.sql.Date sql_ngay_thue = new java.sql.Date(txt_ngay_thue.getDate().getTime());
				java.sql.Date sql_ngay_tra = new java.sql.Date(txt_ngay_tra.getDate().getTime());
				stt.setInt(1,Integer.parseInt(txt_ma_phong.getText()));
				stt.setInt(2,MaKhach);
				stt.setDate(3,sql_ngay_thue);
				stt.setDate(4,sql_ngay_tra);
				
				
				int row_1 = stt.executeUpdate();
				
				if(row_1 != 0) {
					JOptionPane.showMessageDialog(txt_ten_khach,"Đã thêm phiếu thuê");
				} 
				
				
				conn.close();
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
			}	
			}
		});
		
		JButton btn_xoa = new JButton("Xóa");
	
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ten_khach.setText(null);
				txt_socmt.setText(null);
				txt_sdt.setText(null);
				txt_ngay_tra.setDate(null);
				txt_ngay_thue.setDate(null);
				cbx_nam_sinh.setSelectedItem(2000);
			}
		});
		//txt_ma_khach.setEditable(false);
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txt_ma_phong, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
											.addGap(28)
											.addComponent(check_customer, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
										.addComponent(cbx_nam_sinh, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_socmt, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_ten_khach, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txt_ngay_tra, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txt_ngay_thue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
										.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(21)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addGap(53)
											.addComponent(btn_xoa, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txt_ma_khach, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(191)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_ma_phong, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(check_customer))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_ten_khach, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_socmt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbx_nam_sinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_ma_khach, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt_ngay_thue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(txt_ngay_tra, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(8)))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_xoa, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
	}
}
