package Project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class transhis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transhis frame = new transhis();
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
	public transhis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1500, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel);
		
		
		JLabel title = new JLabel("");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(413, 235, 598, 36);
		contentPane.add(title);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Transaction Date &Time", "Type", "Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(212);
		table.getColumnModel().getColumn(1).setPreferredWidth(219);
		table.getColumnModel().getColumn(2).setPreferredWidth(193);
		table.setBounds(330, 252, 598, 315);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(413, 294, 598, 315);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		table.setRowHeight(30);
		
		JLabel lblNewLabel_2 = new JLabel("ACCOUNT ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(425, 153, 190, 36);
		contentPane.add(lblNewLabel_2);
		
		txt = new JTextField();
		txt.setBounds(631, 153, 173, 32);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JButton btnNewButton = new JButton("Getdetails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=txt.getText();
				Database ds=new Database();
				ResultSet rs=ds.readIt(id);
				String ttype=null,tamt=null,eid=null;
				Timestamp dte=null;
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setRowCount(0); 
		            while (rs.next()) {
		                 ttype = rs.getString(3);
		                 tamt = rs.getString(2);
		                 dte = rs.getTimestamp(4);
		                 eid=rs.getString(1);
		                 model.addRow(new Object[]{dte, ttype, tamt});	
		                 
				} 
		            if(id.equals(""))
		            {
		            	JOptionPane.showMessageDialog(btnNewButton, "Enter Account Id!!!!");
		            }
		            else if(id.equals(eid))
		            {
		            	scrollPane.setVisible(true);
//		                model.addRow(new Object[]{dte, ttype, tamt});	
		                title.setText("TRANSACTION HISTORY SHOWING FOR ACCOUNT ID-"+id);
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(btnNewButton, " Account Id not found!!!!");
		            }
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(845, 153, 122, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi1 sb=new Sbi1();
				sb.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(1131, 40, 89, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi sb=new Sbi();
				sb.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(1232, 40, 89, 30);
		contentPane.add(btnNewButton_1);
		
	}
}
