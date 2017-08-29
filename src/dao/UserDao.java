package dao;

import DBUtil.Util;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public void saveUser(User user) throws SQLException {
        String sql="insert into newsuser(username,password,id,addr,glass,tel) values(?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= Util.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getId());
            ps.setString(4,user.getAddr());
            ps.setInt(5,user.getGlass());
            ps.setString(6,user.getTel());
            ps.executeUpdate();
        }
       finally {
            Util.close(null,ps,conn);
        }

    }

    //查询全部用户
    public ArrayList<User> query() {
        ArrayList<User> al = new ArrayList<User>();
        Connection conn = Util.getConnection();
        String sql = "select * from newsuser";
        Statement stat = null;
        ResultSet rs=null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String id = rs.getString("id");
                String addr = rs.getString("addr");
                int glass = rs.getInt("glass");
                String tel = rs.getString("tel");
                User s = new User(username, password, id, addr, glass, tel);
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs,stat,conn);
        }
        return al;
    }

    public boolean login(String username, String password) {
        Connection conn = Util.getConnection();
        String sql = "select * from newsuser where username='" + username + "'and password='" + password + "'";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> query(String username) {
        ArrayList<User> al = new ArrayList<User>();
        Connection conn = Util.getConnection();
        String sql = "select * from newsuser where username='"+username+"'";
        Statement stat = null;
        ResultSet rs=null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String password = rs.getString("password");
                String id = rs.getString("id");
                String addr = rs.getString("addr");
                int glass = rs.getInt("glass");
                String tel = rs.getString("tel");
                User s = new User(username, password, id, addr, glass, tel);
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs,stat,conn);
        }
        return al;
    }

    public void update(User p, String username) throws SQLException {
        Connection conn = Util.getConnection();
        conn.setAutoCommit(false);
        String sql = "update NEWSUSER set password='" + p.getPassword() + "',id='" + p.getId() + "',addr='" + p.getAddr() + "',glass=" + p.getGlass() + ",tel='" + p.getTel() + "' where username='" + username + "'";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } finally {
            Util.close(null, stat, conn);
        }
    }

    public boolean delete(String username) throws SQLException {
        Connection conn = Util.getConnection();
        String sql = "delete from newsuser where username= '" + username + "'";
        conn.setAutoCommit(false);
        Statement stat = null;
        boolean flag = false;
        try {
            stat = conn.createStatement();
            flag = stat.executeUpdate(sql) == 0 ? false : true;
            System.out.println("删除成功");
        } catch (SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        } finally {
            if (flag)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
            Util.close(null,stat,conn);
        }
        return flag;
    }

  /*  public  ArrayList<User> Detailquery(User user) {
        ArrayList<PoMain> al=new ArrayList<PoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from NEWSUSER where 1=1";
        if(!(user.getId().equals(""))||!(user.getGlass()==0||!(user.getAddr().equals(""))||!(user.getUsername().equals("")))||!(user.getTel().equals("")))
        {
            sql = sql + " and paytime > '" + inout.getBegin() + "' and paytime < '" + inout.getEnd() + "'";
            }
        Statement stat = null;
        ResultSet rs=null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String id = rs.getString("id");
                String addr = rs.getString("addr");
                int glass = rs.getInt("glass");
                String tel = rs.getString("tel");
                User s = new User(username, password, id, addr, glass, tel);
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.Util.close(rs,stat,conn);
        }
        return al;
    }*/

}
