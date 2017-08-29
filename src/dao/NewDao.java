package dao;

import DBUtil.Util;
import model.New;
import java.sql.*;
import java.util.ArrayList;

public class NewDao {
    public void saveNew(New onenew) throws SQLException {
        String sql="insert into news(newid,context,author,pic,createTime,title,newlevel) values(?,?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= Util.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(onenew.getNewid()));
            ps.setString(2,onenew.getContext());
            ps.setString(3,onenew.getAuthor());
            ps.setString(4,onenew.getPic());
            ps.setString(5,onenew.getCreateTime());
            ps.setString(6,onenew.getTitle());
            ps.setInt(7,Integer.valueOf(onenew.getNewlevel()));
            ps.executeUpdate();
        }
        finally {
            Util.close(null,ps,conn);
        }

    }

    public ArrayList<New> query(String username) {
        ArrayList<New> al = new ArrayList<New>();
        Connection conn = Util.getConnection();
        String sql = "select * from news where AUTHOR='"+username+"'";
        Statement stat = null;
        ResultSet rs=null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                int newid = rs.getInt("NEWID");
                String context = rs.getString("CONTEXT");
                String author=rs.getString("author");
                String pic = rs.getString("pic");
                String createTime = rs.getString("createtime");
                String title = rs.getString("title");
                int newlevel = rs.getInt("newlevel");
                New n=new New(newid,context,author,pic,createTime,title,newlevel);
                al.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs,stat,conn);
        }
        return al;
    }

    public ArrayList<New> query() {
        ArrayList<New> al = new ArrayList<New>();
        Connection conn = Util.getConnection();
        String sql = "select * from news";
        Statement stat = null;
        ResultSet rs=null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                int newid = rs.getInt("NEWID");
                String context = rs.getString("CONTEXT");
                String author=rs.getString("author");
                String pic = rs.getString("pic");
                String createTime = rs.getString("createtime");
                String title = rs.getString("title");
                int newlevel = rs.getInt("newlevel");
                New n=new New(newid,context,author,pic,createTime,title,newlevel);
                al.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs,stat,conn);
        }
        return al;
    }

    public ArrayList<New> querydetail(int newid) {
        ArrayList<New> al = new ArrayList<New>();
        Connection conn = Util.getConnection();
        String sql = "select * from news where newid="+newid;
        Statement stat = null;
        ResultSet rs=null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String context = rs.getString("CONTEXT");
                String author=rs.getString("author");
                String pic = rs.getString("pic");
                String createTime = rs.getString("createtime");
                String title = rs.getString("title");
                int newlevel = rs.getInt("newlevel");
                New n=new New(newid,context,author,pic,createTime,title,newlevel);
                al.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs,stat,conn);
        }
        return al;
    }


    public boolean delete(int newid) throws SQLException {
        Connection conn = Util.getConnection();
        String sql = "delete from news where NEWID=" + newid ;
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

    public void update(New p, int newid) throws SQLException {
        Connection conn = Util.getConnection();
        conn.setAutoCommit(false);
        String sql = "update NEWS set CONTEXT='" + p.getContext() + "',AUTHOR='" + p.getAuthor() + "',TITLE='" + p.getTitle() +"',PIC='" + p.getPic() + "',CREATETIME='" + p.getCreateTime() + "',NEWLEVEL=" + p.getNewlevel() + " where NEWID=" + newid;
        System.out.println(sql);
        Statement stat = null;
        try {
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } finally {
            Util.close(null, stat, conn);
        }
    }
}
