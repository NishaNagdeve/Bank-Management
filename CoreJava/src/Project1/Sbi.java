package Project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import com.swingDemo.CreateAccc;

import javax.swing.border.EtchedBorder;

public class Sbi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txte;
	public JTextField txtId;
	private JPasswordField txtp;
	static String name,f1,f2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sbi frame = new Sbi();
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
	public Sbi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl0 = new JLabel("Login ");
		lbl0.setForeground(new Color(0, 0, 205));
		lbl0.setBackground(new Color(255, 0, 128));
		lbl0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl0.setFont(new Font("Tahoma", Font.BOLD, 32));
		lbl0.setBounds(500, 54, 250, 65);
		contentPane.add(lbl0);
		
		JLabel lblUser = new JLabel("Account Id:");
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblUser.setBounds(300, 182, 250, 40);
		contentPane.add(lblUser);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblEmail.setBounds(266, 277, 250, 40);
		contentPane.add(lblEmail);
		
		JLabel lblPass = new JLabel("Password : ");
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPass.setBounds(300, 366, 250, 40);
		contentPane.add(lblPass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name=txtId.getText();
				String pass=txtp.getText();
				String email=txte.getText();
				Database d=new Database();
				d.getConnection();
				ResultSet rs=d.readData(email);
				int flag = 0;
				String tempId = null, tempPass = null,tempemail=null,tempUser=null;
				try
				{
					
					while(rs.next())
					{
						flag = 1;
						tempId= rs.getString(7);
						tempPass = rs.getString(2);
						tempemail= rs.getString(3);
						tempUser=rs.getString(1);
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				if(flag == 1)
				{
					
					if (name.equals(tempId) && pass.equals(tempPass) && email.equals(tempemail)) {
					
						JOptionPane.showMessageDialog(btnLogin, "Login Succesfull");
						Sbi1 s=new Sbi1();
						s.setVisible(true);
						s.username.setText(tempUser);
						dispose();
					}
				else
				{
					JOptionPane.showMessageDialog(btnLogin, "Login Unsuccesfull");
				}
				}
				else
				{
					JOptionPane.showMessageDialog(btnLogin, "Enter Valid Details");
				}
			}
		});

		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogin.setBounds(300, 526, 250, 40);
		contentPane.add(btnLogin);
		
		JButton btnReg = new JButton("Register");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi3 s3=new Sbi3();
				s3.setVisible(true);
				dispose();
				
			}
		});
		btnReg.setForeground(new Color(0, 0, 0));
		btnReg.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnReg.setBounds(700, 526, 250, 40);
		contentPane.add(btnReg);
		
		txte = new JTextField();
		txte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txte.setColumns(10);
		txte.setBounds(700, 277, 250, 40);
		contentPane.add(txte);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(255, 255, 255));
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setColumns(10);
		txtId.setBounds(700, 182, 250, 40);
		contentPane.add(txtId);
		
		txtp = new JPasswordField();
		txtp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtp.setBounds(700, 366, 250, 40);
		contentPane.add(txtp);
		
		JLabel lblNewLabel = new JLabel("Welcome to iBanking");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(354, 651, 524, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel_1.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Forgot Account Id? OR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(289, 577, 167, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Forgot Password");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(453, 577, 152, 25);
		contentPane.add(lblNewLabel_2_1);
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
            
			 public void mouseClicked(MouseEvent e) {
	                sbi4 sb=new sbi4();
	                f1="ID";
	                sb.setVisible(true);
	                dispose();
	            }
        });
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
            
			 public void mouseClicked(MouseEvent e) {
	                sbi4 sb=new sbi4();
	                f1="Password";
	                sb.setVisible(true);
	                dispose();
	            }
       });
		
		
	}
}