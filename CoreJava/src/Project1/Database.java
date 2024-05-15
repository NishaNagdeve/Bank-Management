package Project1;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class Database {
	
Connection con = null;
	
	public void getConnection()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbi", "root","");
			
			System.out.println("connection established!!!!!!\n");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public void addcolumn()
	{
		
		try
		{
            Statement st = con.createStatement();
			
			String sql = "alter table userinfo add Acc_Created datetime(6)";
			st.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	ResultSet readData(String email)
	{	
		getConnection();
		ResultSet rs=null;
		try
		{
			Statement st = con.createStatement();
			
			String sql = "select * from userinfo where email = '"+email+"'";
			rs=st.executeQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public int insertDataUser(String name, String email, String mob,String pass,String Id,String gov)
	{
		getConnection();
		int res=0;
		
		try
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO userinfo (name, password, Mobile,email,GovId,IdNum) VALUES (?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, mob);
			ps.setString(4, email);
			ps.setString(5, gov);
			ps.setString(6, Id);
			res = ps.executeUpdate();
			System.out.println("res : "+res);
			System.out.println("Data Inserted Succesfully");
			res=1;
			return res;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	public void createAc(String id, String type, String ifsc, String acc,Timestamp date) {
	    
	    try {
	        
	            PreparedStatement ps = con.prepareStatement("UPDATE userinfo SET AccType=?, AccNo=?, Ifsc=?,Acc_Created=? WHERE AccId=?");
	            ps.setString(1, type);
	            ps.setString(2, acc);
	            ps.setString(3, ifsc);
	            ps.setTimestamp(4, date);
	            ps.setString(5, id);
	            ps.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  
	}
	public  void updateId(String id,String email) {
	    try {
	            PreparedStatement ps = con.prepareStatement("UPDATE userinfo SET AccId=? WHERE email=?");
	            ps.setString(1, id);
	            ps.setString(2, email);
	            ps.executeUpdate();
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public ResultSet readAll(String id)
	{	
		getConnection();
		ResultSet rs=null;
		try
		{
			Statement st = con.createStatement();
			
			String sql = "select * from userinfo where AccId = '"+id+"'";
			rs=st.executeQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	public boolean checkAcc()
	{	
		boolean ans = false;
		try
		{
			Statement st = con.createStatement();
			
			String sql = "select * from userinfo";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String tAcc=rs.getString(8);
				if(tAcc.isEmpty() || tAcc=="NULL")
				{
					 ans=true;           
				}
				else 
				{
					ans= false;
				}
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		   return ans;
		
	}
	public void deposit(String accId,String amt)
	{
		getConnection();
		try
		{
			String sql="update userinfo set deposit=IFNULL(deposit, 0)+?,Balance=IFNULL(Balance, 0)+? where AccId=? ";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setString(1, amt);
		    ps.setString(2, amt);
		    ps.setString(3, accId);
		    ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void withdraw(String accId,String amt)
	{
		getConnection();
		try
		{
			String sql="update userinfo set withdrawal=IFNULL(withdrawal, 0)+?,Balance=IFNULL(Balance, 0)-? where AccId=? ";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setString(1, amt);
		    ps.setString(2, amt);
		    ps.setString(3, accId);
		    ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void history(String id,String type,Timestamp date,String amt)
	{
		try
		{
			String sql="insert into history (AccId,Type,Amount,Date) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
		    ps.setString(1, id);
		    ps.setString(2, type);
		    ps.setString(3, amt);
		    ps.setTimestamp(4, date);
		    ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	public ResultSet readIt(String id)
	{
		getConnection();
		ResultSet rs=null;
		try
		{
			
			String sql="select * from history where AccId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public void transfer(String amt,String id1)
	{
	    try
	    {
	    	String sql="update userinfo set SendMoney=IFNULL(SendMoney, 0)+?,Balance=IFNULL(Balance, 0)-? where AccId=?";
	    	PreparedStatement ps=con.prepareStatement(sql);
	    	ps.setString(1, amt);
	    	ps.setString(2, amt);
	    	ps.setString(3, id1);
            ps.executeUpdate();
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	public ResultSet forgot(String adnum)
	{	
		getConnection();
		ResultSet rs=null;
		try
		{
			
			String sql = "select * from userinfo where IdNum = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, adnum);
			rs=ps.executeQuery();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	public static void main(String[] args) {
//		Database ds=new Database();
//		ds.getConnection();
//		ds.addcolumn();
	}

}
