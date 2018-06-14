package kh.web.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "kh";
		String dbPw = "kh";					
		Connection con = DriverManager.getConnection(url, dbId, dbPw);
		return con;	
	}
	
	public int insertData(String name, String msg) throws Exception{
		Connection con = this.getConnection();
		String sql = "insert into message values(message_seq.nextval,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, name);
		pstat.setString(2, msg);
		int result = pstat.executeUpdate();
		pstat.close();
		con.close();
		
		return result;		
	}
	
	public List<MessageDTO> selectData() throws Exception{
		Connection con = this.getConnection();
		String sql = "select * from message";
		PreparedStatement pstat = con.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		List<MessageDTO> result = new ArrayList<>();
		while(rs.next()) {
			MessageDTO tmp = new MessageDTO();
			tmp.setName(rs.getString(2));
			tmp.setMsg(rs.getString(3));
			result.add(tmp);
		}
		
		pstat.close();
		con.close();
		
		return result;
	}
	
}
