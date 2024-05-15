package Project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class details extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details frame = new details();
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
	public details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(437, 72, 159, 31);
		contentPane.add(lblNewLabel);
		
		txtIdd = new JTextField();
		txtIdd.setBounds(628, 72, 147, 31);
		contentPane.add(txtIdd);
		txtIdd.setColumns(10);
		
		JLabel lbltittle = new JLabel("");
		lbltittle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltittle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltittle.setBounds(516, 147, 356, 31);
		contentPane.add(lbltittle);
		
		JLabel lbln = new JLabel("");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setBounds(437, 232, 230, 31);
		contentPane.add(lbln);
		
		JLabel lbln1 = new JLabel("");
		lbln1.setHorizontalAlignment(SwingConstants.CENTER);
		lbln1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbln1.setBounds(720, 232, 140, 31);
		contentPane.add(lbln1);
		
		JLabel lbli = new JLabel("");
		lbli.setHorizontalAlignment(SwingConstants.CENTER);
		lbli.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbli.setBounds(527, 300, 140, 31);
		contentPane.add(lbli);
		
		JLabel lbli1 = new JLabel("");
		lbli1.setHorizontalAlignment(SwingConstants.CENTER);
		lbli1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbli1.setBounds(720, 300, 140, 31);
		contentPane.add(lbli1);
		
		JLabel lblacc = new JLabel("");
		lblacc.setHorizontalAlignment(SwingConstants.CENTER);
		lblacc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblacc.setBounds(527, 368, 140, 31);
		contentPane.add(lblacc);
		
		JLabel lblacc1 = new JLabel("");
		lblacc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblacc1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblacc1.setBounds(720, 368, 140, 31);
		contentPane.add(lblacc1);
		
		JLabel lbltype = new JLabel("");
		lbltype.setHorizontalAlignment(SwingConstants.CENTER);
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltype.setBounds(527, 436, 140, 31);
		contentPane.add(lbltype);
		
		JLabel lbltype1 = new JLabel("");
		lbltype1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltype1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltype1.setBounds(720, 436, 140, 31);
		contentPane.add(lbltype1);
		
		JLabel lblifsc = new JLabel("");
		lblifsc.setHorizontalAlignment(SwingConstants.CENTER);
		lblifsc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifsc.setBounds(527, 504, 140, 31);
		contentPane.add(lblifsc);
		
		JLabel lblifsc1 = new JLabel("");
		lblifsc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblifsc1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifsc1.setBounds(720, 504, 140, 31);
		contentPane.add(lblifsc1);
		
		JLabel lbldate = new JLabel("");
		lbldate.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldate.setBounds(437, 572, 230, 31);
		contentPane.add(lbldate);
		
		JLabel lbldate1 = new JLabel("");
		lbldate1.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldate1.setBounds(720, 572, 140, 31);
		contentPane.add(lbldate1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel_1.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel_1);
		
		JButton btnsubmt = new JButton("Submit");
		btnsubmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=txtIdd.getText();
				Database ds=new Database();
				ResultSet rs=ds.readAll(id);
				String tname=null,tid=null,tacc=null,ttype=null,tifsc=null,tbranch=null;
				Timestamp tdate=null;
				
				try
				{
					if(rs.next())
					{
						
                		if(Sbi.name.equals(id))
   					   {
						tname=rs.getString(1);
						tid=rs.getString(7);
						tacc=rs.getString(8);
						ttype=rs.getString(9);
						tifsc=rs.getString(10);
						tdate=rs.getTimestamp(15);
                         if(tacc==null && tifsc==null)
                         {
                        	 JOptionPane.showMessageDialog(btnsubmt, "Don't Have an Account Create New Account");
                         }
                         else
                         {
						lbltittle.setText("ACCOUNT HOLDER DETAILS:");
						lbln.setText("ACCOUNT HOLDER NAME:");
						lbln1.setText(tname);
						lbli1.setText(tid);lbli.setText("ACCOUNT ID:");
						lblacc1.setText(tacc);lblacc.setText("ACCOUNT NUMBER:");
						lbltype1.setText(ttype);lbltype.setText("ACCOUNT TYPE:");
						lblifsc1.setText(tifsc);lblifsc.setText("IFSC CODE:");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		                String formattedDate = sdf.format(tdate);
		                lbldate1.setText(formattedDate); lbldate.setText("ACCOUNT CREATED DATE:");
                         }
					    }
						else
						{
							JOptionPane.showMessageDialog(btnsubmt, "Wrong Account Id!!!!");
							
						}
					}
					else
					{
						 JOptionPane.showMessageDialog(btnsubmt, "Account not found!");
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnsubmt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsubmt.setBounds(803, 72, 89, 31);
		contentPane.add(btnsubmt);
		
		JButton btnhome = new JButton("Logout");
		btnhome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi1 sb=new Sbi1();
				sb.setVisible(true);
				dispose();
			}
		});
		btnhome.setBounds(1063, 40, 89, 30);
		contentPane.add(btnhome);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi1 sb=new Sbi1();
				sb.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome.setBounds(964, 40, 89, 30);
		contentPane.add(btnHome);
		
		
	}
}
