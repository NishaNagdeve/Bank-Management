package Project1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Sbi1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel username= new JLabel("");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sbi1 frame = new Sbi1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.ssssss
	 */
	public Sbi1() {
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
		
		JButton btnNewButton = new JButton("ACCOUNT DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details dt=new details();
				dt.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(44, 202, 164, 45);
		contentPane.add(btnNewButton);
		
		JButton btnDepositMoney = new JButton("DEPOSIT MONEY");
		btnDepositMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit d=new Deposit();
				d.setVisible(true);
				dispose();
			}
		});
		btnDepositMoney.setBounds(44, 246, 164, 45);
		contentPane.add(btnDepositMoney);
		
		JButton btnWithdrawCash = new JButton("WITHDRAW CASH");
		btnWithdrawCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw wd=new withdraw();
				wd.setVisible(true);
				dispose();
			}
		});
		btnWithdrawCash.setBounds(44, 289, 164, 45);
		contentPane.add(btnWithdrawCash);
		
		JButton btnTransferMoney = new JButton("TRANSFER MONEY");
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transfer tr=new transfer();
				tr.setVisible(true);
				dispose();
			}
		});
		btnTransferMoney.setBounds(44, 333, 164, 45);
		contentPane.add(btnTransferMoney);
		
		JButton btnTransactionHistory = new JButton("TRANSACTION HISTORY");
		btnTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transhis th=new transhis();
				th.setVisible(true);
				dispose();
			}
		});
		btnTransactionHistory.setBounds(44, 377, 164, 45);
		contentPane.add(btnTransactionHistory);
		
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
        
        JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
        btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccc c=new CreateAccc();
				c.setVisible(true);
				dispose();
			}
			});
        btnCreateAccount.setBounds(44, 420, 164, 45);
        contentPane.add(btnCreateAccount);
        
        JButton btnNewButton_2 = new JButton("Home");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setBounds(1136, 40, 89, 30);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_3 = new JLabel("Welcome to iBanking where banking meets convenience. ");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(new Color(0, 0, 205));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_3.setBounds(239, 132, 953, 37);
        contentPane.add(lblNewLabel_3);
        
        
        JButton btnBalanceEnquiry = new JButton("BALANCE ENQUIRY");
        btnBalanceEnquiry.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Balance bal=new Balance();
        		bal.setVisible(true);
        		dispose();
        	}
        });
        btnBalanceEnquiry.setBounds(44, 462, 164, 45);
        contentPane.add(btnBalanceEnquiry);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\bank12.jpg"));
        lblNewLabel_1.setBounds(239, 202, 901, 487);
        contentPane.add(lblNewLabel_1);
        
        
	}
}
