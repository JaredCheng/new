package test;
import DBUtil.Util;
import mapper.NewsMapper;
import mapper.NewsuserMapper;
import model.New;
import model.User;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.ArrayList;



public class test {
    public static void main(String[] args) throws IOException {
        SqlSession ss = Util.getSqlSession();
        NewsMapper nm = ss.getMapper(NewsMapper.class);
        New n=new New();
       n.setCreateTime("2017-08-15");
        n.setPic("adfadf");
        n.setNewlevel(3);
        n.setTitle("adfadfad");
        n.setContext("asdfasdfasdaf");
        n.setNewid(2);
        n.setAuthor("ctq");
        nm.insert(n);
        ss.commit();
        ss.close();
    }
}

