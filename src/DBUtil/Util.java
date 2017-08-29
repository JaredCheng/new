package DBUtil;

import oracle.jdbc.pool.OracleDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Util {
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
    private static String user="c##scott";
    private static String password="tiger";
    //静态代码块,用来封装驱动程序
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("oracle Driver Failed");
        }
    }
    //静态方法:用来获取数据库的连接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setUser("c##scott");//用户名
            ods.setPassword("tiger");//用户密码
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            conn = ods.getConnection();
         System.out.println("DB Connection Succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("oracle Connection Failed");
        }
        return conn;
    }



    public static void close(ResultSet rs, Statement stat, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static SqlSession getSqlSession() throws IOException {
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Resources.getResourceAsStream("config.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建能执行映射文件中sql的sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }

}
