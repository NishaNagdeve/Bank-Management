package Project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class Balance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField num;
	JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance frame = new Balance();
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
	public Balance() {
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
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi1 sb=new Sbi1();
				sb.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome.setBounds(945, 40, 89, 30);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("Account Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(369, 135, 195, 34);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBounds(602, 141, 233, 31);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountNumber.setForeground(Color.BLACK);
		lblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAccountNumber.setBounds(369, 220, 195, 34);
		contentPane.add(lblAccountNumber);
		
		num = new JTextField();
		num.setFont(new Font("Tahoma", Font.PLAIN, 15));
		num.setColumns(10);
		num.setBounds(602, 220, 233, 31);
		contentPane.add(num);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id1=id.getText();
        		String num1=num.getText();
        		Database ds=new Database();
        		ResultSet rs=ds.readAll(id1);
        		
        		try
        		{
        			String acc=null;
        			if(rs.next())
        			{
        				 acc=rs.getString(8);
        			
        			
        			if(id1.isEmpty()|| num1.isEmpty())
        			{
        				JOptionPane.showMessageDialog(btnNewButton_1, "Enter Required Fields");
        				id.setText("");
                  		 num.setText("");
        			}
        			int flag=0;
        			if(Sbi.name.equals(id1))
        			{
        				flag=1;
        			}
        			else
        			{
        				lblNewLabel_2.setText("Wrong Account Id!!!");
        			}
        			
        			int temp=0;
        			if(acc != null && acc.equals(num1))
        			{
        				temp=1;
        			}
        			else
        			{
        				lblNewLabel_2.setText("Wrong Account Number!!!");
        				id.setText("");
                  		 num.setText("");
        			}
        			if(acc==null)
        			{
        				lblNewLabel_2.setText("Account Not found...Create New Account :)");
        				id.setText("");
                  		 num.setText("");
        			}
        			if(flag==1 && temp==1)
        			{
        				
       				 lblNewLabel_2.setText("Your Balance is "+rs.getString(11));
               		 id.setText("");
               		 num.setText("");
        			}
        		}
        		}
        		catch(Exception ex)
        		{
        			ex.printStackTrace();
        		}
        		
        	}
        });
			
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(538, 318, 109, 30);
		contentPane.add(btnNewButton_1);
		
		 lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(423, 429, 390, 30);
		contentPane.add(lblNewLabel_2);
		
		
		
		

		
		
		
	}
}
