package Project1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class transfer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid1;
	private JTextField txtid2;
	private JTextField txtamt;
	JLabel confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfer frame = new transfer();
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
	public transfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel_1.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi sb=new Sbi();
				sb.setVisible(true);
				dispose();
			}
			});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1061, 40, 89, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Sbi1 sb=new Sbi1();
        		sb.setVisible(true);
        		dispose();
        	}
        });
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(962, 40, 89, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Account Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(449, 129, 130, 40);
		contentPane.add(lblNewLabel);
		
		txtid1 = new JTextField();
		txtid1.setBounds(612, 129, 177, 40);
		contentPane.add(txtid1);
		txtid1.setColumns(10);
		
		JLabel lblAcountId = new JLabel("Account Id:");
		lblAcountId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcountId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAcountId.setBounds(449, 246, 130, 40);
		contentPane.add(lblAcountId);
		
		txtid2 = new JTextField();
		txtid2.setColumns(10);
		txtid2.setBounds(612, 246, 177, 40);
		contentPane.add(txtid2);
		
		JLabel lblNewLabel_2 = new JLabel("*Enter your accound Id");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(632, 180, 157, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*Enter account id in which ");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(632, 297, 157, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("you want deposit money");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setBounds(632, 315, 157, 19);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblAcountId_1 = new JLabel("Amount:");
		lblAcountId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcountId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAcountId_1.setBounds(449, 363, 130, 40);
		contentPane.add(lblAcountId_1);
		
		txtamt = new JTextField();
		txtamt.setColumns(10);
		txtamt.setBounds(612, 363, 177, 40);
		contentPane.add(txtamt);
		
		JButton btndeb = new JButton("Deposit");
		btndeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1=txtid1.getText();
				String id2=txtid2.getText();
				String amt=txtamt.getText();
				
				try
				{
					if(id1.isEmpty() || id2.isEmpty() || amt.isEmpty())
					{
						JOptionPane.showMessageDialog(btndeb, "Enter Required Fields");
					}
					else if(Sbi.name.equals(id1))
				{
					
					Database ds=new Database();
					ResultSet rs=ds.readAll(id2);
					if(rs.next())
					{
						
						ds.transfer(amt,id1);
						ds.deposit(id2, amt);
						java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
						String type="Transfer to"+id2;
		        		ds.history(id1,type,date,amt);
		        		String type1="Receive from"+id1;
		        		ds.history(id2,type1,date,amt);
		        		confirm.setText("Amount transfer succefully!!!");
					}
					else
					{
						JOptionPane.showMessageDialog(btndeb, "Transfer Account Id Not Found!!!!");
					}
				}
					else
					{
							JOptionPane.showMessageDialog(btndeb, "Wrong User Accound Id!!!!");
							txtid1.setText("");txtid2.setText("");txtamt.setText("");
							
						
					}
				}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btndeb.setFont(new Font("Tahoma", Font.BOLD, 15));
		btndeb.setBounds(560, 440, 99, 30);
		contentPane.add(btndeb);
		
		 confirm = new JLabel("");
		confirm.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirm.setHorizontalAlignment(SwingConstants.CENTER);
		confirm.setBounds(336, 513, 671, 46);
		contentPane.add(confirm);
	}
}
