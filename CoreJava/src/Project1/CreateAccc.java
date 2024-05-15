package Project1;

import java.awt.EventQueue;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Project1.Database;
import Project1.Sbi;
import Project1.Sbi1;
import Project1.Sbi3;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class CreateAccc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblname1;
	private JTextField lblname3;
	private JTextField lblid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccc frame = new CreateAccc();
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
	public CreateAccc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLICANT DETAILS");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 135, 314, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Account type:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(108, 281, 130, 26);
		contentPane.add(lblNewLabel_1_3);
		
		lblid = new JTextField();
		lblid.setColumns(10);
		lblid.setBounds(263, 386, 205, 26);
		contentPane.add(lblid);
		
		JRadioButton rdbtn2 = new JRadioButton("Saving");
		rdbtn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtn2.setBounds(381, 283, 88, 23);
		contentPane.add(rdbtn2);
		JRadioButton rdbtn3 = new JRadioButton("Current");
		rdbtn3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtn3.setBounds(263, 283, 88, 23);
		contentPane.add(rdbtn3);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtn3);
		bg.add(rdbtn2);
		
		JButton btnBack = new JButton("Home");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sbi1 sb=new Sbi1();
				sb.setVisible(true);
				dispose();
			}
			});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(937, 40, 89, 30);
		contentPane.add(btnBack);
		
		JLabel tagt = new JLabel("");
		tagt.setFont(new Font("Tahoma", Font.BOLD, 25));
		tagt.setForeground(new Color(30, 144, 255));
		tagt.setHorizontalAlignment(SwingConstants.CENTER);
		tagt.setBounds(568, 147, 498, 35);
		contentPane.add(tagt);
		JLabel lblbranch = new JLabel("Branch:");
		lblbranch.setHorizontalAlignment(SwingConstants.CENTER);
		lblbranch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblbranch.setBounds(123, 329, 130, 26);
		contentPane.add(lblbranch);
		
		JLabel title = new JLabel("");
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(664, 205, 289, 26);
		contentPane.add(title);
		
		JLabel lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(568, 258, 199, 26);
		contentPane.add(lblName);
		
		JLabel lblaccid = new JLabel("");
		lblaccid.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccid.setBounds(568, 310, 199, 26);
		contentPane.add(lblaccid);
		
		JLabel lblaccno = new JLabel("");
		lblaccno.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccno.setBounds(568, 362, 199, 26);
		contentPane.add(lblaccno);
		
		JLabel lbltype = new JLabel("");
		lbltype.setHorizontalAlignment(SwingConstants.CENTER);
		lbltype.setBounds(568, 414, 199, 26);
		contentPane.add(lbltype);
		
		JLabel lblifsc = new JLabel("");
		lblifsc.setHorizontalAlignment(SwingConstants.CENTER);
		lblifsc.setBounds(568, 466, 199, 26);
		contentPane.add(lblifsc);
		
		 lblname1 = new JLabel("");
		 lblname1.setHorizontalAlignment(SwingConstants.CENTER);
		lblname1.setBounds(803, 258, 199, 26);
		contentPane.add(lblname1);
		
		JLabel lblaccid1 = new JLabel("");
		lblaccid1.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccid1.setBounds(803, 310, 199, 26);
		contentPane.add(lblaccid1);
		
		JLabel lblaccno1 = new JLabel("");
		lblaccno1.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccno1.setBounds(803, 362, 199, 26);
		contentPane.add(lblaccno1);
		
		JLabel lbltype1 = new JLabel("");
		lbltype1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltype1.setBounds(803, 414, 199, 26);
		contentPane.add(lbltype1);
		
		JLabel lblifsc1 = new JLabel("");
		lblifsc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblifsc1.setBounds(829, 466, 173, 26);
		contentPane.add(lblifsc1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nagpur", "Kamptee", "Kanhan", "Dharampeth", "Itwari", "Wadi ", "Hingna", "Sitaburdi"}));
		comboBox.setBounds(264, 331, 205, 22);
		contentPane.add(comboBox);
		lblname3 = new JTextField();
		lblname3.setBounds(264, 234, 205, 26);
		contentPane.add(lblname3);
		lblname3.setColumns(10);
		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String radio;
				if(rdbtn2.isSelected())
				{
					 radio=rdbtn2.getText();
				}
				else
				{
				    radio=rdbtn3.getText();
				}

                String user=lblname3.getText();

				String num=lblid.getText();

				long acc=(long) (Math.random()*100000000000L)+1;
				String acc1=Long.toString(acc);

				HashMap<String, String> ifscMap = new HashMap<>();

				ifscMap.put("Nagpur", "BKID44106");
				ifscMap.put("Hingna", "BKID44107");
				ifscMap.put("Kamptee", "BKID44108");
				ifscMap.put("Kanhan", "BKID44109");
				ifscMap.put("Dharampeth", "BKID44111");
				ifscMap.put("Itwari", "BKID44112");
				ifscMap.put("Sitaburdi", "BKID44113");
				ifscMap.put("Wadi", "BKID44113");
				String selectedCity = comboBox.getSelectedItem().toString();
				String ifscCode = ifscMap.get(selectedCity);
				System.out.println(ifscCode);
				Database db=new Database();
				db.getConnection();
				String tname=null,tid=null,tAcc=null;
				int flag=0;
				if (user.isEmpty()) {
                    JOptionPane.showMessageDialog(btnSub, "Please enter name");
                } else if (!(rdbtn2.isSelected() || rdbtn3.isSelected())) {
                    JOptionPane.showMessageDialog(btnSub, "Please select account type");
                } else if (selectedCity.equals("Select")) {
                    JOptionPane.showMessageDialog(btnSub, "Please select Branch");
                } else if (num.isEmpty()) {
                    JOptionPane.showMessageDialog(btnSub, "Please enter account Id");
                }
				else
				{  
					ResultSet result=db.readAll(num);
					
					try
					{
						while(result.next()) 
						{
							flag =1;
							tname=result.getString(1);
							tid=result.getString(7);
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				boolean ans=db.checkAcc();
				System.out.println(ans);
				if(flag==1 && ans!=true)
				{
					if(user.equalsIgnoreCase(tname) && num.equals(tid))
					{
						java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
						db.createAc(num,radio,ifscCode,acc1,date);
						tagt.setText("WELCOME TO THE iBanking FAMILY");
						title.setText("Your Account has been Created :)");
						Sbi sb=new Sbi();
						lblName.setText("Account Holder Name:");
						lblaccno.setText("Account Number:");
						lblaccid.setText("Account Id:");
						lbltype.setText("Account Type:");
						lblifsc.setText("IFSC Code:");
						lblname1.setText(user);
						lbltype1.setText(radio);
						lblaccid1.setText(num);
						lblaccno1.setText(acc1);
						lblifsc1.setText(ifscCode);
					}
					else if(user.equalsIgnoreCase(tname)==false)
					{
						JOptionPane.showMessageDialog(btnSub, "Please enter correct Name(Name Surname)");
					}
					else if(num.equals(tid)==false)
					{
						JOptionPane.showMessageDialog(btnSub, "Please enter correct account Id");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(btnSub, "Warning:You already have an Account");
					dispose();
				}
			}	
			});
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSub.setBounds(247, 442, 100, 35);
		contentPane.add(btnSub);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Name:");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(123, 232, 130, 26);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblAccountId = new JLabel("Account Id:");
		lblAccountId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountId.setBounds(108, 384, 130, 26);
		contentPane.add(lblAccountId);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel_1.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1061, 40, 89, 30);
		contentPane.add(btnNewButton);
		
		
		
	}
}

