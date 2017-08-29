package com.action;

import DBUtil.Util;
import dao.NewDao;
import mapper.NewsMapper;
import model.New;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAction extends BaseAction {
    private New onenew;
    private int newid;
    private ArrayList<New> news;

    public int getNewid() {
        return newid;
    }

    public void setNewid(int newid) {
        this.newid = newid;
    }



    public ArrayList<New> getNews() {
        return news;
    }

    public void setNews(ArrayList<New> news) {
        this.news = news;
    }

    public New getOnenew() {
        return onenew;
    }

    public void setOnenew(New onenew) {
        this.onenew = onenew;
    }


    public String add(){
        onenew.setAuthor((String)request.getSession().getAttribute("username"));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        onenew.setCreateTime(simpleDateFormat.format(new Date()));
        //new NewDao().saveNew(onenew);
        SqlSession ss;
        try {
            ss = Util.getSqlSession();
            NewsMapper nm = ss.getMapper(NewsMapper.class);
            nm.insert(onenew);
            ss.commit();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "addnewsuccess";
    }

    public String query() {
        String username= (String) request.getSession().getAttribute("username");
        news=new NewDao().query();
        return "querynews";
    }

    public String querydetail() {
        System.out.println("新闻编号:"+newid);
        news=new NewDao().querydetail(newid);
        return "querydetail";
    }
    public String editnew() {
        news=new NewDao().querydetail(newid);
        //显示修改前内容
        return "editnew";
    }

    public String edited() {
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            onenew.setCreateTime(simpleDateFormat.format(new Date()));
            new NewDao().update(onenew,onenew.getNewid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "editednew";
    }
    public String del() {
        try {
            new NewDao().delete(newid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "delsuccess";
    }
    public String selectquery() {
        try {
            SqlSession ss = Util.getSqlSession();
            NewsMapper nm = ss.getMapper(NewsMapper.class);
            news=nm.selectSelective(onenew);
            System.out.println(news.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "selectquery";
    }
}
