package RythmeGame;

import java.sql.*;

import javax.swing.JOptionPane;

public class Database {

	Connection con = null;
	Statement stmt = null;
	String url;
	String user = "root";
	String passwd = "0000";
	
	public void updateCdkey(int cdkey, String userid) {
		url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
		}
		String insertString = "UPDATE `RythmeGame`.`cdkey` SET `userid` = '"+userid+"'WHERE (`cdkey` = '"+cdkey+"');";
		
		try {
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			stmt.executeUpdate(insertString); 	
			System.out.println("작업을 성공하였습니다.");
			JOptionPane.showMessageDialog(null, "Success");
			new RythmeGame(userid);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
		}
		finally {
        		try {
				if (stmt != null) stmt.close();
                		if (con != null) con.close();
               		} catch (Exception e) {JOptionPane.showMessageDialog(null, "Failed");}
      	 	}
	}

	public String newUser(String userid, String password,String nickname) {
		url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
			return "Failed";
		}
		String insertString = "INSERT INTO `RythmeGame`.`user` (`userid`, `nickname`, `password`) VALUES "
				+ "('"+userid+"', '"+nickname+"', '"+password+"');";
		try {
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			stmt.executeUpdate(insertString); 	
			System.out.println("작업을 성공하였습니다.");
			JOptionPane.showMessageDialog(null, "Success");
			return "Success";
			
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
		}
		finally {
        		try {
				if (stmt != null) stmt.close();
                		if (con != null) con.close();
               		} catch (Exception e) {}
      	 	}
		return "Failed";}
	
	public void sendRecord(String userid, int score, String grade, String title, int recordid) {
		url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
			return;
		}
		String insertString = "INSERT INTO `RythmeGame`.`record` (`userid`, `score`, `grade`, `musicname`, `recordid`) VALUES "
				+ "('"+userid+"', '"+score+"', '"+grade+"', '"+title+"', '"+recordid+"');";
		
		try {
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			stmt.executeUpdate(insertString); 	
			System.out.println("작업을 성공하였습니다.");
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
        		try {
				if (stmt != null) stmt.close();
                		if (con != null) con.close();
               		} catch (Exception e) {}
      	 	}}

	public void sendPlay(String userid, int musicid) {
	url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch(java.lang.ClassNotFoundException e) {
		System.err.print("ClassNotFoundException: "); 
		System.err.println(e.getMessage());
		return;
	}
	String insertString = "INSERT INTO `RythmeGame`.`play` (`userid`, `musicid`) VALUES "
			+ "('"+userid+"', '"+musicid+"');";
	
	try {
		con = DriverManager.getConnection(url, user, passwd);
		stmt = con.createStatement();
		stmt.executeUpdate(insertString); 	
		System.out.println("작업을 성공하였습니다.");
	} catch(SQLException ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}
	finally {
    		try {
			if (stmt != null) stmt.close();
            		if (con != null) con.close();
           		} catch (Exception e) {}
  	 	}}

	public void musicAdd(int musicid, String title, String singer) {
		url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
			return;
		}
		String insertString = "INSERT INTO `RythmeGame`.`music` (`musicid`, `musicname`, `singer`) VALUES "
				+ "('"+user+"', '"+musicid+"');";
		
		try {
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			stmt.executeUpdate(insertString); 	
			System.out.println("작업을 성공하였습니다.");
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
	    		try {
				if (stmt != null) stmt.close();
	            		if (con != null) con.close();
	           		} catch (Exception e) {}
	  	 	}
	}

	public String getPassword(String userid) {
		url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");    
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println("드라이버 로딩 오류: " + e.getMessage());
			return "fail";
		} 
		try {
			con = DriverManager.getConnection(url, user, passwd); 
			stmt = con.createStatement(); 
		
			ResultSet result = stmt.executeQuery("SELECT password FROM user WHERE userid = \""+userid+"\";"); 
			result.next();
			String password = result.getString("password");
			stmt.close();
			con.close();
			return password;
		} catch(SQLException ex) {
			System.err.println("Select 오류: " + ex.getMessage());
		}
		return "fail";
	}

	public String getCdkeyResult(String userid) {
		url  = "jdbc:mysql://127.0.0.1:3306/RythmeGame";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");    
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println("드라이버 로딩 오류: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
			return "Failed";
		} 
		try {
			con = DriverManager.getConnection(url, user, passwd); 
			stmt = con.createStatement(); 
		
			ResultSet result = stmt.executeQuery("SELECT userid FROM cdkey WHERE userid = \""+userid+"\";"); 
			result.next();
			String useridConfirmed = result.getString("userid");
			stmt.close();
			con.close();
			if(userid.equals(useridConfirmed)) {
			JOptionPane.showMessageDialog(null, "Cdkey Confirmed");
			return "Success";
			}
		} catch(SQLException ex) {
			System.err.println("Select 오류: " + ex.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
			return "Failed";
		}
		return "Failed";
	}
	
	public static void main(String [] args) {
		Database db = new Database();
		db.sendPlay("user1", 1);
	}

}