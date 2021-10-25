package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean login(String username, String password) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from users where username='" + username
				+ "'";
		PreparedStatement ps;
		boolean res = false;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				try {
					if(password.equals(rs.getString(2)))
						res = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				con.close();
				return res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
