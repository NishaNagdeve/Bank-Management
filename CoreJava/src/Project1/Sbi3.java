package Project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import com.swingDemo.CreateAccc;
import com.swingDemo.Jdbcconnect;
import com.swingDemo.scondframe;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JPasswordField;

public class Sbi3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	public JTextField txtemail;
	private JTextField txtmob;
	private JTextField txtIdno;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sbi3 frame = new Sbi3();
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
	public Sbi3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(547, 76, 244, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblname = new JLabel("Name:");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		lblname.setBounds(454, 174, 111, 38);
		contentPane.add(lblname);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblemail.setBounds(454, 242, 111, 38);
		contentPane.add(lblemail);
		
		JLabel lblmob = new JLabel("Mobile:");
		lblmob.setHorizontalAlignment(SwingConstants.CENTER);
		lblmob.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblmob.setBounds(454, 304, 111, 38);
		contentPane.add(lblmob);
		
		JLabel lblgov = new JLabel("Government Id:");
		lblgov.setHorizontalAlignment(SwingConstants.CENTER);
		lblgov.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblgov.setBounds(369, 363, 192, 38);
		contentPane.add(lblgov);
		
		txtname = new JTextField();
		txtname.setBounds(576, 181, 269, 26);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(576, 242, 269, 26);
		contentPane.add(txtemail);
		
		txtmob = new JTextField();
		txtmob.setColumns(10);
		txtmob.setBounds(575, 304, 269, 26);
		contentPane.add(txtmob);
		
		JComboBox govcombo = new JComboBox();
		govcombo.setFont(new Font("Tahoma", Font.BOLD, 15));
		govcombo.setModel(new DefaultComboBoxModel(new String[] {"Select ", "Aadhar Card", "Pan Card", "Passport", "Voting Card"}));
		govcombo.setBounds(576, 367, 269, 34);
		contentPane.add(govcombo);
		
		JLabel lblidno = new JLabel("Id no:");
		lblidno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblidno.setHorizontalAlignment(SwingConstants.CENTER);
		lblidno.setBounds(454, 425, 114, 33);
		contentPane.add(lblidno);
		JLabel lblacid = new JLabel("");
		lblacid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblacid.setHorizontalAlignment(SwingConstants.CENTER);
		lblacid.setBounds(547, 643, 352, 26);
		contentPane.add(lblacid);
		
		
		JButton btncreate = new JButton("Create Account");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = txtname.getText();
				String email = txtemail.getText();
				String mob=txtmob.getText();
				String Id=txtIdno.getText();
				String pass = txtpass.getText();
				String gov=govcombo.getSelectedItem().toString();
				
				Database dbobj = new Database();
//				dbobj.insertDataUser(user, email, mob, pass,Id,gov);
						int eFlag = 0;
						if(email.contains("@gmail.com"))
						{
							eFlag = 1;
						}
						else
						{
							JOptionPane.showMessageDialog(btncreate, "Please enter valid email address");
							 txtemail.setText("");
						}
						
						int mFlag = 0;
						
						if(mob.length() == 10)
						{
							mFlag = 1;
						}
						else
						{
							JOptionPane.showMessageDialog(btncreate, "Please enter 10 digit mobile number");
							 txtmob.setText("");
						}
						int iflag=0;
						if(gov.equals("Aadhar Card"))
						{
							
							if(Id.length() ==12)
							{
								iflag=1;
							}
							else
							{
								JOptionPane.showMessageDialog(btncreate, "Please enter 12 digit Aadhar number");
								txtIdno.setText("");
							}
						}
						else if(gov.equals("Pan Card"))
						{
							
							if(Id.length() ==10)
							{
								iflag=1;
							}
							else
							{
								JOptionPane.showMessageDialog(btncreate, "Please enter 12 digit Pan number");
								txtIdno.setText("");
							}
						}
						else if(gov.equals("Passport"))
						{
							
							if(Id.length() ==10)
							{
								iflag=1;
							}
							else
							{
								JOptionPane.showMessageDialog(btncreate, "Please enter 14 digit Passport number");
								txtIdno.setText("");
							}
						}
						else if(gov.equals("Voting Card"))
						{
							
							if(Id.length() ==10)
							{
								iflag=1;
							}
							else
							{
								JOptionPane.showMessageDialog(btncreate, "Please enter 15 digit Voting number");
								txtIdno.setText("");
							}
						}
						
						int pFlag = 0;
						int uCnt = 0, lCnt = 0, dCnt = 0, sCnt = 0;
						if(pass.length() >= 6 && pass.length() <= 9)
						{
							int len = pass.length();
							for(int i = 0; i < len; i++)
							{
								if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')
								{
									uCnt++;
								}
								else if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z')
								{
									lCnt++;
								}
								
								else if(pass.charAt(i) >= '0' && pass.charAt(i) <= '9')
								{
									dCnt++;
								}
								else if((pass.charAt(i) >= 33 && pass.charAt(i) <= 47) || (pass.charAt(i) >= 58 && pass.charAt(i) <= 64))
								{
									sCnt++;
								}
							}
							
							if(uCnt >= 1)
							{
								if(lCnt >= 1)
								{
									if(dCnt >= 1)
									{
										if(sCnt >= 1)
										{
											pFlag = 1;
										}
										else
										{
											JOptionPane.showMessageDialog(btncreate, "Please enter atleast one special character");
											txtpass.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(btncreate, "Please enter atleast one number");
										txtpass.setText("");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(btncreate, "Please enter atleast one lowercase letter");
									txtpass.setText("");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(btncreate, "Please enter atleast one uppercase letter");
								txtpass.setText("");
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(btncreate, "please enter password in range of 6 to 9 character");
							txtpass.setText("");
						}
						if(eFlag == 1 && mFlag == 1 && pFlag == 1 && iflag==1)
						{
							Database obj = new Database();
							int res = obj.insertDataUser(user, email, mob, pass, Id,gov);
							
							if(res == 1)
							{
								dbobj.insertDataUser(user, email, mob, pass,Id,gov);
								JOptionPane.showMessageDialog(btncreate, "Registration succesfull!!!");	
								Random random=new Random();
								int num=random.nextInt(900) + 100;
								String num1=Integer.toString(num);
								obj.updateId(num1,email);
								JOptionPane.showMessageDialog(btncreate,"Your Accounnt Id has been Generated"+" "+num1);
								Sbi s1=new Sbi();
								s1.setVisible(true);
								dispose();
								
							}
							else
							{
								JOptionPane.showMessageDialog(btncreate, "Registration unsuccesfull!!!");
								
							}
						}
						
			}
		});
		btncreate.setBackground(new Color(34, 139, 34));
		btncreate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btncreate.setBounds(505, 570, 156, 38);
		contentPane.add(btncreate);
		
		JButton btnReset = new JButton("Login");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi sb=new Sbi();
				sb.setVisible(true);
				dispose();
			 }
			});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(new Color(255, 0, 0));
		btnReset.setBounds(726, 570, 156, 38);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel_3.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPass = new JLabel("Password:");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPass.setBounds(422, 494, 117, 38);
		contentPane.add(lblPass);
		
		txtIdno = new JTextField();
		txtIdno.setColumns(10);
		txtIdno.setBounds(576, 432, 269, 26);
		contentPane.add(txtIdno);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(576, 504, 269, 26);
		contentPane.add(txtpass);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
