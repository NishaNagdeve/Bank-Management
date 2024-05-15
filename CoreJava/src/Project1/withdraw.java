package Project1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnum;
	private JTextField txtamt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw();
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
	public withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\bank.jpg"));
		lblNewLabel.setBounds(28, 29, 130, 140);
		contentPane.add(lblNewLabel);
	
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBackground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(21, 44, 187, 41);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblttl = new JLabel("");
        lblttl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblttl.setHorizontalAlignment(SwingConstants.CENTER);
        lblttl.setBounds(456, 484, 446, 41);
        contentPane.add(lblttl);
        
        JLabel lblNewLabel_1 = new JLabel("WITHDRAW MONEY");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(572, 126, 243, 30);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("ACCOUNT ID:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(449, 195, 190, 30);
        contentPane.add(lblNewLabel_3);
        
       
        JLabel lblNewLabel_3_1 = new JLabel("ACCOUNT NUMBER:");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(449, 259, 190, 30);
        contentPane.add(lblNewLabel_3_1);
        
        JButton btnw = new JButton("Withdraw");
        btnw.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id1=txtid.getText();
        		String amt=txtamt.getText();
        		String ac=txtnum.getText();
        		Database ds=new Database();
        		ResultSet rs=ds.readAll(id1);
        		String acc1=null;
        		try
        		{
        			if(rs.next())
        			{
        				acc1=rs.getString(8);
        				if(id1.isEmpty() || amt.isEmpty() || ac.isEmpty())
                        {
                        	JOptionPane.showMessageDialog(btnw, "Enter Required Fields!!!!");
                        }
                       
                        else if(Sbi.name.equals(id1) && acc1 !=null )
            			{
                        	
                    		double bal = 0;
                    		String bal1=null;
                    		
                    				bal=Integer.parseInt(rs.getString(11));
                    				bal1=rs.getString(11);
                    			
                            int amt1=Integer.parseInt(amt);
                            
                        	if(bal<amt1 && bal1==null)
                    		{
                    			lblttl.setText("Warning:Balance is minimum then Deposit some amount");
                    		}
                    		else if(bal-amt1<=1000)
                    		{
                    			lblttl.setText("Warning:Balance should be minimun 1000Rs");
                    		}
                    		else
                    		{
            			        ds.withdraw(id1,amt);
                		        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                		        String type="witdraw";
            		            lblttl.setText("AMOUNT WITHDRAW SUCCESFULLY");
            		            ds.history(id1,type,date,amt);
                    		}
            		   }
                			else
                			{
                				JOptionPane.showMessageDialog(btnw, "Invalid Information");
                				txtid.setText("");
                				txtamt.setText("");
                				txtnum.setText("");
                			}
                	}
        		}
        			catch(Exception ex)
            		{
            			ex.printStackTrace();
            		}
        		}
        			   
        });
        btnw.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnw.setBounds(607, 411, 135, 35);
        contentPane.add(btnw);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("AMOUNT:");
        lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3_1_1.setBounds(449, 328, 190, 30);
        contentPane.add(lblNewLabel_3_1_1);
        
        txtid = new JTextField();
        txtid.setBounds(673, 195, 241, 30);
        contentPane.add(txtid);
        txtid.setColumns(10);
        
        txtnum = new JTextField();
        txtnum.setColumns(10);
        txtnum.setBounds(673, 259, 241, 30);
        contentPane.add(txtnum);
        
        txtamt = new JTextField();
        txtamt.setColumns(10);
        txtamt.setBounds(673, 328, 241, 30);
        contentPane.add(txtamt);
        
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Sbi sb=new Sbi();
        		sb.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setBounds(1039, 40, 89, 30);
        contentPane.add(btnNewButton);
        
        JButton btnHome = new JButton("Home");
        btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Sbi1 sb=new Sbi1();
        		sb.setVisible(true);
        		dispose();
        	}
        });
        btnHome.setBounds(940, 40, 89, 30);
        contentPane.add(btnHome);
	}

}
