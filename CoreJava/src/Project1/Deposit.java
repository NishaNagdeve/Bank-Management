package Project1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.swingDemo.CreateAccc;

import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Deposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel username= new JLabel("");
	private JTextField txtId;
	private JTextField txtAcc;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
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
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sbi sb=new Sbi();
					sb.setVisible(true);
					dispose();
				}
				});
		btnNewButton_1.setBounds(1235, 40, 89, 30);
		contentPane.add(btnNewButton_1);
		username.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	   
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(972, 40, 143, 30);
		contentPane.add(username);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBackground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(21, 44, 187, 41);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblttl = new JLabel("");
        lblttl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblttl.setHorizontalAlignment(SwingConstants.CENTER);
        lblttl.setBounds(468, 485, 446, 41);
        contentPane.add(lblttl);
        
        JButton btnNewButton_2 = new JButton("Home");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Sbi1 sb=new Sbi1();
        		sb.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_2.setBounds(1136, 40, 89, 30);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_1 = new JLabel("DEPOSIT MONEY");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(523, 126, 243, 30);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("ACCOUNT ID:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(449, 195, 190, 30);
        contentPane.add(lblNewLabel_3);
        
        txtId = new JTextField();
        txtId.setBounds(666, 197, 173, 30);
        contentPane.add(txtId);
        txtId.setColumns(10);
        
        JLabel lblNewLabel_3_1 = new JLabel("ACCOUNT NUMBER:");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(449, 259, 190, 30);
        contentPane.add(lblNewLabel_3_1);
        
        txtAcc = new JTextField();
        txtAcc.setColumns(10);
        txtAcc.setBounds(666, 261, 173, 30);
        contentPane.add(txtAcc);
        
        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id1=txtId.getText();
        		String amt=txtAmount.getText();
        		String acc=txtAcc.getText();
        		Database ds=new Database();
        		ResultSet rs=ds.readAll(id1);
        		try
        		{
        			if(id1.isEmpty()|| amt.isEmpty())
        			{
        				JOptionPane.showMessageDialog(btnDeposit, "Enter Required Fields");
        			}
        			if(rs.next())
    				{
        				String acc1=rs.getString(8);
        			  if(Sbi.name.equals(id1))
        			  {
        				if(acc1 !=null)
        				{
                		ds.deposit(id1,amt);
                		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                		String type="deposit";
                		ds.history(id1,type,date,amt);
                		lblttl.setText("AMOUNT DEPOSITED SUCCESFULLY");
                		txtId.setText("");
                		txtAmount.setText("");
                		txtAcc.setText("");
        				}
        				else
        				{
        					JOptionPane.showMessageDialog(btnDeposit, "Account Is Not Present..Create new :)");
        				}
        			  }
        			  else
      				{
        				  JOptionPane.showMessageDialog(btnDeposit,"Wrong Account Id!!!");
      				}
    				}
        				
        			}
        		catch(Exception ex)
        		{
        			ex.printStackTrace();
        		}
        		
        	}
        });
        btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDeposit.setBounds(607, 411, 135, 35);
        contentPane.add(btnDeposit);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("AMOUNT:");
        lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3_1_1.setBounds(449, 328, 190, 30);
        contentPane.add(lblNewLabel_3_1_1);
        
        txtAmount = new JTextField();
        txtAmount.setColumns(10);
        txtAmount.setBounds(666, 330, 173, 30);
        contentPane.add(txtAmount);
        
        
        
		
        
	}
}
