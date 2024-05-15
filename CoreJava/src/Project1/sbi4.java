package Project1;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class sbi4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sbi4 frame = new sbi4();
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
	public sbi4() {
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
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(440, 130, 130, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(457, 384, 415, 39);
		contentPane.add(lbl1);
		
		Name = new JTextField();
		Name.setBounds(580, 130, 264, 39);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblGovid = new JLabel("GOV.ID:");
		lblGovid.setHorizontalAlignment(SwingConstants.CENTER);
		lblGovid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGovid.setBounds(440, 207, 130, 39);
		contentPane.add(lblGovid);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(580, 207, 264, 39);
		contentPane.add(id);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=Name.getText();
				String Id=id.getText();
				Database ds=new Database();
				ResultSet rs=ds.forgot(Id);
				String tname=null,tid=null;
                
				try
				{
					if(name.isEmpty()|| Id.isEmpty())
        			{
        				JOptionPane.showMessageDialog(btnNewButton, "Enter Required Fields");
        			}
					else if(rs.next())
					{
						tname=rs.getString(1);
						tid=rs.getString(6);
						String ac=rs.getString(7);
						String pass=rs.getString(2);
						Sbi sb=new Sbi();
						
						if(sb.f1=="ID")
						{
						if(tname.equalsIgnoreCase(name) && tid.equals(Id) )
						{
							
							lbl1.setText("Your Account Id is "+ac);
							Name.setText("");
							id.setText("");
							
						}
						else
						{
							lbl1.setText("Invalid Information ");
							Name.setText("");
							id.setText("");
							
						}
						}
						else
						{
							if(tname.equalsIgnoreCase(name) && tid.equals(Id) )
							{
								
								lbl1.setText("Your Password is "+pass);
								Name.setText("");
								id.setText("");
								
							}
							else
							{
								lbl1.setText("Invalid Information ");
								Name.setText("");
								id.setText("");
								
							}
						}
							
					}
					else
					{
						lbl1.setText("Account Not Found!!!! ");
						Name.setText("");
						id.setText("");
					}
				}
				
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(524, 298, 105, 39);
		contentPane.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi sb=new Sbi();
				sb.setVisible(true);
				dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(687, 298, 105, 39);
		contentPane.add(btnLogin);
		
		
	}
}
