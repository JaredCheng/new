package dao;
import DBUtil.Util;

import java.sql.*;

public class AuthDao {
    public String queryAuth(String username) {
        String authname = "";
        Connection conn = Util.getConnection();
        String sql = "select * from AUTH where username='" + username + "'";
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                authname = rs.getString("authname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, stat, conn);
        }
        return authname;
    }

    public void setAuth(String username, String authname) throws SQLException {
        String sql="insert into auth(username,AUTHNAME) values(?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= Util.getConnection();
            ps=conn.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,authname);
            ps.executeUpdate();
        }
        finally {
            Util.close(null,ps,conn);
        }
    }

    public void updateAuth(String username, String authname) throws SQLException {
        Connection conn = Util.getConnection();
        String sql = "update AUTH set AUTHNAME='"  + authname + "' where username='" + username + "'";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } finally {
            Util.close(null, stat, conn);
        }
    }
}
