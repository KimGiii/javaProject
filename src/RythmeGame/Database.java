package RythmeGame;

import java.sql.*;

import javax.swing.JOptionPane;

public class Database {
	
	Connection conn = null;
	Statement stmt = null;
	String url;
	String user = "root";
	String passwd = "0000";
	
	public void updateCdkey(int cdkey, String userid) {
		url = " ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
		}
		String insertString = "UPDATE 'RythmeGame'.'cdkey' SET 'userid' = '"+userid+"'WHERE ('cdkey' = '"+cdkey+"');";
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
			stmt.executeUpdate(insertString);
			System.out.println("작업을 성공하였습니다.");
			JOptionPane.showMessageDialog(null, "success");
			new RythmeGame(userid);
		} catch(SQLException ex) {
			System.err.println("SQLException: "+ ex.getMessage());
			JOptionPane.showMessageDialog(null, "Failed");
		}
		finally {
			try {
				if (stmt != null) stmt.close();
					if (conn != null) conn.close();
			} catch(Exception e) {JOptionPane.showMessageDialog(null, "Failed"); }
		}
	}
	
	public String newUser(String userid, String password, String nickname) {
		url = " ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			return "Failed";
		}
		String insertString = "INSERT INTO 'rythmegame'.'user' ('userid', 'nickname', 'password') VALUES"+"("+userid+"'.'"+nickname+"','"+password+"');";
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
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
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return "Failed";
	}
	
	public void sendRecord(String  userid, int score, String grade, String title, int recordid) {
		url = "";
		
		try {
			Class.forName("");
		} catch(ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			return;
		}
		String insertString = "INSERT INTO 'rythmegame'.'record' ('userid','score','grade','musicname','recordid') VALUES "+"('"+userid+"'.'"+score+"','"+grade+"'.'"+title+"'.'"+recordid+"');";
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
			stmt.executeUpdate(insertString);
			System.out.println("작업을 성공하였습니다.");
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	public void sendPlay(String userid, int musicid) {
		url = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			return;
		}
		String insertString = "INSERT INTO 'rythmegame'.'record' ('userid','musicid') VALUES "+"('"+userid+"'.'"+musicid+"');";
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			stmt = conn.createStatement();
			stmt.executeUpdate(insertString);
			System.out.println("작업을 성공하였습니다.");
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	
}
